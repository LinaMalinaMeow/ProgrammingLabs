package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

public class MinByDistanceTravelled extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public MinByDistanceTravelled(CollectionManager repository, AbstractFactory factory){
        super("min_by_distance_travelled", " вывести любой объект из коллекции, значение поля distanceTravelled которого является минимальным");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle){
        Vehicle res = this.repository.getVehicleMinDistanceTravelled();
        if(res == null){
            return factory.getResponse(false,"Автомобиль не найден");
        }
        else
            return factory.getResponse(true,"Автомобиль с минимальным пробегом: " + res);
    }
}
