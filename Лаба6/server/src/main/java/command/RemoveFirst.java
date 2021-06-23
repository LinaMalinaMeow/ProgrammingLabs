package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

public class RemoveFirst extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public RemoveFirst(CollectionManager repository, AbstractFactory factory){
        super("remove_first", "удалить первый элемент из коллекции");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle){
        if(this.repository.getPriorityQueue().peek() == null) {
            return factory.getResponse(false, "Невозможно удалить первый элемент коллекции так как его нет");
        } else {
            this.repository.getPriorityQueue().remove(this.repository.getPriorityQueue().peek());
            return factory.getResponse(true,"Первый элемент коллекции удалён!");
        }
    }
}
