package commands;

import app.Collection;

public class PrintFieldAscendingNumberOfWheels extends AbstractCommand implements Command {
    private Collection collection;
    public PrintFieldAscendingNumberOfWheels(Collection collection){
        super("print_field_ascending_number_of_wheels", "вывести значения поля numberOfWheels всех элементов в порядке возрастания");
        this.collection = collection;
    }
    @Override
    public void execute(String str){
    }
}
