package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;

import java.util.Locale;

public class RemoveFirst extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;

    public RemoveFirst(CollectionManager repository, AbstractFactory factory){
        super("remove_first", "удалить первый элемент из коллекции");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale){
        try {
            if(repository.removeFirst(user))
                return factory.getResponse(true, MessageManager.getInstance().getLocalMessages(locale).getString("suc.rem"), repository.getPriorityQueue());
            else{
                return factory.getResponse(false,MessageManager.getInstance().getLocalMessages(locale).getString("suc.no_such"));
            }
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.rem"));
        }
    }
}
