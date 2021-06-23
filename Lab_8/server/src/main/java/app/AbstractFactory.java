package app;

import communication.CollectionInfo;
import communication.Response;
import object.Vehicle;
import object.VehicleBuilder;

import java.util.Collection;
import java.util.Queue;

public interface AbstractFactory {
    Response getResponse(boolean successful, String message);
    Response getResponse(boolean successful, Collection<Vehicle> vehicleCollection);
    Response getResponse(boolean successful, CollectionInfo collectionInfo);
    VehicleBuilder getVehicleBuilder();
    Response getResponse(boolean b, String displayVehicle, Queue<Vehicle> priorityQueue);
}
