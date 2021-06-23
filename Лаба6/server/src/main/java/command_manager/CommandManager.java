package command_manager;

import communication.Request;
import communication.Response;
import object.Vehicle;

public interface CommandManager {
    Response execute(String command, String arg, Vehicle vehicle);
    Response askVehicle(String arg);
}
