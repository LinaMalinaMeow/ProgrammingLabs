package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

/**
 * @author alina hihihi meow
 */
public class AddElement extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public AddElement(CollectionManager repository, AbstractFactory abstractFactory) {
        super("add", "добавить новый элемент в коллекцию");
        this.repository = repository;
        this.factory = abstractFactory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle){
        try {
            repository.add(vehicle);
            return factory.getResponse(true, "");
        } catch(NullPointerException e) {
            return factory.getResponse(false, "Не удалось добавить элемент.");
        }
    }
}
