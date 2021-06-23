package communication;

import object.Vehicle;

import java.util.Locale;

public interface Request {
    RequestType getType();
    Vehicle getVehicle();
    String getArg();
    String getCommand();
    User getUser();
    Locale getLocale();
}
