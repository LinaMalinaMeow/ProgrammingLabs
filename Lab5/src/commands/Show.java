package commands;

import app.Repository;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class Show extends AbstractCommand implements Command {
    private Repository repository;

    public Show (Repository repository) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.repository = repository;
    }

    @Override
    public void execute(String str) {
        if(this.repository.getPriorityQueue().size() == 0){
            System.out.println("Коллекция пуста");
            return;
        }
        this.repository.getPriorityQueue().forEach(vehicle -> {
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
