package commands;

import app.Asker;
import app.Collection;
import data.Vehicle;

public class UpdateIDElement extends AbstractCommand implements Command{
    private Collection collection;
    private Asker asker;
    public UpdateIDElement(Collection collection, Asker asker){
        super("update_id_element"," обновить значение элемента коллекции, id которого равен заданному");
        this.collection = collection;
        this.asker  = asker;
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
                boolean popalo = false;
                for (Vehicle vehicle : this.collection.getPriorityQueue()) {
                    if(count == (id-1)) {
                        vehicle = this.asker.createVehicle();
                        popalo = true;
                    }
                    count += 1;
                }
                if(!popalo){
                    System.out.println("Элемента с таким ID не существует");
                } else {
                    System.out.println("Элемент с ID " + id + " был изменён");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
