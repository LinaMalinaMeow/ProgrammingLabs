package commands;

import app.Collection;

public class Clear extends AbstractCommand implements Command {
    Collection Collection;
    public Clear(Collection Collection) {
        super("clear", "очистить коллекцию");
        this.Collection = Collection;
    }

    /**
     * Execute of 'clear' command.
     */
    @Override
    public void execute(String argument) {
    }
}
