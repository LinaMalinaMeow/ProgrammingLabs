package communication;

import object.Vehicle;

import java.io.Serializable;

public class RequestImpl implements Request, Serializable {
    private final RequestType type;
    private final String command;
    private final Vehicle vehicle;
    private final String arg;

    public RequestImpl(RequestType type, Vehicle vehicle, String command, String arg) {
        this.type = type;
        this.vehicle = vehicle;
        this.command = command;
        this.arg = arg;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public RequestType getType() {
        return type;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getArg() {
        return arg;
    }
}
