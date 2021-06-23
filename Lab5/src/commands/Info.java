package commands;

import app.Repository;
import exceptions.WrongArgumentException;


public class Info extends AbstractCommand implements Command {
    private Repository repository;

    public Info(Repository repository) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.repository = repository;
    }

    @Override
    public void execute(String str) {
        try {
            if (!str.isEmpty()) {
                throw new WrongArgumentException();
            }
            repository.infoCollection();
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод!");
        }
    }
}
