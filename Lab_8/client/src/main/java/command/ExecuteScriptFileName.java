package command;

import app.AbstractFactory;
import communication.Response;
import message.MessageManager;
import reader.Asker;
import reader.InputManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author alina
 */
public class ExecuteScriptFileName implements ClientCommand {
    @Override
    public Response execute(String str, AbstractFactory factory, CommandManager commandManager) {
        File file = new File(str);
        if(!file.exists()) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.file"));
        }
        if(!file.canRead()) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.file_read"));
        }
        Scanner userScanner;
        Asker asker;
        Asker prevAsker = commandManager.getAsker();
        try {
            userScanner = new Scanner(Paths.get(str));
            asker = factory.getFileAsker(userScanner);
            commandManager.setAsker(asker);
        } catch (IOException e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.file"));
        }
        try {
            InputManager consFileManager = factory.getFileInputManager(userScanner, commandManager);
            while (userScanner.hasNext())
                consFileManager.readCommand();
            return factory.getResponse(true, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("suc.exec"));
        } catch (Exception e) {
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("err.script"));
        } finally {
            commandManager.setAsker(prevAsker);
        }
    }
}
