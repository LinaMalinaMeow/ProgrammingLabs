package commands;

import app.Collection;

public class RemoveFirst extends AbstractCommand implements Command {
    private Collection collection;
    public RemoveFirst(Collection collection){
        super("remove_first", "удалить первый элемент из коллекции");
        this.collection= collection;

    }
    @Override
    public void execute(String str){

        if(this.collection.getPriorityQueue().peek() == null) {
            System.out.println("Невозможно удалить первый элемент коллекции так как его нет");
        } else {
            this.collection.getPriorityQueue().remove(this.collection.getPriorityQueue().peek());
            System.out.println("Первый элемент коллекции удалён!");
        }

    }
}
