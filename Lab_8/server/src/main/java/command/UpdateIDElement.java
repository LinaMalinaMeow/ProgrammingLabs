package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;

import java.util.Locale;

public class UpdateIDElement extends AbstractCommand implements Command {
    private final CollectionManager repository;
    private final AbstractFactory factory;

    public UpdateIDElement(CollectionManager repository, AbstractFactory factory){
        super("update"," обновить значение элемента коллекции, id которого равен заданному");
        this.repository = repository;
        this.factory  = factory;
    }
    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale){
        try {
            int id = Integer.parseInt(str);
            if(this.repository.update(id, vehicle, user)){
                return factory.getResponse(true, MessageManager.getInstance().getLocalMessages(locale).getString("suc.update"), repository.getPriorityQueue());
            }
            else {
                return factory.getResponse(false,MessageManager.getInstance().getLocalMessages(locale).getString("err.no_such"));
            }
        } catch (NumberFormatException e) {
            return factory.getResponse(false,MessageManager.getInstance().getLocalMessages(locale).getString("err.arg"));
        }
    }
}
