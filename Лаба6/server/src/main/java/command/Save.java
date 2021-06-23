package command;


import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Save extends AbstractCommand implements Command {
    private CollectionManager repository;
    private AbstractFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(Save.class);

    public Save(CollectionManager repository, AbstractFactory factory){
        super("save","сохранить коллекцию в файл");
        this.repository = repository;
        this.factory = factory;
    }
    @Override
    public Response execute(String str, Vehicle vehicle){
        try {
            this.repository.save();
            return factory.getResponse(true, "");
        } catch (Exception e) {
            logger.error(e.getClass() + " " + e.getMessage());
            return factory.getResponse(false, "Не удалось выполнить команду save.");
        }
    }
}
