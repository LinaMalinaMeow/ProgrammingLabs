package commands;

import app.ConsoleManager;
import app.Repository;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * @author alina
 */
public class Exit extends AbstractCommand implements Command {
    private ConsoleManager console;
    private Repository repository;

    /**
     *
     * @param repository(Command 'exit'. Exits the program.)
     */
    public Exit(Repository repository) {
        super("exit", "завершить программу (без сохранения в файл");
        this.console = console;
        this.repository = repository;
    }

    @Override
    public void execute(String str) {
        System.exit(0);
    }
}
