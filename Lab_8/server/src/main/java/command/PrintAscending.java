package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import object.Vehicle;
import object.VehicleDisplayer;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

public class PrintAscending extends AbstractCommand implements Command {
    private final CollectionManager repository;
    private final AbstractFactory factory;
    private final VehicleDisplayer vehicleDisplayer;

    public PrintAscending(CollectionManager repository, AbstractFactory factory, VehicleDisplayer vehicleDisplayer) {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        this.repository = repository;
        this.factory = factory;
        this.vehicleDisplayer = vehicleDisplayer;
    }

    @Override
    public Response execute(String string, Vehicle v, User user, Locale locale) {
        ArrayList<Vehicle> ascVehicles = repository.getAscVehicles();
        return factory.getResponse(true, ascVehicles.stream().map(vehicle -> vehicleDisplayer.displayVehicle(vehicle, locale)).collect(Collectors.joining("\n")));
    }
}
