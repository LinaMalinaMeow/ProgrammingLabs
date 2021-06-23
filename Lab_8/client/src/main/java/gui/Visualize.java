package gui;

import collection.ClientCollectionManager;
import communication.User;
import message.MessageManager;
import object.Vehicle;
import object.VehicleDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
//визуализация коллекции
public class Visualize extends JComponent {
    private ClientCollectionManager collectionManager;
    private final int side = 20;
    private final int gap = 3;
    private final int FPS = 15; //Количество отрисовок в секунду
    private static Map<String, Color> owners = new HashMap<>();
    private final Map<Vehicle, VehicleRectangle> vehicles = new HashMap<>();
    int minX = 3;
    int minY = 3;
    int maxY = 564 - side;
    int maxX = 1241 - side;
    private boolean mustDraw = false;
    User user = null;

    public Visualize(ClientCollectionManager collectionManager, VehicleDisplayer vehicleDisplayer, ControlManager controlManager) {
        this.collectionManager = collectionManager;
        update(user);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) return;
                int x = e.getX();
                int y = e.getY();
                collectionManager.getVehicleStream()
                        .forEach(p -> {
                            if (!p.getUsername().equals(user.getLogin())) {
                                int x1 = (int) Math.max(Math.min(maxX, p.getCoordinates().getX()), minX);
                                int y1 = (int) Math.max(Math.min(maxY, p.getCoordinates().getY()), minY);
                                if (x >= x1 && x <= x1 + side && y >= y1 && y <= y1 + side) {
                                    String vehicleStr = vehicleDisplayer.displayVehicle(p, Locale.getDefault());
                                    JOptionPane.showMessageDialog(Visualize.this, vehicleStr,
                                            MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("title.vehicle"),
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                int x1 = (int) Math.max(Math.min(maxX, p.getCoordinates().getX()), minX);
                                int y1 = (int) Math.max(Math.min(maxY, p.getCoordinates().getY()), minY);
                                if (x >= x1 && x <= x1 + side && y >= y1 && y <= y1 + side) {
                                    String vehicleStr = vehicleDisplayer.displayVehicle(p, Locale.getDefault());
                                    int option = JOptionPane.showConfirmDialog(Visualize.this, vehicleStr,
                                            MessageManager.getInstance().getLocalMessages(Locale.getDefault()).getString("title.update_vehicle"),
                                            JOptionPane.OK_CANCEL_OPTION);
                                    if (option == 0)
                                        controlManager.update(p.getId());
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int maxXLine = 1200;
        int maxYLine = 560;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        for(int i = 0; i <= maxX + side; i+=side) {
            g2.setColor(Color.BLACK);
            g2.drawLine(i, 0, i, maxY + side);
            g2.setColor(Color.BLUE);
            if(i % 40 == 0 && i < maxXLine)
                g2.drawString(String.valueOf(i), i, 10);
            if(i == maxXLine) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2.drawString("OX", i, 15);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
            }
        }
        for(int i = 0; i <= maxY + side; i+=side) {
            g2.setColor(Color.BLACK);
            g2.drawLine(0, i, maxX + side, i);
            g2.setColor(Color.BLUE);
            if(i != 0 && i < maxYLine)
                g2.drawString(String.valueOf(i), 0, i);
            if(i == maxYLine) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2.drawString("OY", 0, i);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
            }
        }
        collectionManager.getVehicleStream().forEach(p -> {
            createVehicleRectangle(p, g2);
        });
        tick();
        mustDraw = false;
    }

    private void createVehicleRectangle(Vehicle p, Graphics2D g2) {
        int x = (int) Math.max(Math.min(maxX, p.getCoordinates().getX()), minX);
        int y = (int) Math.max(Math.min(maxY, p.getCoordinates().getY()), minY);
        if(vehicles.containsKey(p) && !mustDraw)
            paintVehicle(vehicles.get(p), g2, x, y);
        else {
            if (!owners.containsKey(p.getUsername())) {
                Color color;
                do {
                    color = RandomColor.getRandomColor();
                } while (owners.containsValue(color));
                owners.put(p.getUsername(), color);
            }
            VehicleRectangle rectangle = new VehicleRectangle(x, y, side, side, owners.get(p.getUsername()), p);
            vehicles.put(p, rectangle);
            paintVehicle(rectangle, g2, x, y);
        }
    }

    private void tick() {
        new Thread(() -> {
            boolean mustRun = true;
            while (true) {
                try {
                    Thread.sleep(1000 / FPS);
                    int left = 0;
                    for (VehicleRectangle rectangle : vehicles.values()) {
                        if (!rectangle.hasFinished()) {
                            left++;
                            rectangle.onTick();
                        }
                    }
                    if (left == 0)
                        break;
                    else
                        repaint();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    private void paintVehicle(VehicleRectangle rectangle, Graphics2D g2, int x, int y) {
        rectangle.recalculate();
        g2.setColor(rectangle.getColor());
        g2.fill(rectangle);
        g2.setColor(Color.BLACK);
        g2.draw(rectangle);
        g2.drawString(String.valueOf(rectangle.getVehicle().getId()), x + gap, y + side / 2);
    }



    public void update(User user) {
        this.user = user;
        repaint();
    }

    public void changeColor(String owner) {
        owners.remove(owner);
        mustDraw = true;
        repaint();
    }

    public void mustDraw() {
        mustDraw = true;
    }
}