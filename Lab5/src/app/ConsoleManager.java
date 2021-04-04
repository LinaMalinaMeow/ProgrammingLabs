package app;

import commands.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    private CommandManager commandManager;
    private boolean active;
    private Collection collection;

    private Scanner userScanner;
    private FileManager fileManager;

    public ConsoleManager(Scanner userScanner, CommandManager commandManager, FileManager fileManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
        this.fileManager = fileManager;
    }

    /**
     * Mode for work with commands from user input.
     */
    public void userMode() {
        String[] userCommand;
        try {
            while (true) {
                System.out.println("Введите команду: ");
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                this.commandManager.startCommand(userCommand);
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Введён конец файла! Завершаю программу.");
            System.exit(0);
        } catch (IllegalStateException exception) {
            System.out.println("Непредвиденная ошибка!");
        }
    }


//        /**
//         * Mode for work with commands from a script.
//         */
//
//    }
}
