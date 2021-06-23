package commands;

import app.Repository;

public class PrintFieldAscendingNumberOfWheels extends AbstractCommand implements Command {
    private Repository repository;

    public PrintFieldAscendingNumberOfWheels(Repository repository){
        super("print_field_ascending_number_of_wheels", "вывести значения поля numberOfWheels всех элементов в порядке возрастания");
        this.repository = repository;
    }
    @Override
    public void execute(String str){
        System.out.println(this.repository.getAscNumberWheels());
    }
}
