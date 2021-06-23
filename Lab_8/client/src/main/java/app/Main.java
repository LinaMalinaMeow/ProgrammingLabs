package app;

import collection.ClientCollectionManager;
import collection.ClientCollectionManagerImpl;
import command.*;
import connection.RequestSender;
import connection.RequestSenderImpl;
import connection.ResponseReader;
import connection.ResponseReaderImpl;
import gui.ControlManager;
import gui.ControlManagerImpl;
import object.VehicleDisplayerImpl;
import reader.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResponseReader reader = new ResponseReaderImpl();
        RequestSender sender = new RequestSenderImpl();
        Scanner userScanner = new Scanner(System.in);
        Asker asker = new GUIAsker();
        AbstractFactory factory = new ClientAbstractFactory();
        AuthModule authModule = new AuthModuleImpl(asker);
        String host = System.getenv("HOST");
        if(host == null) {
            System.out.println("Ошибка. Переменная окружения HOST не задана.");
            return;
        }
        Integer port = null;
        try {
            port = Integer.parseInt(System.getenv("PORT"));
        } catch (Exception e) {
            System.out.println("Ошибка. Переменная окружения PORT не задана.");
            return;
        }
        CommandManager commandManager = new ClientCommandManager(asker, factory, sender, reader, getClientCommands(), authModule, getAuthCommands(authModule, factory), host, port);
        InputManager inputManager = new ConsoleInputManager(userScanner, commandManager);
        Client client = new ClientImpl(inputManager, commandManager);
        ClientCollectionManager collectionManager = new ClientCollectionManagerImpl();
        ControlManager guiController = new ControlManagerImpl(collectionManager, authModule, new GUIAdapterImpl(commandManager), new VehicleDisplayerImpl(), asker);
        guiController.start();
        client.userMode(host, port);
    }

    static Map<String, ClientCommand> getClientCommands() {
        Map<String, ClientCommand> commandMap = new HashMap<>();
        commandMap.put("exit", new ClientExitCommand());
        commandMap.put("execute_script", new ExecuteScriptFileName());
        return commandMap;
    }

    static Map<String, AuthCommand> getAuthCommands(AuthModule authModule, AbstractFactory abstractFactory) {
        Map<String, AuthCommand> commandMap = new HashMap<>();
        commandMap.put("login", new LoginCommand(authModule, abstractFactory));
        commandMap.put("register", new RegisterCommand(authModule, abstractFactory));
        commandMap.put("sync", null);
        return commandMap;
    }
}