package commands;

import app.Collection;
import data.Vehicle;

public class RemoveByIDID extends AbstractCommand implements Command{
    private Collection collection;
    public RemoveByIDID(Collection collection){
        super("remove_by_id","удалить элемент из коллекции по его id");
        this.collection = collection;
    }
    @Override
    public void execute(String str){
        if(str.equals("")) {
            System.out.println("Нужен аргумент");
        } else {
            int id;
            try {
                id = Integer.parseInt(str);
                int count = 0;
                for (Vehicle vehicle : this.collection.getPriorityQueue()) {
                    if(count == (id-1)) {
                        this.collection.getPriorityQueue().remove(vehicle);
                    }
                    count += 1;
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

