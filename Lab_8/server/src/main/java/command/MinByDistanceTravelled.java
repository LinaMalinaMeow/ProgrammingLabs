package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;
import object.VehicleDisplayer;

import java.util.Locale;

public class MinByDistanceTravelled extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;
    private VehicleDisplayer vehicleDisplayer;

    public MinByDistanceTravelled(CollectionManager repository, AbstractFactory factory, VehicleDisplayer vehicleDisplayer){
        super("min_by_distance_travelled", " вывести любой объект из коллекции, значение поля distanceTravelled которого является минимальным");
        this.repository = repository;
        this.factory = factory;
        this.vehicleDisplayer = vehicleDisplayer;
    }

    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale){
        Vehicle res = this.repository.getVehicleMinDistanceTravelled();
        if(res == null){
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.no_such"));
        }
        else
            return factory.getResponse(true,MessageManager.getInstance().getLocalMessages(locale).getString("vehicle.min_dist") + vehicleDisplayer.displayVehicle(res, locale));
    }
}
