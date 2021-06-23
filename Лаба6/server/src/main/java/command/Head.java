package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

/**
 * @author alina
 */
public class Head extends AbstractCommand implements Command {
    CollectionManager repository;
    AbstractFactory factory;

    public Head(CollectionManager repository, AbstractFactory factory){
        super("head", "вывести первый элемент коллекции");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle){
        vehicle = this.repository.getPriorityQueue().peek();
        if(vehicle != null) {
            return factory.getResponse(true, "Первый элемент коллекции: \n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelTypeString());
        } else {
            return factory.getResponse(false,"В коллекции нет первого элемента");
        }
    }
}
