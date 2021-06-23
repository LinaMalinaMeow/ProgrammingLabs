package reader;

import communication.User;
import object.Vehicle;
import object.VehicleBuilder;

public interface Asker {
    Vehicle createVehicle();
    User readUser();
    void setVehicleBuilder(VehicleBuilder vehicleBuilder);
    void setUser(User user);
}
