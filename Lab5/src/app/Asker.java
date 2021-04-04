package app;

import data.Coordinates;
import data.FuelType;
import data.Vehicle;
import java.util.Scanner;

public class Asker {
    private final Scanner userScanner;

    public Asker(Scanner userScanner) {
        this.userScanner = userScanner;
    }
    public Vehicle createVehicle() {
        System.out.println("Введите название машины: ");
        String name = userScanner.nextLine();
        if((name == null) || (name.equals(" "))) throw new NullPointerException("Поле не может быть null, Строка не может быть пустой");
        System.out.print("\nEnter coordinateX of the new car: ");
        Float coordinateX = userScanner.nextFloat();
        if((coordinateX< -836)||(coordinateX == null)) throw new NullPointerException();
        System.out.println("\nEnter coordinateY of the new car: ");
        Float coordinateY = userScanner.nextFloat();
        if(coordinateY == null) throw new NullPointerException("Поле не может быть null");
        Coordinates coordinates = new Coordinates(coordinateX,coordinateY);

        // java.util.Date creationDate;

        System.out.println("Введите мощность двигателя: ");
        Integer enginePower = userScanner.nextInt();
        if((enginePower == null) ||(enginePower < 0)) throw new NullPointerException("Поле не может быть null, Значение поля должно быть больше 0");
        System.out.print("\nEnter numberOfWheels: ");

        Integer numberOfWheels = userScanner.nextInt();
        if((numberOfWheels == null)||(numberOfWheels<0)) throw new NullPointerException("Поле не может быть null, Значение поля должно быть больше 0");
        System.out.print("\nEnter distanceTravelled: ");

        Integer distanceTravelled = userScanner.nextInt();
        if((distanceTravelled == null)||(distanceTravelled<0)) throw new NullPointerException("Поле не может быть null, Значение поля должно быть больше 0");
        System.out.print("\nВведите тип топлива (Дизель,Алкоголь,Керосин,ЧеловеческаяСила,Антиматерия): ");

        String fuelType = userScanner.nextLine();
        fuelType = userScanner.nextLine();
        FuelType type;
        switch (fuelType){
            case "Дизель":
                type = FuelType.DIESEL;
                break;
            case "Алкоголь":
                type = FuelType.ALCOHOL;
                break;
            case  "Керосин":
                type = FuelType.KEROSENE;
                break;
            case "ЧеловеческаяСила":
                type = FuelType.MANPOWER;
                break;
            case "Антиматерия":
                type = FuelType.ANTIMATTER;
                break;
            default:
                type = null;
        }
        System.out.println("Машина " + name + " была добавлена в коллекцию");
        return new Vehicle(name,coordinates, enginePower,numberOfWheels,distanceTravelled,type);
    }
}