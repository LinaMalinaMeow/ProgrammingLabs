package communication;

import object.Vehicle;

import java.io.Serializable;
import java.util.Locale;

public class RequestImpl implements Request, Serializable {
    private final RequestType type;
    private final String command;
    private final Vehicle vehicle;
    private final String arg;
    private final User user;
    private final Locale locale;

    public RequestImpl(RequestType type, Vehicle vehicle, String command, String arg, User user, Locale locale) {
        this.type = type;
        this.vehicle = vehicle;
        this.command = command;
        this.arg = arg;
        this.user = user;
        this.locale = locale;
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

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", command='" + command + '\'' +
                ", vehicle=" + vehicle +
                ", arg='" + arg + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public Locale getLocale() {
        return locale;
    }
}
