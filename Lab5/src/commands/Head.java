package commands;

import app.Repository;
import data.Vehicle;

/**
 * @author alina
 */
public class Head extends AbstractCommand implements Command {
    Repository repository;


    public Head(Repository repository){
        super("head", "вывести первый элемент коллекции");
        this.repository = repository;
    }

    @Override
    public void execute(String str){
        Vehicle vehicle = this.repository.getPriorityQueue().peek();
        if(vehicle != null) {
            System.out.println("Первый элемент коллекции: \n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelTypeString());
        } else {
            System.out.println("В коллекции нет первого элемента");
        }

    }
}
