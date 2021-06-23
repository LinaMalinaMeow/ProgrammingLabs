package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class Show extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public Show (CollectionManager repository, AbstractFactory factory) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle v) {
        if(this.repository.getPriorityQueue().size() == 0){
            return factory.getResponse(false,"Коллекция пуста");
        }
        StringBuilder builder = new StringBuilder();
        this.repository.getPriorityQueue().stream().sorted().forEach(vehicle -> {
            builder.append("\n\tID: ").append(vehicle.getId()).append("\n\tИмя: ").append(vehicle.getName()).append("\n\tКоординаты: (").append(vehicle.getCoordinates().getX()).append(", ").append(vehicle.getCoordinates().getY()).append(")\n\tМощность двигателя: ").append(vehicle.getEnginePower()).append("\n\tКолёс: ").append(vehicle.getNumberOfWheels()).append("\n\tПроехано: ").append(vehicle.getDistanceTravelled()).append("\n\tТип топлива: ").append(vehicle.getFuelTypeString());
        });
        return factory.getResponse(true, builder.toString());
    }
}
