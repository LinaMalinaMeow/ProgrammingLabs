package command;

import communication.Response;
import reader.Asker;
import reader.InputManager;

import java.net.SocketException;
import java.net.UnknownHostException;

public interface CommandManager {
    Response startCommand(String[] userCommand);
    void setAsker(Asker asker);
    void connect(String host, int port) throws UnknownHostException, SocketException;
    Asker getAsker();
}
