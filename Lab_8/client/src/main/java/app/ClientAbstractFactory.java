package app;

import command.CommandManager;
import communication.*;
import object.Vehicle;
import object.VehicleBuilder;
import object.VehicleBuilderImpl;
import reader.Asker;
import reader.FileAsker;
import reader.FileInputManager;
import reader.InputManager;

import java.util.Locale;
import java.util.Scanner;

public class ClientAbstractFactory implements AbstractFactory{

    @Override
    public Asker getFileAsker(Scanner scanner) {
        return new FileAsker(scanner);
    }

    @Override
    public InputManager getFileInputManager(Scanner scanner, CommandManager commandManager) {
        return new FileInputManager(scanner, commandManager);
    }

    @Override
    public Request getRequest(RequestType askVehicle, String command, String arg, Vehicle vehicle, User user, Locale locale) {
        return new RequestImpl(askVehicle, vehicle, command, arg, user, locale);
    }

    @Override
    public Response getResponse(boolean b, String s) {
        return new ResponseImpl(s, b);
    }

    @Override
    public VehicleBuilder getBuilder() {
        return new VehicleBuilderImpl();
    }
}
