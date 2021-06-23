package app;

import communication.CollectionInfo;
import communication.Response;
import communication.ResponseImpl;
import object.Vehicle;
import object.VehicleBuilder;
import object.VehicleBuilderImpl;

import java.util.Collection;
import java.util.Queue;

public class AbstractFactoryImpl implements AbstractFactory{
    @Override
    public Response getResponse(boolean successful, String message) {
        return new ResponseImpl(message, successful);
    }

    @Override
    public Response getResponse(boolean successful, Collection<Vehicle> vehicleCollection) {
        return new ResponseImpl(successful, vehicleCollection);
    }

    @Override
    public Response getResponse(boolean successful, CollectionInfo collectionInfo) {
        return new ResponseImpl(successful, collectionInfo);
    }

    @Override
    public VehicleBuilder getVehicleBuilder() {
        return new VehicleBuilderImpl();
    }

    @Override
    public Response getResponse(boolean b, String displayVehicle, Queue<Vehicle> priorityQueue) {
        return new ResponseImpl(b, displayVehicle, priorityQueue);
    }
}
