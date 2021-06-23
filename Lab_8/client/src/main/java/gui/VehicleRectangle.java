package gui;

import object.Vehicle;

import java.awt.*;
import java.util.Objects;

public class VehicleRectangle extends Rectangle {
    public int x;
    public int y;
    public int velocityH;
    public int velocityW;
    public int width;
    public int height;
    private Color color;
    private Vehicle vehicle;
    private boolean hasFinished;

    public VehicleRectangle(int x, int y, int width, int height, Color color, Vehicle vehicle) {
        this.x = x;
        this.y = y;
        velocityW = width * 10;
        velocityH = height * 10;
        this.width = width;
        this.height = height;
        this.color = color;
        this.hasFinished = false;
        this.vehicle = vehicle;
        this.setBounds(x, y, velocityW, velocityH);
        this.setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return String.valueOf(vehicle.getId());
    }


    public boolean contains(int X, int Y) {
        if ((x < X) && (X < x + width) && (y < Y) && (Y < y + height)) return true;
        return false;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Анимация квадратиков
    public void onTick() {
        int rnd = (int) (Math.random() * 5);
        int newH = velocityH - rnd;
        int newW = velocityW - rnd;
        if(newH >= height)
            this.velocityH = newH;
        if(newW >= width)
            this.velocityW = newW;
        if(newH < height && newW < width) {
            this.velocityH = height;
            this.velocityW = width;
            hasFinished = true;
        }
    }

    public boolean hasFinished() {
        return hasFinished;
    }

    public void recalculate() {
        this.setBounds(x, y, velocityW, velocityH);
    }
    //Проверка на квадратики
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehicleRectangle rectangle = (VehicleRectangle) o;
        return x == rectangle.x && y == rectangle.y  && Objects.equals(color, rectangle.color) && Objects.equals(vehicle, rectangle.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, velocityH, velocityW, width, height, color, vehicle, hasFinished);
    }
}
