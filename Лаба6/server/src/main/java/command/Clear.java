package command;

import app.AbstractFactory;
import collection.CollectionManager;
import collection.CollectionManagerImpl;
import communication.Response;
import exceptions.WrongArgumentException;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
    public Response execute(String str, Vehicle vehicle) {
        try {
            if (!str.isEmpty()) {
                throw new WrongArgumentException();
            }
            repository.clear();
            return factory.getResponse(true,"Колекция успешно очищена!");
        } catch (WrongArgumentException e) {
            return factory.getResponse(false,"Используйте: '" + getName() + "'");
        } catch (Exception e) {
            logger.error(e.getClass() + " " + e.getMessage());
            return factory.getResponse(false,"Что-то пошло не так. Повторите ввод.");
        }
    }
}