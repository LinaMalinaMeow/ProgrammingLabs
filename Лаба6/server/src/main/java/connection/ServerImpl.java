package connection;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerImpl implements Server {
    private final ConnectionManager connectionManager;
    private final CollectionManager collectionManager;


    public ServerImpl(ConnectionManager connectionManager, CollectionManager collectionManager) {
        this.connectionManager = connectionManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            checkConsole(bufferedReader);
            connectionManager.manageConnection();
        }
    }

    private void checkConsole(BufferedReader bufferedReader) {
        try {
            if(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] lines = line.trim().split("\\s+");
                try {
                    if(lines[0].trim().equalsIgnoreCase("save"))
                        collectionManager.save();
                    else if(lines[0].trim().equalsIgnoreCase("exit")) {
                        collectionManager.save();
                        System.exit(0);
                    }
                    else
                        System.err.println("Неизвестная команда. Поддерживаемые команды: save, exit.");
                } catch (Exception e) {
                    System.err.println("Ошибка при чтении команды: " + e.getMessage());
                }
            }
        } catch (IOException ignored) {
        }
    }
}
