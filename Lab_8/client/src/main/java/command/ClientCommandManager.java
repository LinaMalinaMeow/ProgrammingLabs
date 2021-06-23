package command;

import app.AbstractFactory;
import app.AuthModule;
import communication.*;
import connection.RequestSender;
import connection.ResponseReader;
import exceptions.BuildException;
import exceptions.LoginException;
import message.MessageManager;
import object.Vehicle;
import reader.Asker;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ClientCommandManager implements CommandManager{

    private Asker asker;
    private Set<File> scripts = new HashSet<>();
    private final AbstractFactory factory;
    private final RequestSender sender;
    private final ResponseReader reader;
    private final Map<String, ClientCommand> commandMap;
    private final Map<String, AuthCommand> authCommands;
    private final AuthModule authModule;

    private static final int DEFAULT_BUFFER_SIZE = 65536;
    private static final int TIMEOUT = 5000;
    private static SocketAddress socketAddress;
    private static DatagramSocket datagramSocket;
    private User user;
    private final String host;
    private final int port;

    public ClientCommandManager(Asker asker, AbstractFactory factory, RequestSender sender, ResponseReader reader, Map<String, ClientCommand> clientCommands, AuthModule authModule, Map<String, AuthCommand> authCommands, String host, int port) {
        this.asker = asker;
        this.factory = factory;
        this.sender = sender;
        this.reader = reader;
        this.commandMap = clientCommands;
        this.authModule = authModule;
        this.authCommands = authCommands;
        this.host = host;
        this.port = port;
    }

    @Override
    public void setAsker(Asker asker) {
        this.asker = asker;
    }

    @Override
    public Asker getAsker() {
        return asker;
    }

    @Override
    public Response startCommand(String[] userCommand) {
        try {
            connect(host, port);
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.connection"));
        } finally {
            datagramSocket.disconnect();
        }
        try {
            String command = userCommand[0];
            String argument;
            if(userCommand.length == 1)
                argument = "";
            else
                argument = userCommand[1];
            if(command.equals("sync"))
                return sync();
            if(commandMap.containsKey(command)) {
                return executeClientCommand(command, argument);
            } else if(authCommands.containsKey(command)) {
                return executeAuthCommand(authCommands.get(command));
            }
            else {
                try {
                    connect(host, port);
                    boolean vehicleNeeded = askVehicle(command);
                    datagramSocket.disconnect();
                    if(vehicleNeeded) {
                        Vehicle vehicle;
                        try {
                            vehicle = asker.createVehicle();
                        } catch (BuildException e) {
                            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.build"));
                        } catch (Exception e) {
                            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.connection"));
                        }
                        connect(host, port);
                        Response response = executeCommand(command, argument, vehicle);
                        datagramSocket.disconnect();
                        return response;
                    } else {
                        connect(host, port);
                        Response response = executeCommand(command, argument, null);
                        datagramSocket.disconnect();
                        return response;
                    }
                } catch (IOException e) {
                    return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.connection"));
                } catch (LoginException e) {
                    return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.login"));
                } catch (Exception e) {
                    return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.unk"));
                }
            }
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.unk"));
        }
    }

    private Response executeAuthCommand(AuthCommand authCommand) {
        try {
            Request request = authCommand.execute();
            sender.send(request, socketAddress, datagramSocket);
            Response response = reader.readResponse(datagramSocket, DEFAULT_BUFFER_SIZE, TIMEOUT);
            user = authModule.getUser();
            return response;
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.connection"));
        } finally {
            datagramSocket.disconnect();
        }
    }

    private Response executeClientCommand(String command, String arg) throws IOException, ClassNotFoundException {
        if(command.equals("execute_script")) {
            return executeScript(arg);
        } else
            return commandMap.get(command).execute(arg, factory, this);
    }

    private Response sync() throws IOException, ClassNotFoundException {
        SocketAddress address;
        DatagramSocket socket;
        InetAddress iAddress = InetAddress.getByName(host);
        address = new InetSocketAddress(iAddress, port);
        socket = new DatagramSocket();
        socket.setSoTimeout(1000);
        socket.connect(socketAddress);
        connect(host, port);
        Request request = factory.getRequest(RequestType.EXECUTE, "show", null, null, user, Locale.getDefault());
        sender.send(request, address, socket);
        return reader.readResponse(socket, DEFAULT_BUFFER_SIZE, TIMEOUT);
    }

    private boolean askVehicle(String commandName) throws IOException, ClassNotFoundException {
            Request request = factory.getRequest(RequestType.ASK_VEHICLE, commandName, null, null, user, Locale.getDefault());
            sender.send(request, socketAddress, datagramSocket);
            Response response = reader.readResponse(datagramSocket, DEFAULT_BUFFER_SIZE, TIMEOUT);
            if(!response.isSuccessful())
                throw new LoginException();
            return Boolean.parseBoolean(response.getMessage());
    }

    private Response executeCommand(String commandName, String arg, Vehicle vehicle) throws IOException, ClassNotFoundException {
        Request request = factory.getRequest(RequestType.EXECUTE, commandName, arg, vehicle, user, Locale.getDefault());
        sender.send(request, socketAddress, datagramSocket);
        return reader.readResponse(datagramSocket, DEFAULT_BUFFER_SIZE, TIMEOUT);
    }

    public void connect(String host, int port) throws UnknownHostException, SocketException {
            InetAddress inetAddress = InetAddress.getByName(host);
            socketAddress = new InetSocketAddress(inetAddress, port);
            datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(1000);
            datagramSocket.connect(socketAddress);
    }

    private Response executeScript(String fileName) {
        File scriptFile = null;
        try {
            scriptFile = new File(fileName);
            if(scripts.contains(scriptFile)) {
                return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.script_rec"));
            }
            scripts.add(scriptFile);
            return commandMap.get("execute_script").execute(fileName, factory, this);
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.script"));
        } finally {
            scripts.remove(scriptFile);
        }
    }
}
