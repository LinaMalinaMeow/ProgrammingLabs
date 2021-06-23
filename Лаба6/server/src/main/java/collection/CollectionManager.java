package collection;

import object.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface CollectionManager {
    void add(Vehicle vehicle);
    boolean update(int id, Vehicle vehicle);
    void clear();
    void save();
    Queue<Vehicle> getPriorityQueue();
    String info();
    Vehicle getVehicleMinDistanceTravelled();
    ArrayList<Vehicle> getAscVehicles();
    List<Integer> getAscNumberWheels();
    boolean removeById(int id);
    Vehicle removeHead();
}
