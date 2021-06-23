package command;

import app.AbstractFactory;
import communication.Response;
import reader.InputManager;

public interface ClientCommand {
    Response execute(String fileName, AbstractFactory factory, CommandManager manager);
}
