package commands;

import app.Repository;

public class RemoveFirst extends AbstractCommand implements Command {
    private Repository repository;

    public RemoveFirst(Repository repository){
        super("remove_first", "удалить первый элемент из коллекции");
        this.repository = repository;

    }
    @Override
    public void execute(String str){

        if(this.repository.getPriorityQueue().peek() == null) {
            System.out.println("Невозможно удалить первый элемент коллекции так как его нет");
        } else {
            this.repository.getPriorityQueue().remove(this.repository.getPriorityQueue().peek());
            System.out.println("Первый элемент коллекции удалён!");
        }

    }
}
