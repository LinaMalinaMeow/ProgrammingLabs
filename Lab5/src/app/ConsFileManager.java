package app;

import java.util.NoSuchElementException;
import java.util.Scanner;

//данный класс нужен для того, чтобы производить выполнение скрипта из файла, обработка самих команд
public class ConsFileManager extends ConsoleManager {
    public ConsFileManager(Scanner userScanner, CommandManager commandManager) {
        super(userScanner, commandManager);
    }

    /**
     * Mode for work with commands from user input.
     */
    public void userMode() {
        String[] userCommand;
        try {
            while (true) {
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                this.commandManager.startCommand(userCommand);
            }
        } catch (NoSuchElementException exception) {
            //System.out.println("Введён конец файла! Завершаю программу.");
            //System.exit(0);
        } catch (IllegalStateException exception) {
            System.out.println("Непредвиденная ошибка!");
        }
    }
}
