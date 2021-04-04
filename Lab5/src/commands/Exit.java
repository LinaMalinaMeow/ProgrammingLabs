package commands;
import app.ConsoleManager;

public class Exit extends AbstractCommand implements Command {
    private ConsoleManager console;

    /**
     * Command 'exit'. Exits the program.
     */

    public Exit() {
        super("exit", "завершить программу (без сохранения в файл");
        this.console = console;
    }

    @Override
    public void execute(String str) {
        System.exit(0);
    }
}
