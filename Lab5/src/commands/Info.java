package commands;

import app.Collection;

public class Info extends AbstractCommand implements Command {
    private Collection collection;

    public Info(Collection collection) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.collection = collection;
    }

    @Override
    public void execute(String str) {

    }
}
