package command_manager;

import communication.Response;
import communication.User;
import object.Vehicle;

import java.util.Locale;

public interface CommandManager {
    Response execute(String command, String arg, Vehicle vehicle, User user, Locale locale);
    Response askVehicle(String arg, User user, Locale locale);
}
