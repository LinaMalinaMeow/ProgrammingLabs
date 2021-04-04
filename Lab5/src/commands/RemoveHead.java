package commands;

import app.Collection;
import data.Vehicle;

public class RemoveHead extends AbstractCommand implements Command{
    private Collection collection;
    public RemoveHead(Collection collection){
        super("remove_head", "вывести первый элемент коллекции и удалить его");
    }
    @Override
    public void execute(String str){
        Head head= new Head(this.collection);
        RemoveFirst rm = new RemoveFirst(this.collection);
        if(this.collection.getPriorityQueue().peek()!= null) {
            head.execute("");
            rm.execute("");
        }else{
            System.out.println("В коллекции нет первого элемента");
        }
    }
}
