package command;

import app.AbstractFactory;
import communication.Response;

public class ClientExitCommand implements ClientCommand{
    @Override
    public Response execute(String fileName, AbstractFactory factory, CommandManager manager) {
        System.exit(0);
        return null;//unreachable
    }
}
