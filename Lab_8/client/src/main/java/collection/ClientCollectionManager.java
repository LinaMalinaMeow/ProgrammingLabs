package collection;

import object.Vehicle;

import java.util.Collection;
import java.util.stream.Stream;

public interface ClientCollectionManager {
    int size();

    int fieldCount();

    Stream<Vehicle> getVehicleStream();

    void setVehicles(Collection<Vehicle> vehicleCollection);

    Object getField(int rawIndex, int columnIndex);
}
