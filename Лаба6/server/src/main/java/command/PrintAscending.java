package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

import java.util.ArrayList;

public class PrintAscending extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public PrintAscending(CollectionManager repository, AbstractFactory factory) {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String string, Vehicle v) {
        ArrayList<Vehicle> ascVehicles = repository.getAscVehicles();
        StringBuilder builder = new StringBuilder();
        ascVehicles.forEach(vehicle -> {
            builder.append("\n\tID: " + vehicle.getId() +
                    "\n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelTypeString());
        });
        return factory.getResponse(true, builder.toString());
    }
}
