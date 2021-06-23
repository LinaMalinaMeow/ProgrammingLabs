package connection;

import app.AbstractFactory;
import command_manager.CommandManager;
import communication.Request;
import communication.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerConnectionManager implements ConnectionManager {

    private SocketAddress address;
    private final int port;
    private final int CONNECTION_ATTEMPT_CNT = 100000;
    private final int DEFAULT_BUFFER_SIZE = 65536;
    private final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    private final DatagramChannel channel;
    private final CommandManager commandManager;
    private final ResponseSender sender;
    private final RequestReader reader;
    private final AbstractFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(ServerConnectionManager.class);

    public ServerConnectionManager(int port, CommandManager commandManager, RequestReader reader, ResponseSender sender, AbstractFactory factory) throws IOException {
        this.port = port;
        this.commandManager = commandManager;
        this.reader = reader;
        this.sender = sender;
        this.factory = factory;
        channel = DatagramChannel.open();
        channel.configureBlocking(false);
        try {
            channel.bind(new InetSocketAddress(this.port));
        } catch (BindException e) {
            System.out.println("Порт уже используется другим приложением.");
            System.exit(1);
        }
    }

    private byte[] accept() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
        int cnt = 0;
        do {
            address = channel.receive(byteBuffer);
            cnt++;
        } while (address == null && cnt < CONNECTION_ATTEMPT_CNT);
        return buffer;
    }

    @Override
    public void manageConnection() {
        Request request;
        try {
            byte[] buffer = accept();
            if(address == null)
                return;
            logger.debug("Соединение с клиентом установлено.");
            request = reader.deserializeRequest(buffer);
            Response response;
            try {
                response = processRequest(request);
            } catch (Exception e) {
                response = factory.getResponse(false, "Ошибка при обработке запроса.");
            }
            try {
                sender.sendResponse(response, address, channel);
                logger.debug("Ответ клиенту отправлен.");
            } catch (IOException e) {
                logger.error("Ошибка при отправке ответа на запрос.");
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Ошибка при чтении запроса.");
        }
    }

    private Response processRequest(Request request) {
        switch (request.getType()) {
            case EXECUTE:
                return commandManager.execute(request.getCommand(), request.getArg(), request.getVehicle());
            case ASK_VEHICLE:
                return commandManager.askVehicle(request.getCommand());
            default:
                return factory.getResponse(false, "Ошибка. Неизвестный тип запроса.");
        }
    }
}
