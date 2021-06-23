package command_manager;

import app.AbstractFactory;
import command.AuthCommand;
import command.Command;
import communication.Response;
import communication.User;
import data.AuthModule;
import message.MessageManager;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ServerCommandManager implements CommandManager{
    private final Map<String, Command> commandMap;
    private final Set<String> vehicleCommands;
    private final AbstractFactory factory;
    private final AuthModule usersDAO;
    private static final Logger logger = LoggerFactory.getLogger(ServerCommandManager.class);

    public ServerCommandManager(Map<String, Command> commands, AbstractFactory factory, Set<String> vehicleCommands, AuthModule usersDAO) {
        this.commandMap = commands;
        this.vehicleCommands = vehicleCommands;
        this.factory = factory;
        this.usersDAO = usersDAO;
    }

    @Override
    public Response execute(String commandStr, String arg, Vehicle vehicle, User user, Locale locale) {
        Command command = commandMap.get(commandStr);
        if(!(command instanceof AuthCommand) && !usersDAO.login(user))
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.no_login"));
        if(command == null) {
            logger.debug("Получена неизвестная команда: " + commandStr);
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.unk_command"));
        }else {
            logger.debug("Выполнена команда: " + commandStr);
            return command.execute(arg, vehicle, user, locale);
        }
    }

    @Override
    public Response askVehicle(String command, User user, Locale locale) {
        if(!usersDAO.login(user))
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.no_login"));
        logger.debug("Выполнен запрос ASK_VEHICLE для " + command);
        return factory.getResponse(true, String.valueOf(vehicleCommands.contains(command)));
    }
}
