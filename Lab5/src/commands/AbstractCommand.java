package commands;

import data.Coordinates;
import data.FuelType;

import java.util.Date;

abstract class AbstractCommand {
    private String name;
    private String description;
    private Integer id;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Integer enginePower;
    private Integer numberOfWheels;
    private Integer distanceTravelled;
    private FuelType fuelType;

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;

    }

    /**
     * @return Name and usage way of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Description of the command.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return ID
     */
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name + " : " + description ;
    };

    @Override
    public int hashCode() {
        return name.hashCode() + description.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && description.equals(other.description);
    }
}