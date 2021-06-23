package commands;

import app.Repository;
import data.Vehicle;

import java.util.ArrayList;

public class PrintAscending extends AbstractCommand implements Command {
    private Repository repository;

    public PrintAscending(Repository repository) {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        this.repository = repository;
    }

    @Override
    public void execute(String string) {
        ArrayList<Vehicle> ascVehicles = repository.getAscVehicles();
        ascVehicles.forEach(vehicle -> {
            System.out.println("\n\tID: " + vehicle.getId() +
                    "\n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelTypeString());
        });
    }
}
