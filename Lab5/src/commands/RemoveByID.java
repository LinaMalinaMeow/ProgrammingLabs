package commands;

import app.Repository;
import data.Vehicle;

public class RemoveByID extends AbstractCommand implements Command {
    private Repository repository;

    public RemoveByID(Repository repository) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.repository = repository;
    }

    @Override
    public void execute(String str) {
        if (str.equals("")) {
            System.out.println("Нужен аргумент");
            return;
        }
        try {
            int id = Integer.parseInt(str);
            if(this.repository.removeById(id)){
                System.out.println("Успешно удален!");
            }else {
                System.out.println("Элемент с данным индексом не найден!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

