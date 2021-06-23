package gui;

import java.awt.*;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.border.*;

import message.MessageManager;
import object.FuelType;
import org.jdesktop.swingx.*;

public class CreateVehiclePanel extends JPanel {
    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel inputPanel;
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameTF;
    private JPanel enginePowerPanel;
    private JLabel enginePowerLabel;
    private JTextField enginePowerTF;
    private JPanel numberOfWheelsPanel;
    private JLabel numberOfWheelsLabel;
    private JTextField numberOfWheelsTF;
    private JPanel colorsPanel;
    private JLabel fuelTypeLabel;
    private JComboBox fuelTypeComboBox;
    private JLabel hairColorLabel;
    private JComboBox hairColorComboBox;
    private JLabel coordinatesLabel;
    private JComponent coordinatesSeparator;
    private JPanel coordinatesPanel;
    private JLabel coordinatesXLabel;
    private JTextField coordinatesXTF;
    private JLabel coordinatesYLabel;
    private JTextField coordinatesYTF;
    private JLabel locationLabel;
    private JComponent locationSeparator;
    private JPanel distanceTravelledPanel;
    private JLabel distanceTravelledLabel;
    private JTextField distanceTravelledTF;
    private JLabel locationYLabel;
    private JTextField locationYTF;
    private JLabel locationNameLabel;
    private JTextField locationNameTF;
    private final FuelType[] fuelTypeConstants;
    private String command;
    private String arg;

    public CreateVehiclePanel() {
        super();
        fuelTypeConstants = new FuelType[5];
        fuelTypeConstants[0] = FuelType.ALCOHOL;
        fuelTypeConstants[1] = FuelType.DIESEL;
        fuelTypeConstants[2] = FuelType.ANTIMATTER;
        fuelTypeConstants[3] = FuelType.MANPOWER;
        fuelTypeConstants[4] = FuelType.KEROSENE;
        initComponents();
    }

