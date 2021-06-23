package reader;

import command.CommandManager;
import communication.Response;
//выполнение запросов
public class GUIAdapterImpl implements GUIAdapter{

    private final CommandManager commandManager;

    public GUIAdapterImpl(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public Response getResponse(String commandStr) {
        String[] command = (commandStr.trim() + " ").split(" ", 2);
        command[1] = command[1].trim();
        return commandManager.startCommand(command);
    }
}
