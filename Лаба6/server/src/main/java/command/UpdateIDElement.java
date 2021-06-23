package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import object.Vehicle;

public class UpdateIDElement extends AbstractCommand implements Command {
    private final CollectionManager repository;
    private final AbstractFactory factory;

    public UpdateIDElement(CollectionManager repository, AbstractFactory factory){
        super("update"," обновить значение элемента коллекции, id которого равен заданному");
        this.repository = repository;
        this.factory  = factory;
    }
    @Override
    public Response execute(String str, Vehicle vehicle){
        try {
            int id = Integer.parseInt(str);
            if(this.repository.update(id, vehicle)){
                return factory.getResponse(true, "Элемент успешно обновлен!");
            }
            else {
                return factory.getResponse(false,"Элемента с данным id нет в коллекции!");
            }
        } catch (NumberFormatException e) {
            return factory.getResponse(false,"Неверный формат id");
        }
    }
}
