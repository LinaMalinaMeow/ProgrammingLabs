package command_manager;

import app.AbstractFactory;
import collection.CollectionManager;
import command.Command;
import communication.Response;
import connection.ServerConnectionManager;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

public class ServerCommandManager implements CommandManager{
    private final Map<String, Command> commandMap;
    private final Set<String> vehicleCommands;
    private final AbstractFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(ServerCommandManager.class);

    public ServerCommandManager(Map<String, Command> commands, AbstractFactory factory, Set<String> vehicleCommands) {
        this.commandMap = commands;
        this.vehicleCommands = vehicleCommands;
        this.factory = factory;
    }

    @Override
    public Response execute(String commandStr, String arg, Vehicle vehicle) {
        Command command = commandMap.get(commandStr);
        if(command == null) {
            logger.debug("Получена неизвестная команда: " + commandStr);
            return factory.getResponse(false, "Неизвестная команда.");
        }else {
            logger.debug("Выполнена команда: " + commandStr);
            return command.execute(arg, vehicle);
        }
    }

    @Override
    public Response askVehicle(String command) {
        logger.debug("Выполнен запрос ASK_VEHICLE для " + command);
        return factory.getResponse(true, String.valueOf(vehicleCommands.contains(command)));
    }
}
