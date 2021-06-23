package app;


import commands.*;
import exceptions.ScriptRecursionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandManager {
    private Info info;
    private Help help;
    private Show show;
    private Save save;
    private AddElement addElement;
    private UpdateIDElement updateIDElement;
    private RemoveByID removeByIDID;
    private Clear clear;
    private ExecuteScriptFileName executeScript;
    private Exit exit;
    private RemoveFirst removeFirst;
    private Head head;
    private RemoveHead removeHead;
    private MinByDistanceTravelled minByDistanceTravelled;
    private PrintAscending printAscending;
    private PrintFieldAscendingNumberOfWheels printFieldAscendingNumberOfWheels;
    private ArrayList<Command> commandManagerArrayList = new ArrayList<>();

    public CommandManager(Info info,
                          Help help,
                          Show show,
                          AddElement addElement,
                          UpdateIDElement updateIDElement,
                          RemoveByID removeByIDID,
                          Clear clear,
                          Save save,
                          ExecuteScriptFileName executeScript,
                          Exit exit,
                          RemoveFirst removeFirst,
                          Head head,
                          RemoveHead removeHead,
                          MinByDistanceTravelled minByDistanceTravelled,
                          PrintAscending printAscending,
                          PrintFieldAscendingNumberOfWheels printFieldAscendingNumberOfWheels) {
        this.info = info;
        this.help = help;
        this.show = show;
        this.addElement = addElement;
        this.updateIDElement = updateIDElement;
        this.removeByIDID = removeByIDID;
        this.clear = clear;
        this.save = save;
        this.executeScript = executeScript;
        this.exit = exit;
        this.removeFirst = removeFirst;
        this.head = head;
        this.removeHead = removeHead;
        this.minByDistanceTravelled = minByDistanceTravelled;
        this.printAscending = printAscending;
        this.printFieldAscendingNumberOfWheels = printFieldAscendingNumberOfWheels;

        commandManagerArrayList.add(info);
        commandManagerArrayList.add(help);
        commandManagerArrayList.add(show);
        commandManagerArrayList.add(addElement);
        commandManagerArrayList.add(updateIDElement);
        commandManagerArrayList.add(removeByIDID);
        commandManagerArrayList.add(clear);
        commandManagerArrayList.add(save);
        commandManagerArrayList.add(executeScript);
        commandManagerArrayList.add(exit);
        commandManagerArrayList.add(removeFirst);
        commandManagerArrayList.add(head);
        commandManagerArrayList.add(removeHead);
        commandManagerArrayList.add(minByDistanceTravelled);
        commandManagerArrayList.add(printAscending);
        commandManagerArrayList.add(printFieldAscendingNumberOfWheels);
    }


    /**
     * @param str Start execute of 'info' command.
     */
    public void info(String str) {
        info.execute(str);
    }

    /**
     * @param str Start execute of 'help' command.
     */
    public void help(String str) {

        help.execute(str);
    }

    /**
     * @param str Start execute of 'show' command.
     */
    public void show(String str) {
        show.execute(str);
    }

    /**
     * @param str Start execute of 'add' command.
     */
    public void add(String str) {
        addElement.execute(str);
    }

    /**
     * @param str Start execute of 'update' command.
     */
    public void update(String str) {
        updateIDElement.execute(str);
    }

    /**
     * @param str Start execute of 'removeById' command.
     */
    public void removeById(String str) {
        removeByIDID.execute(str);
    }

    /**
     * @param str Start execute of 'clear' command.
     */
    public void clear(String str) {
        clear.execute(str);
    }

    /**
     * @param str Start execute of 'save' command.
     */
    public void save(String str) {
        save.execute(str);
    }

    /**
     * @param str Start execute of 'executeScript' command.
     * Создание заготовки для команд, подключение считки с файла и построчный считка;
     * если файл пуст- бросаю ошибку, если не пустой, тогда начинаю по строчке считывать и делить на команду и аргумент
     *(и если это не рекурсия, тогда отправляем в обычную обработку).
     */
    public void executeScript(String str) {
        String[] userCommand;
        try (Scanner scriptScanner = new Scanner(new File(str))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                System.out.println(String.join(" ", userCommand));//выводим с разделителем пробел, то есть команда пробел аргумент
                if (userCommand[0].equals("execute_script")) {
                    throw new ScriptRecursionException();
                }
                startCommand(userCommand);
            } while (scriptScanner.hasNextLine());
        } catch (FileNotFoundException exception) {
            System.out.println("Файл со скриптом не найден!");
        } catch (ScriptRecursionException e) {
            System.out.println("Скрипты не могут вызываться рекурсивно!");

        } catch (NoSuchElementException exception) {
            System.out.println("Файл со скриптом пуст!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Перезапустите программу");
        }
    }

    /**
     * @param str Start execute of 'exit' command.
     */
    public void exit(String str) {
        exit.execute(str);
    }

    /**
     * @param str Start execute of 'head' command.
     */
    public void head(String str) {
        head.execute(str);
    }

    /**
     * @param str Start execute of 'printFieldAscendingNumberOfWheels' command.
     */
    public void printFieldAscendingNumberOfWheels(String str) {
        printFieldAscendingNumberOfWheels.execute(str);
    }

    /**
     * @param str Start execute of 'printAscending' command.
     */
    public void printAscending(String str) {
        printAscending.execute(str);
    }

    /**
     * @param str Start execute of 'minByDistanceTravelled' command.
     */
    public void minByDistanceTravelled(String str) {
        minByDistanceTravelled.execute(str);
    }

    /**
     * @param str Start execute of 'removeFirst' command.
     */
    public void removeFirst(String str) {
        removeFirst.execute(str);
    }

    /**
     * @param str Start execute of 'removeHead' command.
     */
    public void removeHead(String str) {
        removeHead.execute(str);
    }

    /**
     * @param userCommand Проверка на внутреннюю команду(команду, находящуюся в программе хы)
     * Массив из двух ячеек- в одной название, а в  другой данные
     */
    public void startCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "exit":
                exit("");
                break;
            case "help":
                help("");
                break;
            case "info":
                info("");
                break;
            case "show":
                show("");
                break;
            case "add":
                add("");
                break;
            case "update":
                update(userCommand[1]);
                break;
            case "remove_by_id":
                removeById(userCommand[1]);
                break;
            case "clear":
                clear("");
                break;
            case "save":
                save("");
                break;
            case "execute_script":
                executeScript(userCommand[1]);
                break;
            case "remove_first":
                removeFirst("");
                break;
            case "head":
                head("");
                break;
            case "remove_head":
                removeHead("");
                break;
            case "min_by_distance_travelled":
                minByDistanceTravelled("");
                break;
            case "print_ascending":
                printAscending("");
                break;
            case "print_field_ascending_number_of_wheels":
                printFieldAscendingNumberOfWheels("");
                break;
            default:
                System.out.println("Не является внутренней командой. Повтороте ввод или напишите help для получения актуального списка команд.");
        }
    }
}
