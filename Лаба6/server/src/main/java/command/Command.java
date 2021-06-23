package command;

import communication.Response;
import object.Vehicle;

public interface Command {
    Response execute(String str, Vehicle vehicle);
}
