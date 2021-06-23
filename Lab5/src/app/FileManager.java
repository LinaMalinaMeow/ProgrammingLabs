package app;
import java.io.File;


public class FileManager {
    private String path;
    private File file;

    FileManager(String path) {
        this.path = path;
        this.file = null;//new File(path);
    }

    public void changeFile(String path) {
        this.path = path;
        this.file = new File(path);
    }

    /*public void saveBananaPlease() {
        String path = System.getenv("BANANA_LAB5");//путь к окружению
        File file = new File(path);

    }*/

    public void readCollection(Collection collection) {
        //InputStreamReader isr = new InputStreamReader(System.getenv(this.path));

        // 1. InputStreamReader <- this.file || this.path;
        // 2. InputStreamReader (content) -> Parser
        // 3. Parser:
        // try {
        //    Collection fileCollection = createCollection();
        //    this.collection = fileCollection;
        // } catch(В файле нет коллекции) {
        //    System.out.println("В файле нет коллекции, поэтому была создана новая");
        // }
    }

    public void writeCollection(Collection collection) {
        // 1. Parser:
        //    collection -> collection.xml;
        // 2. Parser (collection.xml) -> OutputStreamWriter;
        // 3. OutputStreamWriter (collection) -> this.file;
    }

    // PATH: C:/lalala/lalalaa/file.txt
    // FILE: file.txt (содержимое, данные о файле и т.д.)



}