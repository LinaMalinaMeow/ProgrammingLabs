package commands;

import app.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author alina
 */
public class ExecuteScriptFileName extends AbstractCommand implements Command {
    private Repository repository;
    public ExecuteScriptFileName(Repository repository){
        super("name","description");
        this.repository = repository;
    }
    @Override
    public void execute(String str){
        try {
            Scanner userScanner = new Scanner(Paths.get(str));
            AskerFile asker = new AskerFile(userScanner);
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

            ConsFileManager consFileManager= new ConsFileManager(userScanner,commandManager);
            //consFileManager.executeScript(str);
        } catch (IOException e) {
            System.out.println("Файл не найден " + e.getMessage());
        }
    }
}
