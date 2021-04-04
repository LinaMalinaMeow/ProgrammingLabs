package commands;

import app.Asker;
import app.Collection;
import data.Vehicle;

public class Head extends AbstractCommand implements Command {
    Collection collection;
    public Head(Collection collection){
        super("head", "вывести первый элемент коллекции");
        this.collection = collection;
    }
    @Override
    public void execute(String str){
        Vehicle vehicle = this.collection.getPriorityQueue().peek();
        if(vehicle != null) {
            System.out.println("Первый элемент коллекции: \n\tИмя: " + vehicle.getName() +
                    "\n\tКоординаты: (" + vehicle.getCoordinates().getX() + ", " + vehicle.getCoordinates().getY() +
                    ")\n\tМощность двигателя: " + vehicle.getEnginePower() +
                    "\n\tКолёс: " + vehicle.getNumberOfWheels() +
                    "\n\tПроехано: " + vehicle.getDistanceTravelled() +
                    "\n\tТип топлива: " + vehicle.getFuelType());
        } else {
            System.out.println("В коллекции нет первого элемента");
        }

    }
}
