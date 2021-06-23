package object;

public class VehicleValidatorImpl implements VehicleValidator{
    @Override
    public boolean validateName(String name) {
        return name != null && !name.isEmpty();
    }

    @Override
    public boolean validateX(Float x) {
        return x != null && x > -836;
    }

    @Override
    public boolean validateY(Float y) {
        return y != null;
    }

    @Override
    public boolean validateEnginePower(Integer enginePower) {
        return enginePower != null && enginePower > 0;
    }

    @Override
    public boolean validateNumOfWheels(Integer numOfWheels) {
        return numOfWheels != null && numOfWheels > 0;
    }

    @Override
    public boolean validateDistanceTravelled(Integer distanceTravelled) {
        return distanceTravelled != null && distanceTravelled > 0;
    }

    @Override
    public boolean validateFuelType(FuelType fuelType) {
        return fuelType != null;
    }
}
