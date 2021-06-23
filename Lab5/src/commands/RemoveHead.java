package commands;

import app.Repository;
import data.Vehicle;

public class RemoveHead extends AbstractCommand implements Command {
    private Repository repository;

    public RemoveHead(Repository repository) {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
        this.repository = repository;
    }

    @Override
    public void execute(String str) {
        /*Head head= new Head(this.repository);
        RemoveFirst rm = new RemoveFirst(this.repository);
        if(this.repository.getPriorityQueue().poll()!= null) {
            head.execute("");
            rm.execute("");
        }else{
            System.out.println("В коллекции нет первого элемента");
        }*/
        try {
            Vehicle vehicle = repository.removeHead();
            if(vehicle != null)
                System.out.println("Элемент " + vehicle + " был успешно удален из коллекции!");
            else{
                System.out.println("Коллекция пуста");
            }
        } catch (Exception e) {
            /*e.printStackTrace(System.out);
            System.out.println("Коллекция пуста");*/
            System.out.println(e.getMessage());
        }
    }
}
