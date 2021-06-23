package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import exceptions.WrongArgumentException;
import message.MessageManager;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


/**
 * @author alina
 */
public class Clear extends AbstractCommand implements Command {
    CollectionManager repository;
    AbstractFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(Clear.class);

    public Clear(CollectionManager repository, AbstractFactory factory) {
        super("clear", "очистить коллекцию");
        this.repository = repository;
        this.factory = factory;
    }

    /**
     * Execute of 'clear' command.
     */
    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale) {
        try {
            if (!str.isEmpty()) {
                throw new WrongArgumentException();
            }
            repository.clear(user);
            return factory.getResponse(true,repository.getPriorityQueue());
        } catch (WrongArgumentException e) {
            return factory.getResponse(false,MessageManager.getInstance().getLocalMessages(locale).getString("err.arg"));
        } catch (Exception e) {
            logger.error(e.getClass() + " " + e.getMessage());
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.clear"));
        }
    }
}