package commands;

import app.Repository;

public class Save extends AbstractCommand implements Command{
    private Repository repository;

    public Save(Repository repository){
        super("save","сохранить коллекцию в файл");
        this.repository = repository;
    }
    @Override
    public void execute(String str){
        try {
            this.repository.saveXml();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
