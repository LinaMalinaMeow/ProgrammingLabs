package reader;

import communication.User;
import object.Vehicle;

import java.util.Date;
import java.util.Random;
//Передача user и vehicleBuilder напрямую. При создании читаем из полей GUI, а не из консоли

public class GUIAsker extends AbstractAsker{

    public GUIAsker() {
        super(null);
    }

    @Override
    public Vehicle createVehicle() {
        vehicleBuilder.setId(new Random().nextInt(Integer.MAX_VALUE));
        vehicleBuilder.setCreationDate(new Date());
        return vehicleBuilder.buildId();
    }

    @Override
    public User readUser() {
        return user;
    }
}
