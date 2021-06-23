package reader;

import communication.User;
import object.Vehicle;
import object.VehicleBuilder;

import java.util.Scanner;

public abstract class AbstractAsker implements Asker{
    protected Scanner userScanner;
    protected VehicleBuilder vehicleBuilder;
    protected User user;

    public AbstractAsker(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    @Override
    public void setVehicleBuilder(VehicleBuilder vehicleBuilder) {
        this.vehicleBuilder = vehicleBuilder;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
