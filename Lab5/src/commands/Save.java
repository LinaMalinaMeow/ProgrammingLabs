package commands;

import app.Collection;
import app.FileManager;

import java.io.File;

public class Save extends AbstractCommand implements Command{
    private Collection collection;
    private FileManager fileManager;
    public Save(Collection collection,  FileManager fileManager){
        super("save","сохранить коллекцию в файл");
        this.collection = collection;
        this.fileManager = fileManager;
    }
    @Override
    public void execute(String str){
        this.fileManager.writeCollection(this.collection);
    }
}
