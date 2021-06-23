package commands;

import app.Asker;
import app.Repository;
import data.Vehicle;

public class UpdateIDElement extends AbstractCommand implements Command{
    private Repository repository;
    private Asker asker;

    public UpdateIDElement(Repository repository, Asker asker){
        super("update"," обновить значение элемента коллекции, id которого равен заданному");
        this.repository = repository;
        this.asker  = asker;
    }
    @Override
    public void execute(String str){
        /*if(str.equals("")) {

            System.out.println("Нужен аргумент");
            return;
        } else {
            int id;
            try {

                int count = 0;
                boolean popalo = false;
                for (Vehicle vehicle : this.repository.getPriorityQueue()) {
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
        }*/

        try {
            int id = Integer.parseInt(str);
            if(this.repository.updateById(id, asker.createVehicle())){
                System.out.println("Элемент успешно обновлен!");
            }
            else {
                System.out.println("Элемента с данным id нет в коллекции!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id");
        }
    }
}