    private void initComponents() {
        buttonPanel = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        inputPanel = new JPanel();
        namePanel = new JPanel();
        nameLabel = new JLabel();
        nameTF = new JTextField();
        enginePowerPanel = new JPanel();
        enginePowerLabel = new JLabel();
        enginePowerTF = new JTextField();
        numberOfWheelsPanel = new JPanel();
        numberOfWheelsLabel = new JLabel();
        numberOfWheelsTF = new JTextField();
        colorsPanel = new JPanel();
        fuelTypeLabel = new JLabel();
        fuelTypeComboBox = new JComboBox(fuelTypeConstants);
        hairColorLabel = new JLabel();
        hairColorComboBox = new JComboBox();
        coordinatesLabel = new JLabel();
        coordinatesSeparator = new JSeparator();
        coordinatesPanel = new JPanel();
        coordinatesXLabel = new JLabel();
        coordinatesXTF = new JTextField();
        coordinatesYLabel = new JLabel();
        coordinatesYTF = new JTextField();
        locationLabel = new JLabel();
        locationSeparator = new JSeparator();
        distanceTravelledPanel = new JPanel();
        distanceTravelledLabel = new JLabel();
        distanceTravelledTF = new JTextField();
        locationYLabel = new JLabel();
        locationYTF = new JTextField();
        locationNameLabel = new JLabel();
        locationNameTF = new JTextField();

        //======== this ========
        {
            setBorder(new EmptyBorder(12, 12, 12, 12));
            setLayout(new BorderLayout());

            //======== buttonPanel ========
            {
                buttonPanel.setLayout(new FlowLayout());

                //---- okButton ----
                okButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.ok"));
                buttonPanel.add(okButton);

                //---- cancelButton ----
                cancelButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.cancel"));
                buttonPanel.add(cancelButton);
            }
            add(buttonPanel, BorderLayout.SOUTH);

            //======== inputPanel ========
            {
                inputPanel.setLayout(new VerticalLayout(6));

                //======== namePanel ========
                {
                    namePanel.setLayout(new HorizontalLayout(6));

                    //---- nameLabel ----
                    nameLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.name"));
                    nameLabel.setPreferredSize(new Dimension(50, 25));
                    namePanel.add(nameLabel);

                    //---- nameTF ----
                    nameTF.setPreferredSize(new Dimension(230, 25));
                    namePanel.add(nameTF);
                }
                inputPanel.add(namePanel);

                //======== heightPanel ========
                {
                    enginePowerPanel.setLayout(new HorizontalLayout(6));

                    //---- heightLabel ----
                    enginePowerLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.engine_power"));
                    enginePowerLabel.setPreferredSize(new Dimension(50, 25));
                    enginePowerPanel.add(enginePowerLabel);

                    //---- heightTF ----
                    enginePowerTF.setPreferredSize(new Dimension(230, 25));
                    enginePowerPanel.add(enginePowerTF);
                }
                inputPanel.add(enginePowerPanel);

                //======== birthdayPanel ========
                {
                    numberOfWheelsPanel.setLayout(new HorizontalLayout(6));

                    //---- birthdayLabel ----
                    numberOfWheelsLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.num_of_wheels"));
                    numberOfWheelsLabel.setPreferredSize(new Dimension(50, 25));
                    numberOfWheelsPanel.add(numberOfWheelsLabel);
                    numberOfWheelsPanel.add(numberOfWheelsTF);

                    //---- birthdayTF ----
                    numberOfWheelsTF.setPreferredSize(new Dimension(230, 25));
                }
                inputPanel.add(numberOfWheelsPanel);

                //======== distanceTravelledPanel ========
                {
                    distanceTravelledPanel.setLayout(new HorizontalLayout(6));

                    //---- distanceTravelledLabel ----
                    distanceTravelledLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.dist"));
                    distanceTravelledLabel.setPreferredSize(new Dimension(50, 25));
                    distanceTravelledPanel.add(distanceTravelledLabel);
                    distanceTravelledPanel.add(distanceTravelledTF);

                    //---- distanceTravelledTF ----
                    distanceTravelledTF.setPreferredSize(new Dimension(230, 25));
                }
                inputPanel.add(distanceTravelledPanel);

                //======== colorsPanel ========
                {
                    colorsPanel.setLayout(new HorizontalLayout(6));

                    //---- eyeColorLabel ----
                    fuelTypeLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.fuel_type"));
                    colorsPanel.add(fuelTypeLabel);

                    //---- eyeColorComboBox ----
                    colorsPanel.add(fuelTypeComboBox);
                }
                inputPanel.add(colorsPanel);
                inputPanel.add(coordinatesSeparator);

                //---- coordinatesLabel ----
                coordinatesLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.coordinates"));
                inputPanel.add(coordinatesLabel);

                //======== coordinatesPanel ========
                {
                    coordinatesPanel.setLayout(new HorizontalLayout(6));

                    //---- coordinatesXLabel ----
                    coordinatesXLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.x"));
                    coordinatesPanel.add(coordinatesXLabel);

                    //---- coordinatesXTF ----
                    coordinatesXTF.setPreferredSize(new Dimension(60, 25));
                    coordinatesPanel.add(coordinatesXTF);

                    //---- coordinatesYLabel ----
                    coordinatesYLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.y"));
                    coordinatesPanel.add(coordinatesYLabel);

                    //---- coordinatesYTF ----
                    coordinatesYTF.setPreferredSize(new Dimension(60, 25));
                    coordinatesPanel.add(coordinatesYTF);
                }
                inputPanel.add(coordinatesPanel);
            }
            add(inputPanel, BorderLayout.CENTER);
        }
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getEnginePowerTF() {
        return enginePowerTF;
    }

    public JTextField getNumberOfWheelsTF() {
        return numberOfWheelsTF;
    }

    public JComboBox getFuelTypeComboBox() {
        return fuelTypeComboBox;
    }

    public JComboBox getHairColorComboBox() {
        return hairColorComboBox;
    }

    public JTextField getCoordinatesXTF() {
        return coordinatesXTF;
    }

    public JTextField getCoordinatesYTF() {
        return coordinatesYTF;
    }

    public JTextField getDistanceTravelledTF() {
        return distanceTravelledTF;
    }

    public JTextField getLocationYTF() {
        return locationYTF;
    }

    public JTextField getLocationNameTF() {
        return locationNameTF;
    }

    public void setTexts() {
        okButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.ok"));
        cancelButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.cancel"));
        nameLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.name"));
        enginePowerLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.engine_power"));
        numberOfWheelsLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.num_of_wheels"));
        fuelTypeLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.fuel_type"));
        coordinatesLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.coordinates"));
        coordinatesXLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.x"));
        coordinatesYLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.y"));
        distanceTravelledLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.dist"));
        locationYLabel.setText(MessageManager.getInstance().getLocalMessages().getString("label.y"));
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void clearInputs() {
        nameTF.setText("");
        enginePowerTF.setText("");
        numberOfWheelsTF.setText("");
        coordinatesXTF.setText("");
        coordinatesYTF.setText("");
        distanceTravelledTF.setText("");
        locationYTF.setText("");
        locationNameTF.setText("");
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}
