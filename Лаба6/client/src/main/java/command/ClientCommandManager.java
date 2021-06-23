package command;

import app.AbstractFactory;
import communication.Request;
import communication.RequestType;
import communication.Response;
import connection.RequestSender;
import connection.ResponseReader;
import object.Vehicle;
import reader.Asker;
import reader.InputManager;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientCommandManager implements CommandManager{

    private Asker asker;
    private Set<File> scripts = new HashSet<>();
    private final AbstractFactory factory;
    private final RequestSender sender;
    private final ResponseReader reader;
    private final Map<String, ClientCommand> commandMap;

    private static final int DEFAULT_BUFFER_SIZE = 65536;
    private static final int TIMEOUT = 5000;
    private static SocketAddress socketAddress;
    private static DatagramSocket datagramSocket;

    public ClientCommandManager(Asker asker, AbstractFactory factory, RequestSender sender, ResponseReader reader, Map<String, ClientCommand> clientCommands) {
        this.asker = asker;
        this.factory = factory;
        this.sender = sender;
        this.reader = reader;
        this.commandMap = clientCommands;
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
    public void startCommand(String[] userCommand) {
        String command = userCommand[0];//Если длина массива = 1, то это команда без аргументов, а если более, то аргументу присваивается userCommand[1].
        String argument;
        if(userCommand.length == 1)
            argument = "";
        else
            argument = userCommand[1];
        if(commandMap.containsKey(command)) {
            executeClientCommand(command, argument);
        }
        else {
            try {
                if(askVehicle(command)) {
                    Vehicle vehicle;
                    try {
                        vehicle = asker.createVehicle();
                    } catch (Exception e) {
                        System.err.println("Ошибка при создании автомобиля.");
                        return;
                    }
                    executeCommand(command, argument, vehicle);
                } else
                    executeCommand(command, argument, null);
            } catch (IOException e) {
                System.err.println("Ошибка. Сервер временно недоступен.");
            } catch (Exception e) {
                System.err.println("Ошибка при связи с сервером.");
            }
        }
    }

    private void executeClientCommand(String command, String arg) {
        if(command.equals("execute_script")) {
            executeScript(arg);
        }
        else
            commandMap.get(command).execute(arg, factory, this);
    }

    private boolean askVehicle(String commandName) throws IOException, ClassNotFoundException {
        Request request = factory.getRequest(RequestType.ASK_VEHICLE, commandName, null, null);
        sender.send(request, socketAddress, datagramSocket);
        Response response = reader.readResponse(datagramSocket, DEFAULT_BUFFER_SIZE, TIMEOUT);
        return Boolean.parseBoolean(response.getMessage());
    }

    private void executeCommand(String commandName, String arg, Vehicle vehicle) throws IOException, ClassNotFoundException {
        Request request = factory.getRequest(RequestType.EXECUTE, commandName, arg, vehicle);
        sender.send(request, socketAddress, datagramSocket);
        Response response = reader.readResponse(datagramSocket, DEFAULT_BUFFER_SIZE, TIMEOUT);
        if(response.isSuccessful())
            System.out.println(response.getMessage());
        else
            System.err.println(response.getMessage());
    }

    public void connect(String host, int port) {
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println("Подключение к " + inetAddress);
            socketAddress = new InetSocketAddress(inetAddress, port);
            datagramSocket = new DatagramSocket();
            datagramSocket.connect(socketAddress);
        } catch (UnknownHostException | SocketException e) {
            System.err.println("Ошибка. Сервер временно недоступен.");
        }
    }

    private void executeScript(String fileName) {
        File scriptFile = new File(fileName);
        if(scripts.contains(scriptFile)) {
            System.err.println("Ошибка. Файл " + fileName + " содержит рекурсию.");
            return;
        }
        scripts.add(scriptFile);
        commandMap.get("execute_script").execute(fileName, factory, this);
        scripts.remove(scriptFile);
    }
}
