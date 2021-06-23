package commands;

import app.Asker;
import app.Repository;
import data.Vehicle;

/**
 * @author alina hihihi meow
 */
public class AddElement extends AbstractCommand implements Command {
    private Repository repository;
    private Asker asker;


    public AddElement(Repository repository, Asker asker) {
        super("add", "добавить новый элемент в коллекцию");
        this.repository = repository;
        this.asker = asker; 
    }

    @Override
    public void execute(String str){
        Vehicle vehicle;
        try {
            vehicle = this.asker.createVehicle();
            repository.add(vehicle);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
