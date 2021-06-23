package command;

import communication.Response;
import communication.User;
import object.Vehicle;

import java.util.Locale;

public interface Command {
    Response execute(String str, Vehicle vehicle, User user, Locale locale);
}
