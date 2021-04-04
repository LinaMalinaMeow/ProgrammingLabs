package commands;

import app.Asker;
import app.Collection;
import data.Vehicle;

public class AddElement extends AbstractCommand implements Command {
    private Collection collection;
    private Asker asker;
    public AddElement(Collection collection, Asker asker) {
        super("add", "добавить новый элемент в коллекцию");
        this.collection = collection;
        this.asker = asker; 
    }

    @Override
    public void execute(String str){
        Vehicle vehicle;
        try {
            vehicle = this.asker.createVehicle();
            collection.getPriorityQueue().add(vehicle);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
