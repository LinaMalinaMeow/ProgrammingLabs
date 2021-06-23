package object;

import message.MessageManager;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class VehicleDisplayerImpl implements VehicleDisplayer{
    @Override
    public String displayVehicle(Vehicle vehicle, Locale locale) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return  MessageManager.getInstance().getLocalMessages(locale).getString("label.id") + vehicle.getId() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.name") + vehicle.getName() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.x") + vehicle.getCoordinates().getX() + ", " + MessageManager.getInstance().getLocalMessages(locale).getString("label.y")  + vehicle.getCoordinates().getY() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.engine_power") + vehicle.getEnginePower() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.num_of_wheels") + vehicle.getNumberOfWheels() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.dist") + vehicle.getDistanceTravelled() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.fuel_type") + vehicle.getFuelTypeString() + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.creation_date") + format.format(vehicle.getCreationDate()) + "\n" +
                MessageManager.getInstance().getLocalMessages(locale).getString("label.username") + vehicle.getUsername();
    }
}
