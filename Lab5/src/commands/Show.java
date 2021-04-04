package commands;

import app.Collection;
import data.Vehicle;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class Show extends AbstractCommand implements Command {
    private app.Collection collection;

    public Show (Collection collection) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collection = collection;
    }

    @Override
    public void execute(String str) {
        this.collection.getPriorityQueue().forEach(vehicle -> {
            System.out.println("\n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelType());
        });
    }
}
