package app;

import commands.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        //Scanner userScanner = new Scanner(Paths.get("script.sc"));

        try {
            String path = System.getenv("BANANA_LAB5");
            if (path == null) {
                System.out.println("Переменная окружения не найдена");
                return;
            }
            Repository repository = new Repository(path);
            //System.out.println(repository);

            Asker asker = new Asker(userScanner);
            CommandManager commandManager = new CommandManager(
                    new Info(repository),
                    new Help(),
                    new Show(repository),
                    new AddElement(repository, asker),
                    new UpdateIDElement(repository, asker),
                    new RemoveByID(repository),
                    new Clear(repository),
                    new Save(repository),
                    new ExecuteScriptFileName(repository),
                    new Exit(repository),
                    new RemoveFirst(repository),
                    new Head(repository),
                    new RemoveHead(repository),
                    new MinByDistanceTravelled(repository),
                    new PrintAscending(repository),
                    new PrintFieldAscendingNumberOfWheels(repository)
            );

            ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager);
            consoleManager.userMode();

//            FileInputStream fis = null;
//            int b = 0;
//            try {
//                fis = new FileInputStream("");
//                while ((b = fis.read()) != -1) { //мы считываем каждый отдельный байт в переменную  b
//                    //Когда в потоке больше нет данных для чтения, метод возвращает число -1.
//                    System.out.println((char) b);//Затем каждый считанный байт конвертируется в объект типа char и выводится на консоль.
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//
//        ArrayList<Vehicle> vehicles = new ArrayList<>();
//        vehicles.sort(null);
//
//
//        vehicles.sort(new Comparator<Vehicle>() {
//            @Override
//            public int compare(Vehicle o1, Vehicle o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
    }
}
