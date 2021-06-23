package communication;

import object.Vehicle;

import java.io.Serializable;
import java.util.Collection;
import java.util.Queue;

public class ResponseImpl implements Response, Serializable {
    private String message;
    private final boolean successful;
    private CollectionInfo collectionInfo;
    private Collection<Vehicle> vehicles;

    public ResponseImpl(String message, boolean successful) {
        this.message = message;
        this.successful = successful;
    }

    public ResponseImpl(boolean successful, CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
        this.successful = successful;
    }

    public ResponseImpl(boolean successful, Collection<Vehicle> collection) {
        this.vehicles = collection;
        this.successful = successful;
    }

    public ResponseImpl(boolean b, String displayVehicle, Collection<Vehicle> priorityQueue) {
        this.vehicles = priorityQueue;
        this.successful = b;
        this.message = displayVehicle;
    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public Collection<Vehicle> getCollection() {
        return vehicles;
    }

    @Override
    public CollectionInfo getInfo() {
        return collectionInfo;
    }

    @Override
    public void setCollection(Collection<Vehicle> collection) {
        this.vehicles = collection;
    }

    @Override
    public String toString() {
        return "Response: " +
                ", successful=" + successful;
    }
}
