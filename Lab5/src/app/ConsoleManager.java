package app;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    protected CommandManager commandManager;
    protected Scanner userScanner;

    public ConsoleManager(Scanner userScanner, CommandManager commandManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
    }

    /**
     * Mode for work with commands from user input.
     */
    public void userMode() {
        String[] userCommand;
        try {
            while (true) {
                System.out.println("Введите команду{add,clear,head,info,show,min_by_distance_travelled,print_ascending,print_field_ascending_number_of_wheels,remove_by_id,remove_first,remove_head,save,update,execute_script ..,exit}: ");
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                this.commandManager.startCommand(userCommand);
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Ошибка! Завершаю программу.");
            System.exit(0);
        } catch (Exception exception) {
            System.out.println("Упс... ошибочка!");
        }
    }
}
