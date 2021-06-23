package app;

import collection.CollectionManager;
import collection.CollectionManagerImpl;
import connection.Server;
import connection.ServerImpl;
import command.*;
import command_manager.CommandManager;
import command_manager.ServerCommandManager;
import connection.*;
import data.DataReader;
import data.DataWriter;
import data.FileDataReader;
import data.FileDataWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.logging.LogManager;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(ServerConnectionManager.class);

    public static void main(String[] args) {
        try {
            String path = System.getenv("BANANA_LAB6");
            if (path == null) {
                System.out.println("Переменная окружения BANANA_LAB6 не найдена");
                return;
            }
            int port;
            try {
                port = Integer.parseInt(System.getenv("PORT"));
            } catch (Exception e) {
                System.out.println("Переменная окружения PORT не найдена");
                return;
            }
            AbstractFactory abstractFactory = new AbstractFactoryImpl();
            DataReader dataReader = new FileDataReader(path);
            DataWriter dataWriter = new FileDataWriter(path);
            CollectionManager repository = new CollectionManagerImpl(dataReader, dataWriter);
            CommandManager commandManager = new ServerCommandManager(getCommands(repository, abstractFactory), abstractFactory, getVehicleCommands());
            RequestReader requestReader = new RequestReaderImpl();
            ResponseSender responseSender = new ResponseSenderImpl();
            ConnectionManager connectionManager = new ServerConnectionManager(port, commandManager, requestReader, responseSender, abstractFactory);
            Server server = new ServerImpl(connectionManager, repository);
            server.run();
        } catch (NullPointerException e){
            System.out.println("Сервер завершил работу.");
        } catch (Exception e) {
            System.out.println("Сервер завершил работу с ошибкой.");
            logger.error(Arrays.toString(e.getStackTrace()), e.getMessage());
        }
    }

    private static Set<String> getVehicleCommands() {
        Set<String> vehicleCommands = new HashSet<>();
        vehicleCommands.add("add");
        vehicleCommands.add("update");
        return vehicleCommands;
    }

    private static Map<String, Command> getCommands(CollectionManager collectionManager, AbstractFactory abstractFactory) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("info", new Info(collectionManager, abstractFactory));
        commandMap.put("help", new Help(abstractFactory));
        commandMap.put("show", new Show(collectionManager, abstractFactory));
        commandMap.put("add", new AddElement(collectionManager, abstractFactory));
        commandMap.put("update", new UpdateIDElement(collectionManager, abstractFactory));
        commandMap.put("remove_by_id", new RemoveByID(collectionManager, abstractFactory));
        commandMap.put("clear", new Clear(collectionManager, abstractFactory));
        commandMap.put("head", new Head(collectionManager, abstractFactory));
        commandMap.put("remove_head", new RemoveHead(collectionManager, abstractFactory));
        commandMap.put("min_by_distance_travelled", new MinByDistanceTravelled(collectionManager, abstractFactory));
        commandMap.put("print_ascending", new PrintAscending(collectionManager, abstractFactory));
        commandMap.put("print_field_ascending_number_of_wheels", new PrintFieldAscendingNumberOfWheels(collectionManager, abstractFactory));
        commandMap.put("remove_first", new RemoveFirst(collectionManager, abstractFactory));
        return commandMap;
    }


}
