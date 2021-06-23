package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class RemoveByID extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(RemoveByID.class);

    public RemoveByID(CollectionManager repository, AbstractFactory factory) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale) {
        if (str.equals("")) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.arg"));
        }
        try {
            int id = Integer.parseInt(str);
            if(this.repository.removeById(id, user)){
                return factory.getResponse(true,MessageManager.getInstance().getLocalMessages(locale).getString("suc.rem"), repository.getPriorityQueue());
            }else {
                return factory.getResponse(false,MessageManager.getInstance().getLocalMessages(locale).getString("err.no_such"));
            }
        } catch (Exception e) {
            logger.error(e.getClass() + " " + e.getMessage());
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err_rem"));
        }
    }
}

