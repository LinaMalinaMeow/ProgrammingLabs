package commands;

import app.Repository;
import data.Vehicle;

public class MinByDistanceTravelled extends AbstractCommand implements Command {
    private Repository repository;

    public MinByDistanceTravelled(Repository repository){
        super("min_by_distance_travelled", " вывести любой объект из коллекции, значение поля distanceTravelled которого является минимальным");
        this.repository = repository;
    }
    @Override
    public void execute(String str){
        Vehicle res = this.repository.getVehicleMinDistanceTravelled();
        if(res == null){
            System.out.println("Автомобиль не найден");
        }
        else
            System.out.println("Автомобиль с минимальным пробегом: " + res);
    }
}
