package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

public class RemoveHead extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public RemoveHead(CollectionManager repository, AbstractFactory factory) {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle) {
        try {
            Vehicle v = repository.removeHead();
            if(v != null)
                return factory.getResponse(true, String.valueOf(v));
            else{
                return factory.getResponse(false,"Коллекция пуста");
            }
        } catch (Exception e) {
            return factory.getResponse(false, e.getMessage());
        }
    }
}
