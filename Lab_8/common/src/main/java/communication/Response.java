package communication;

import object.Vehicle;

import java.util.Collection;
import java.util.Queue;

public interface Response {
    String getMessage();
    boolean isSuccessful();
    Collection<Vehicle> getCollection();
    CollectionInfo getInfo();
    void setCollection(Collection<Vehicle> priorityQueue);
}
