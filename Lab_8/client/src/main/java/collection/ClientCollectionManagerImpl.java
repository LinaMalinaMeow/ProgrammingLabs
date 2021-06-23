package collection;

import object.Vehicle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

public class ClientCollectionManagerImpl implements ClientCollectionManager{

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public int size() {
        return vehicleList.size();
    }

    @Override
    public int fieldCount() {
        return 10;
    }

    @Override
    public Stream<Vehicle> getVehicleStream() {
        readLock.lock();
        try {
            return vehicleList.stream();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void setVehicles(Collection<Vehicle> vehicleCollection) {
        writeLock.lock();
        try {
            this.vehicleList = new ArrayList<>(vehicleCollection);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Object getField(int rowIndex, int columnIndex) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0 : { return vehicleList.get(rowIndex).getId(); }
            case 1 : { return vehicleList.get(rowIndex).getName();}
            case 2 : { return vehicleList.get(rowIndex).getCoordinates().getX();}
            case 3 : { return vehicleList.get(rowIndex).getCoordinates().getY();}
            case 4 : { return format.format(vehicleList.get(rowIndex).getCreationDate());}
            case 5 : { return vehicleList.get(rowIndex).getEnginePower();}
            case 6 : { return vehicleList.get(rowIndex).getNumberOfWheels();}
            case 7 : { return vehicleList.get(rowIndex).getFuelType();}
            case 8 : { return vehicleList.get(rowIndex).getDistanceTravelled();}
            case 9 : { return vehicleList.get(rowIndex).getUsername();}
            default : { return "";}
        }
    }
}
