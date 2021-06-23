package object;

public interface VehicleValidator {
    boolean validateName(String name);
    boolean validateX(Float x);
    boolean validateY(Float y);
    boolean validateEnginePower(Integer enginePower);
    boolean validateNumOfWheels(Integer numOfWheels);
    boolean validateDistanceTravelled(Integer distanceTravelled);
    boolean validateFuelType(FuelType fuelType);
}
