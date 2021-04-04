package commands;

import app.Collection;
import data.Vehicle;

import java.util.Arrays;
import java.util.Scanner;

public class PrintAscending extends AbstractCommand implements Command {
    private Collection collection;
    public PrintAscending(Collection collection){
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        this.collection = collection;
    }
    @Override
    public void execute(String string){
        collection.printAscending();
    }
}
