package command;

import app.AbstractFactory;
import collection.CollectionManager;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;
import object.VehicleDisplayer;

import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class Show extends AbstractCommand implements Command {
    private final CollectionManager repository;
    private final AbstractFactory factory;
    private final VehicleDisplayer vehicleDisplayer;

    public Show(CollectionManager repository, AbstractFactory factory, VehicleDisplayer vehicleDisplayer) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.repository = repository;
        this.factory = factory;
        this.vehicleDisplayer = vehicleDisplayer;
    }

    @Override
    public Response execute(String str, Vehicle v, User user, Locale locale) {
        if(this.repository.getPriorityQueue().size() == 0){
            return factory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.no_such"), repository.getPriorityQueue());
        }
        return factory.getResponse(true, repository.getPriorityQueue().stream().map(vehicle -> vehicleDisplayer.displayVehicle(vehicle, locale)).collect(Collectors.joining("\n")), repository.getPriorityQueue());
    }
}
