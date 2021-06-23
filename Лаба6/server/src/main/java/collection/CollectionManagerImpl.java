package collection;

import command_manager.ServerCommandManager;
import data.DataReader;
import data.DataWriter;
import object.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionManagerImpl implements CollectionManager{

    private final DataReader dataReader;
    private PriorityQueue<Vehicle> vehiclePriorityQueue;
    private Date initializationDate;
    private LocalDate lastUpdate;
    private final DataWriter dataWriter;
    private static final Logger logger = LoggerFactory.getLogger(CollectionManagerImpl.class);
    private Set<Integer> idSet;

    public CollectionManagerImpl(DataReader dataReader, DataWriter dataWriter) {
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.vehiclePriorityQueue = new PriorityQueue<>();
        loadCollection();
    }

    private void loadCollection() {
        try {
            vehiclePriorityQueue = dataReader.readCollection();
            initializationDate = new Date();
            idSet = vehiclePriorityQueue.stream().map(Vehicle::getId).collect(Collectors.toSet());
            checkIds();
            logger.debug("Коллекция загружена из файла.");
        } catch (Exception e) {
            logger.error("Ошибка при чтении коллекции: " + e.getMessage());
            System.exit(1);
        }
    }

    private void checkIds() {
        Set<Integer> ids = new HashSet<>();
        ArrayList<Vehicle> changelist = new ArrayList<>();
        for(Vehicle vehicle: vehiclePriorityQueue) {
            if(ids.contains(vehicle.getId())) {
                changelist.add(vehicle);
            } else
                ids.add(vehicle.getId());
        }
        changelist.stream().peek(x -> logger.error("ID элемента " + x + " повторяет ID другого элемента. Его ID изменен.")).forEach(x -> x.setId(getNewId()));
    }

    public PriorityQueue<Vehicle> getPriorityQueue() {
        return this.vehiclePriorityQueue;
    }

    @Override
    public String info() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("Тип коллекции : ").append(vehiclePriorityQueue.getClass()).append("\n");
        builder.append("Количество элементов в коллекции : ").append(vehiclePriorityQueue.size()).append("\n");
        builder.append("Дата создания: ").append(format.format(initializationDate)).append("\n");
        if (!(lastUpdate == null)) {
            builder.append("Дата последнего обновления : ").append(lastUpdate);
        } else {
            builder.append("Дата последнего обновления : ещё не обновлялась");
        }
        return builder.toString();
    }

    public ArrayList<Vehicle> getAscVehicles() {
        return vehiclePriorityQueue.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public Vehicle getVehicleMinDistanceTravelled() {
        //поиск минимальной дистанции из коллекции автомобилей
        int min = this.vehiclePriorityQueue.stream().map(Vehicle::getDistanceTravelled)//в метод map передаём ссылку на метод для отображения потока машин в поток Integer,
                // stream объектов vehicle переводим в stream Integer. Преобразуем поток автомобилей в поток distanceTravelled
                .mapToInt(x -> x).min().orElse(Integer.MAX_VALUE);// если вдруг минимумм не будет найден, то возвращается максимальное значение
        return this.vehiclePriorityQueue.stream()
                .filter(x -> x.getDistanceTravelled() == min).findAny().orElse(null);
        // отбор всех автомобилей, у которых distanceTravelled является минимальным и получение любого автомобиля из этого списка
    }

    public List<Integer> getAscNumberWheels() {
        return this.vehiclePriorityQueue.stream().map(Vehicle::getNumberOfWheels)//ссылка на метод
                .sorted().collect(Collectors.toList());
    }

    public void clear() {
        lastUpdate = LocalDate.now();
        this.vehiclePriorityQueue.clear();
    }

    @Override
    public void save() {
        try {
            dataWriter.save(vehiclePriorityQueue);
        } catch (Exception e) {
            logger.error("Ошибка при сохранении коллекции: " + e.getMessage());
        }
    }


    public boolean removeById(int id) {
        lastUpdate = LocalDate.now();
        //происходит отбор по id и получение автомобиля с таким id
        Vehicle vehicle = this.vehiclePriorityQueue.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return this.vehiclePriorityQueue.remove(vehicle);
    }


    public Vehicle removeHead() {
        lastUpdate = LocalDate.now();
        return this.vehiclePriorityQueue.poll();
    }

    public void add(Vehicle vehicle) {
        lastUpdate = LocalDate.now();
        vehicle.setId(getNewId());
        this.vehiclePriorityQueue.add(vehicle);
    }

    private int getNewId() {
        int id;
        do {
            id = new Random().nextInt(Integer.MAX_VALUE);
        } while (idSet.contains(id));
        idSet.add(id);
        return id;
    }

    public boolean update(int id, Vehicle vehicle) {
        Vehicle has = this.vehiclePriorityQueue.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        if (has == null)
            return false;
        this.vehiclePriorityQueue.remove(has);
        vehicle.setId(id);
        this.vehiclePriorityQueue.add(vehicle);
        return true;
    }
}
