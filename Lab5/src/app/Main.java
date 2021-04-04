package app;

import commands.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        Collection collection = new Collection();
        FileManager fileManager = new FileManager(System.getenv("OGURETZ"));
        fileManager.readCollection(collection);
        // inputstream -> parse -> collection from file => collection = collection from file

        Asker asker = new Asker(userScanner);

        CommandManager commandManager = new CommandManager(
                new Info(collection),
                new Help(),
                new Show(collection),
                new AddElement(collection, asker),
                new UpdateIDElement(collection, asker),
                new RemoveByIDID(collection),
                new Clear(collection),
                new Save(collection, fileManager),
                new ExecuteScriptFileName(),
                new Exit(),
                new RemoveFirst(collection),
                new Head(collection),
                new RemoveHead(collection),
                new MinByDistanceTravelled(),
                new PrintAscending(collection),
                new PrintFieldAscendingNumberOfWheels(collection)
        );
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager,fileManager);
        consoleManager.userMode();

        FileInputStream fis = null;
        int b = 0;

        try {
            fis = new FileInputStream("C:/../../papochka");
            while ((b =fis.read())!= -1) {
                System.out.println((char) b);
            }
            } catch (IOException e) {
                e.printStackTrace();
        }

        //   path - "../../papochka" - papochka в project

        //   path - "../papochka" - papochka в src
    }
}
