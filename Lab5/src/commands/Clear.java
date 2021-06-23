package commands;

import app.Repository;
import exceptions.WrongArgumentException;


/**
 * @author alina
 */
public class Clear extends AbstractCommand implements Command {
    Repository repository;


    public Clear(Repository Repository) {
        super("clear", "очистить коллекцию");
        this.repository = Repository;
    }

    /**
     * Execute of 'clear' command.
     */
    @Override
    public void execute(String str) {
        try {
            if (!str.isEmpty()) {
                throw new WrongArgumentException();
            }
            repository.clearCollection();
            System.out.println("Колекция успешно очищена!");
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}