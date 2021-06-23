package app;

import data.Coordinates;
import data.FuelType;
import data.Vehicle;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    private Date initializationDate;
    private LocalDate lastUpdate;
    private PriorityQueue<Vehicle> vehiclePriorityQueue;
    private String fileName;

    public Repository(String fileName) throws ParserConfigurationException, IOException, SAXException, ParseException {
        this.initializationDate = new Date();
        this.vehiclePriorityQueue = new PriorityQueue();
        this.fileName = fileName;
        //newInstance - статический метод класса
        //DocumentBuilderFactory, который создает и возвращает объект фабрики DocumentBuilderFactory

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        try {
            File file1 = new File(fileName);
            if (file1.exists() && file1.canRead()) {
                try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
                    Document document = documentBuilder.parse(new InputSource(reader));
                    if (document.getElementsByTagName("vehicles").getLength() == 0) {
                        throw new ParseException("vehicles обязательный атрибут в файле", 0);
                    }
                    NodeList vehiclesNodeList = document.getElementsByTagName("vehicle");
                    for (int i = 0; i < vehiclesNodeList.getLength(); i++) {
                        try {
                            Element nodeVehicle = (Element) vehiclesNodeList.item(i); //приведение типов, получение итого элемента
                            //id
                            if (nodeVehicle.getElementsByTagName("id").getLength() == 0) {
                                throw new ParseException("ID - обязательное поле", 0);
                            }
                            Integer id = Integer.valueOf(nodeVehicle.getElementsByTagName("id") //конвертируем строку в целое число
                                    .item(0).getTextContent());//получаем все теги id из ноды, но так как айди один, то забираем нулевой
                            if (id <= 0) {
                                throw new IllegalArgumentException("ID должен быть больше 0");
                            }
                            if (this.vehiclePriorityQueue.stream().anyMatch(x -> x.getId() == id)) {
                                throw new IllegalArgumentException("ID должен быть уникальным");
                            }

                            //name
                            if (nodeVehicle.getElementsByTagName("name").getLength() == 0) {
                                throw new ParseException("Name - обязательное поле", 0);
                            }
                            String name = nodeVehicle.getElementsByTagName("name")
                                    .item(0).getTextContent();
                            if (name.equals("")) {
                                throw new IllegalArgumentException("Name должен быть не пустым");
                            }

                            //coordinates
                            if (nodeVehicle.getElementsByTagName("coordinates").getLength() == 0) {
                                throw new ParseException("Coordinates - обязательное поле", 0);
                            }
                            Element nodeCoordinates = (Element) nodeVehicle.getElementsByTagName("coordinates").item(0);
                            if (nodeCoordinates.getElementsByTagName("x").getLength() == 0) {
                                throw new ParseException("X - обязательное поле", 0);
                            }
                            Float x = Float.valueOf(nodeCoordinates.getElementsByTagName("x").item(0).getTextContent());
                            if (x < -836) {
                                throw new IllegalArgumentException("X должен быть больше -836");
                            }
                            if (nodeCoordinates.getElementsByTagName("y").getLength() == 0) {
                                throw new ParseException("Y - обязательное поле", 0);
                            }
                            Float y = Float.valueOf(nodeCoordinates.getElementsByTagName("y").item(0).getTextContent());

                            //creationDate
                            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                            format.setLenient(false);// чтобы формат справа соответствовал формату слева
                            if (nodeVehicle.getElementsByTagName("creationDate").getLength() == 0) {
                                throw new ParseException("creationDate - обязательное поле", 0);
                            }
                            Date creationDate = format.parse(nodeVehicle.getElementsByTagName("creationDate")
                                    .item(0).getTextContent());

                            //enginePower
                            if (nodeVehicle.getElementsByTagName("enginePower").getLength() == 0) {
                                throw new ParseException("enginePower - обязательное поле", 0);
                            }
                            Integer enginePower = Integer.valueOf(nodeVehicle.getElementsByTagName("enginePower")
                                    .item(0).getTextContent());
                            if (enginePower <= 0) {
                                throw new IllegalArgumentException("enginePower должен быть больше 0");
                            }

                            //numberOfWheels
                            if (nodeVehicle.getElementsByTagName("numberOfWheels").getLength() == 0) {
                                throw new ParseException("numberOfWheels - обязательное поле", 0);
                            }
                            Integer numberOfWheels = Integer.valueOf(nodeVehicle.getElementsByTagName("numberOfWheels")
                                    .item(0).getTextContent());
                            if (numberOfWheels <= 0) {
                                throw new IllegalArgumentException("numberOfWheels должен быть больше 0");
                            }

                            Integer distanceTravelled = null; //необязательна и может быть null
                            if (nodeVehicle.getElementsByTagName("distanceTravelled").getLength() != 0) {
                                distanceTravelled = Integer.valueOf(nodeVehicle.getElementsByTagName("distanceTravelled")
                                        .item(0).getTextContent());
                            }

                            FuelType fuelType = null;
                            if (nodeVehicle.getElementsByTagName("fuelType").getLength() != 0) {
                                fuelType = FuelType.valueOf(nodeVehicle.getElementsByTagName("fuelType")
                                        .item(0).getTextContent());
                            }
                            Vehicle vehicle = new Vehicle(id, name, new Coordinates(x, y), creationDate,
                                    enginePower, numberOfWheels, distanceTravelled, fuelType);
                            this.vehiclePriorityQueue.add(vehicle);
                        } catch (IllegalArgumentException | ParseException e) {
                            System.out.println("Эта машинка не может быть добвлена в коллекцию");
                        }
                    }
                }
            } else {
                System.out.println("Нет прав на чтение или файл не существует. Добавьте права/Создайте файл и запустите программу вновь");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Ошибка обработки коллекции!");
        }
    }

    public PriorityQueue<Vehicle> getPriorityQueue() {
        return this.vehiclePriorityQueue;
    }

    public ArrayList<Vehicle> getAscVehicles() {
        //priorityQueue переводим в arrayList, далее его сортируем и возвращаем
        ArrayList<Vehicle> tmpList = new ArrayList<>(this.vehiclePriorityQueue);
        tmpList.sort(null);//null означает, что мы не передаем компаратор, а сравнение происходит через метод compareTo класса vehicle
        return tmpList;
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


    public boolean removeById(int id) {
        lastUpdate = LocalDate.now();
        //происходит отбор по id и получение автомобиля с таким id
        Vehicle vehicle = this.vehiclePriorityQueue.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return this.vehiclePriorityQueue.remove(vehicle);
    }

    /**
     * @throws ParserConfigurationException Указывает на серьезную ошибку конфигурации.
     * @throws TransformerException         Исключительное состояние, возникшее в процессе преобразования.
     * @throws IOException                  Сигналы о том, что произошло какое-то исключение ввода-вывода
     */
    public void saveXml() throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder(); //документ билдер создает новый элемент
        Document document = documentBuilder.newDocument();
        Element elementVehicles = document.createElement("vehicles");
        document.appendChild(elementVehicles);

        for (Vehicle vehicle : this.vehiclePriorityQueue) {
            //создание тега vehicle
            Element elementVehicle = document.createElement("vehicle");
            //создание тега id
            Element elementId = document.createElement("id");
            // установка в тег id данных об id из объекта vehicle
            elementId.setTextContent(String.valueOf(vehicle.getId()));
            // добавление тега id в тег vehicle
            elementVehicle.appendChild(elementId);

            Element elementName = document.createElement("name");
            elementName.setTextContent(String.valueOf(vehicle.getName()));
            elementVehicle.appendChild(elementName);

            Element elementCoordinates = document.createElement("coordinates");
            elementVehicle.appendChild(elementCoordinates);

            Element elementX = document.createElement("x");
            elementX.setTextContent(String.valueOf(vehicle.getCoordinates().getX()));
            Element elementY = document.createElement("y");
            elementY.setTextContent(String.valueOf(vehicle.getCoordinates().getY()));

            elementCoordinates.appendChild(elementX);
            elementCoordinates.appendChild(elementY);

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Element elementCreationDate = document.createElement("creationDate");
            elementCreationDate.setTextContent(format.format(vehicle.getCreationDate()));
            elementVehicle.appendChild(elementCreationDate);

            Element elementEnginePower = document.createElement("enginePower");
            elementEnginePower.setTextContent(String.valueOf(vehicle.getEnginePower()));
            elementVehicle.appendChild(elementEnginePower);

            Element elementNumberOfWheels = document.createElement("numberOfWheels");
            elementNumberOfWheels.setTextContent(String.valueOf(vehicle.getNumberOfWheels()));
            elementVehicle.appendChild(elementNumberOfWheels);

            if (vehicle.getDistanceTravelled() != null) {
                Element elementDistanceTravelled = document.createElement("distanceTravelled");
                elementDistanceTravelled.setTextContent(String.valueOf(vehicle.getDistanceTravelled()));
                elementVehicle.appendChild(elementDistanceTravelled);
            }

            if (vehicle.getFuelType() != null) {
                Element elementFuelType = document.createElement("fuelType");
                elementFuelType.setTextContent(String.valueOf(vehicle.getFuelType()));
                elementVehicle.appendChild(elementFuelType);
            }

            elementVehicles.appendChild(elementVehicle);
        }
        //объект, который преобразует созданную структуру в xml формат
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");//включить табуляцию и поставить пробелы
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource domSource = new DOMSource(document);

        //создаю объект типа файл, чтобы посмотреть у него существование и права на файл, если всё существует,
        // тогда делаем запись, в остальных случах бросаем исключения.
        try {
            File fc = new File(fileName);
            if (fc.exists() && fc.canWrite()) {
                try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
                    StreamResult streamResult = new StreamResult(writer);
                    transformer.transform(domSource, streamResult);
                    System.out.println("Коллекция успешно сохранена!");
                }
            } else {
                System.out.println("Добавьте права на чтение файла и попробуйте снова!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка обработки коллекции!");
        }
    }

    /**
     * @return возвращает строковое представление элемента
     */
    @Override
    public String toString() {
        return vehiclePriorityQueue.toString();
    }

    public void infoCollection() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        System.out.println("Тип коллекции : " + vehiclePriorityQueue.getClass());
        System.out.println("Количество элементов в коллекции : " + vehiclePriorityQueue.size());
        System.out.println("Дата создания: " + format.format(initializationDate));
        if (!(lastUpdate == null)) {
            System.out.println("Дата последнего обновления : " + lastUpdate);
        } else {
            System.out.println("Дата последнего обновления : ещё не обновлялась");
        }
    }

    public void clearCollection() {
        vehiclePriorityQueue.clear();
        lastUpdate = LocalDate.now();
    }

    public Vehicle removeHead() {
        lastUpdate = LocalDate.now();
        return this.vehiclePriorityQueue.poll();
    }

    public void add(Vehicle vehicle) {
        lastUpdate = LocalDate.now();
        this.vehiclePriorityQueue.add(vehicle);
    }

    public boolean updateById(int id, Vehicle vehicle) {
        Vehicle has = this.vehiclePriorityQueue.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        //если автомобиль по id не найден
        if (has == null)
            return false;
        this.vehiclePriorityQueue.remove(has);
        vehicle.setId(id);
        this.vehiclePriorityQueue.add(vehicle);
        return true;
    }
}
