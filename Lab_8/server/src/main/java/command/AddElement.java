package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;

import java.util.Locale;

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
    public Response execute(String str, Vehicle vehicle, User user, Locale locale){
        try {
            repository.add(vehicle, user);
            return factory.getResponse(true, repository.getPriorityQueue());
        } catch(NullPointerException | IllegalArgumentException e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.add"));
        }
    }
}
