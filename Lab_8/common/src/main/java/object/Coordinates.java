package object;

import java.io.Serializable;
import java.util.Objects;

public class Coordinates implements Serializable {
    private Float x; //больше -836
    private Float y;


    public Coordinates(Float x, Float y) {
        this.x = x;
        this.y = y;

        }

    /**
     *
     * @return coordinates
     */

    public Float getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}