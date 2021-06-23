package gui;

import app.AuthModule;
import collection.ClientCollectionManager;
import communication.Response;
import communication.UserImpl;
import message.MessageManager;
import object.*;
import org.jdesktop.swingx.renderer.IconValue;
import reader.Asker;
import reader.GUIAdapter;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class ControlManagerImpl implements ControlManager{
    private volatile boolean updatingCollection;
    private final JFrame frame;
    private JDialog dialog;
    private final AuthPanel authPanel;
    private final MainPanel mainPanel;
    private final TableRowSorter<TableModel> sorter;
    private final CreateVehiclePanel createVehiclePanel;
    private final VehicleTableModel tableModel;
    private final AuthModule authManager;
    private final ClientCollectionManager collectionManager;
    private final GUIAdapter commandManager;
    private final Map<String, Locale> locales;
    private Thread updatingCollectionThread;
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final FuelType[] fuelTypeConstants;
    private final VehicleDisplayer vehicleDisplayer;
    private final Asker asker;

    public ControlManagerImpl(ClientCollectionManager collectionManager, AuthModule authManager,
                              GUIAdapter commandManager, VehicleDisplayer vehicleDisplayer, Asker asker) {
        this.authManager = authManager;
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.vehicleDisplayer = vehicleDisplayer;
        this.asker = asker;
        fuelTypeConstants = new FuelType[5];
        fuelTypeConstants[0] = FuelType.ALCOHOL;
        fuelTypeConstants[1] = FuelType.DIESEL;
        fuelTypeConstants[2] = FuelType.ANTIMATTER;
        fuelTypeConstants[3] = FuelType.MANPOWER;
        fuelTypeConstants[4] = FuelType.KEROSENE;
        locales = new HashMap<>(4);
        locales.put("ru", new Locale("ru", "RU"));
        locales.put("by", new Locale("by", "BY"));
        locales.put("bg", new Locale("bg", "BG"));
        locales.put("es_CR", new Locale("es", "CR"));
        tableModel = new VehicleTableModel(collectionManager);
        frame = new JFrame("Lab8");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel = new MainPanel(tableModel, collectionManager, this.vehicleDisplayer, this);
        sorter = new TableRowSorter<>(tableModel);
        mainPanel.getTable().setRowSorter(sorter);
        authPanel = new AuthPanel();
        createVehiclePanel = new CreateVehiclePanel();
        addActionListeners();
    }

    private void authPanel() {
        updatingCollection = false;
        frame.remove(mainPanel);
        frame.setJMenuBar(null);
        frame.add(authPanel);
        frame.setBounds(toolkit.getScreenSize().width / 2 - 160, toolkit.getScreenSize().height / 2 - 120,
                320, 240);
    }

    private void mainPanel() {
        updatingCollection = true;
        frame.remove(authPanel);
        frame.add(mainPanel);
        frame.setJMenuBar(mainPanel.getMenuBar());
        mainPanel.getUserMenu().setText(authManager.getUser().getLogin());
        frame.setBounds(toolkit.getScreenSize().width / 2 - 640, toolkit.getScreenSize().height / 2 - 360,
                1280, 720);
    }

    private void createVehicleDialog(String title) {
        updatingCollection = false;
        if(createVehiclePanel != null && createVehiclePanel.getCommand().equals("add"))
            createVehiclePanel.clearInputs();
        dialog = new JDialog(frame, title);
        dialog.setResizable(false);
        dialog.add(createVehiclePanel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void addActionListeners() {
        authPanel.getCancelButton().addActionListener(e -> {
            System.exit(0);
        });

        authPanel.getCancelRegisterButton().addActionListener(e -> {
            System.exit(0);
        });

        authPanel.getLoginButton().addActionListener(e -> {
            if(!authPanel.getLoginTF().getText().isEmpty() && !Arrays.toString(authPanel.getPwdTF().getPassword()).isEmpty()) {
                asker.setUser(new UserImpl(authPanel.getLoginTF().getText(), new String(authPanel.getPwdTF().getPassword())));
                Response response = commandManager.getResponse("login");
                if (!response.isSuccessful())
                    JOptionPane.showMessageDialog(frame, response.getMessage(),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                else
                    mainPanel();
                authPanel.getLoginTF().setText("");
                authPanel.getPwdTF().setText("");
                authPanel.getLoginRegisterTF().setText("");
                authPanel.getPwdRegisterTF().setText("");
                authPanel.getRepeatPwdTF().setText("");
            } else
                JOptionPane.showMessageDialog(frame, MessageManager.getInstance().getLocalMessages().getString("err.login_empty"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
        });

        authPanel.getRegisterButton().addActionListener(e -> {
            Response response = null;
            if(!authPanel.getLoginRegisterTF().getText().isEmpty() && !Arrays.toString(authPanel.getPwdRegisterTF().getPassword()).isEmpty()) {
                if (Arrays.equals(authPanel.getPwdRegisterTF().getPassword(), authPanel.getRepeatPwdTF().getPassword())) {
                    asker.setUser(new UserImpl(authPanel.getLoginRegisterTF().getText(), new String(authPanel.getPwdRegisterTF().getPassword())));
                    response = commandManager.getResponse("register");
                    authPanel.getLoginTF().setText("");
                    authPanel.getPwdTF().setText("");
                    authPanel.getLoginRegisterTF().setText("");
                    authPanel.getPwdRegisterTF().setText("");
                    authPanel.getRepeatPwdTF().setText("");
                } else {
                    authPanel.getPwdRegisterTF().setText("");
                    authPanel.getRepeatPwdTF().setText("");
                    JOptionPane.showMessageDialog(frame, MessageManager.getInstance().getLocalMessages().getString("err.pwd_not_match"),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                }
                if (response != null && !response.isSuccessful()) {
                    JOptionPane.showMessageDialog(frame, response.getMessage(),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                } else if (response != null && response.isSuccessful())
                    mainPanel();
            } else
                JOptionPane.showMessageDialog(frame, MessageManager.getInstance().getLocalMessages().getString("err.login_empty"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
        });

        mainPanel.getExitTableButton().addActionListener(e -> {
            System.exit(0);
        });

        mainPanel.getExitVisualizeButton().addActionListener(e -> {
            System.exit(0);
        });

        mainPanel.getChangeColor().addActionListener(e -> {
            mainPanel.getVisualize().changeColor(authManager.getUser().getLogin());
        });

        mainPanel.getChangeUser().addActionListener(e -> {
            authPanel();
        });

        mainPanel.getRussianLocale().addActionListener(e -> setLocale(locales.get("ru")));

        mainPanel.getBulgarianLocale().addActionListener(e -> setLocale(locales.get("bg")));

        mainPanel.getBelarusLocale().addActionListener(e -> setLocale(locales.get("by")));

        mainPanel.getCostaRicaLocale().addActionListener(e -> setLocale(locales.get("es_CR")));

        mainPanel.getInfoCommand().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("info");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.info"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getHelpCommand().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("help");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.help"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getHead().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("head");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.head"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getClearCommand().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("clear");
            collectionManager.setVehicles(response.getCollection());
            tableModel.fireTableDataChanged();
            mainPanel.getVisualize().update(authManager.getUser());
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getMinByDistance().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("min_by_distance_travelled");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getRemove_head().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("remove_head");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.head"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getRemove_first().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("remove_first");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getPrint_field_ascending_number_of_wheels().addActionListener(e -> {
            updatingCollection = false;
            Response response = commandManager.getResponse("print_field_ascending_number_of_wheels");
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.field_asc"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        mainPanel.getRemoveCommand().addActionListener(e -> {
            Integer id = (Integer) JOptionPane.showInputDialog(frame, MessageManager.getInstance().getLocalMessages().getString("input.id"),
                    MessageManager.getInstance().getLocalMessages().getString("title.remove"),
                    JOptionPane.QUESTION_MESSAGE,
                    IconValue.NULL_ICON,
                    collectionManager.getVehicleStream()
                            .filter(p -> p.getUsername().equals(authManager.getUser().getLogin()))
                            .map(Vehicle::getId)
                            .toArray(),
                    null);
            if (id == null) return;
            updatingCollection = false;
            Response response = commandManager.getResponse("remove_by_id " + String.valueOf(id));
            collectionManager.setVehicles(response.getCollection());
            tableModel.fireTableDataChanged();
            mainPanel.getVisualize().update(authManager.getUser());
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            updatingCollection = true;
        });

        createVehiclePanel.getCancelButton().addActionListener(e -> {
            dialog.dispose();
            createVehiclePanel.clearInputs();
        });

        createVehiclePanel.getOkButton().addActionListener(e -> {
            String errMsg = validateVehicle();
            if (errMsg.equals("")) {
                asker.setVehicleBuilder(createVehicle());
                Response response = commandManager.getResponse(createVehiclePanel.getCommand());
                collectionManager.setVehicles(response.getCollection());
                tableModel.fireTableDataChanged();
                mainPanel.getVisualize().update(authManager.getUser());
                dialog.dispose();
                createVehiclePanel.clearInputs();
                if (response.isSuccessful())
                    JOptionPane.showMessageDialog(frame, response.getMessage(),
                            MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(frame, response.getMessage(),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                updatingCollection = true;
            } else
                JOptionPane.showMessageDialog(frame,errMsg,
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
        });

        mainPanel.getAddCommand().addActionListener(e -> {
            createVehiclePanel.setCommand("add");
            createVehiclePanel.setArg(null);
            createVehicleDialog(MessageManager.getInstance().getLocalMessages().getString("menu_item.add"));
        });

        mainPanel.getUpdateCommand().addActionListener(e -> {
            update(null);
        });

        mainPanel.getExecuteScriptCommand().addActionListener(e -> {
            String file = (String) JOptionPane.showInputDialog(frame, MessageManager.getInstance().getLocalMessages().getString("input.script"),
                    MessageManager.getInstance().getLocalMessages().getString("title.script"),
                    JOptionPane.QUESTION_MESSAGE,
                    IconValue.NULL_ICON,
                    null,
                    null);
            if (file == null) return;
            Response response = commandManager.getResponse("execute_script " + file);
            if (response.isSuccessful())
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.command_executed"), JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame, response.getMessage(),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
        });

        mainPanel.getIdFilter().addActionListener(e -> {
            Integer id = (Integer) JOptionPane.showInputDialog(frame, MessageManager.getInstance().getLocalMessages().getString("input.id"),
                    MessageManager.getInstance().getLocalMessages().getString("title.filter"),
                    JOptionPane.QUESTION_MESSAGE,
                    IconValue.NULL_ICON,
                    collectionManager.getVehicleStream()
                            .map(Vehicle::getId)
                            .toArray(),
                    null);
            if (id == null) return;
            sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, id, 0));
        });

        mainPanel.getNameFilter().addActionListener(e -> {
            String nameRegEx = JOptionPane.showInputDialog(frame,
                    MessageManager.getInstance().getLocalMessages().getString("input.regex_name"),
                    MessageManager.getInstance().getLocalMessages().getString("title.filter"));
            if (nameRegEx.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(nameRegEx, 1));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(frame,
                            MessageManager.getInstance().getLocalMessages().getString("err.bad_regex"),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mainPanel.getCoordinatesXFilter().addActionListener(e -> {
            try {
                Double coordinatesX = Double.parseDouble(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.coordinates_x"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, coordinatesX, 2));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_float"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getCoordinatesYFilter().addActionListener(e -> {
            try {
                Long coordinatesY = Long.parseLong(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.coordinates_y"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, coordinatesY, 3));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_integer"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getCreationDateFilter().addActionListener(e -> {
            try {
                LocalDate creationDate = LocalDate.parse(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.creation_date"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.regexFilter(creationDate.toString(), 4));
            } catch (DateTimeParseException dateTimeParseException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_date"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getEnginePowerFilter().addActionListener(e -> {
            try {
                Long height = Long.parseLong(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.engine_power"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, height, 5));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_integer"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getNumberOfWheelsFilter().addActionListener(e -> {
            try {
                Integer num = Integer.parseInt(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.num_of_wheels"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, num, 6));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_integer"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getDistanceTravelledFilter().addActionListener(e -> {
            try {
                Integer dist = Integer.parseInt(JOptionPane.showInputDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("input.dist_travelled"),
                        MessageManager.getInstance().getLocalMessages().getString("title.filter")));
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, dist, 8));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(frame,
                        MessageManager.getInstance().getLocalMessages().getString("err.no_integer"),
                        MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.getFuelTypeFilter().addActionListener(e -> {
            FuelType fuelType = (FuelType) JOptionPane.showInputDialog(frame,
                    MessageManager.getInstance().getLocalMessages().getString("input.fuel_type"),
                    MessageManager.getInstance().getLocalMessages().getString("title.filter"),
                    JOptionPane.QUESTION_MESSAGE,
                    IconValue.NULL_ICON,
                    fuelTypeConstants, FuelType.ALCOHOL);
            sorter.setRowFilter(RowFilter.regexFilter(fuelType.toString(), 7));
        });

        mainPanel.getUsernameFilter().addActionListener(e -> {
            String owner = JOptionPane.showInputDialog(frame,
                    MessageManager.getInstance().getLocalMessages().getString("input.username"),
                    MessageManager.getInstance().getLocalMessages().getString("title.filter"));
            if (owner.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(owner, 9));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(frame,
                            MessageManager.getInstance().getLocalMessages().getString("err.bad_regex"),
                            MessageManager.getInstance().getLocalMessages().getString("title.error"), JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        mainPanel.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = mainPanel.getTable().getSelectedRow();
                    int id = (int) mainPanel.getTable().getModel().getValueAt(row, 0);
                    if (collectionManager.getVehicleStream().anyMatch(x -> x.getId() == id && x.getUsername().equals(authManager.getUser().getLogin())))
                        update(id);
                }
            }
        });
    }

    public void update(Integer optionalID) {
        Integer id;
        if(optionalID == null)
            id = (Integer) JOptionPane.showInputDialog(frame, MessageManager.getInstance().getLocalMessages().getString("input.id"),
                    MessageManager.getInstance().getLocalMessages().getString("title.update"),
                    JOptionPane.QUESTION_MESSAGE,
                    IconValue.NULL_ICON,
                    collectionManager.getVehicleStream()
                            .filter(p -> p.getUsername().equals(authManager.getUser().getLogin()))
                            .map(Vehicle::getId)
                            .toArray(),
                    null);
        else
            id = optionalID;
        if (id == null) return;
        createVehiclePanel.setArg(String.valueOf(id));
        createVehiclePanel.setCommand("update");
        Vehicle old = collectionManager.getVehicleStream().filter(p -> p.getId() == id).findAny().get();
        createVehiclePanel.getNameTF().setText(old.getName());
        createVehiclePanel.getEnginePowerTF().setText(String.valueOf(old.getEnginePower()));
        createVehiclePanel.getNumberOfWheelsTF().setText(String.valueOf(old.getNumberOfWheels()));
        createVehiclePanel.getFuelTypeComboBox().setSelectedItem(old.getFuelType());
        createVehiclePanel.getCoordinatesXTF().setText(String.valueOf(old.getCoordinates().getX()));
        createVehiclePanel.getCoordinatesYTF().setText(String.valueOf(old.getCoordinates().getY()));
        createVehiclePanel.getDistanceTravelledTF().setText(String.valueOf(old.getDistanceTravelled()));
        createVehicleDialog(MessageManager.getInstance().getLocalMessages().getString("menu_item.update"));
        createVehiclePanel.setCommand("update " + id);
    }

    private String validateVehicle() {
        VehicleValidator vehicleValidator = new VehicleValidatorImpl();
        StringBuilder errorMsg = new StringBuilder();
        if (!vehicleValidator.validateName(createVehiclePanel.getNameTF().getText())) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_name"))
                    .append("\n");
            createVehiclePanel.getNameTF().setText("");
        }
        try {
            if (!vehicleValidator.validateX(Float.parseFloat(createVehiclePanel.getCoordinatesXTF().getText()))) {
                errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_coordinates_x"))
                        .append("\n");
                createVehiclePanel.getCoordinatesXTF().setText("");
            }
        } catch (NumberFormatException e) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_coordinates_x"))
                    .append("\n");
            createVehiclePanel.getCoordinatesXTF().setText("");
        }
        try {
            if (!vehicleValidator.validateY(Float.parseFloat(createVehiclePanel.getCoordinatesYTF().getText()))) {
                errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_coordinates_y"))
                        .append("\n");
                createVehiclePanel.getCoordinatesYTF().setText("");
            }
        } catch (NumberFormatException e) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_coordinates_y"))
                    .append("\n");
            createVehiclePanel.getCoordinatesYTF().setText("");
        }
        try {
            if (!vehicleValidator.validateEnginePower(Integer.parseInt(createVehiclePanel.getEnginePowerTF().getText()))) {
                errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_engine_power"))
                        .append("\n");
                createVehiclePanel.getEnginePowerTF().setText("");
            }
        } catch (NumberFormatException e) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_engine_power"))
                    .append("\n");
            createVehiclePanel.getEnginePowerTF().setText("");
        }
        try {
            if (!vehicleValidator.validateNumOfWheels(Integer.parseInt(createVehiclePanel.getNumberOfWheelsTF().getText()))) {
                errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_num_of_wheels"))
                        .append("\n");
                createVehiclePanel.getNumberOfWheelsTF().setText("");
            }
        } catch (NumberFormatException e) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_num_of_wheels"))
                    .append("\n");
            createVehiclePanel.getDistanceTravelledTF().setText("");
        }
        try {
            if (!vehicleValidator.validateDistanceTravelled(Integer.parseInt(createVehiclePanel.getDistanceTravelledTF().getText()))) {
                errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_dist"))
                        .append("\n");
                createVehiclePanel.getDistanceTravelledTF().setText("");
            }
        } catch (NumberFormatException e) {
            errorMsg.append(MessageManager.getInstance().getLocalMessages().getString("err.invalid_dist"))
                    .append("\n");
            createVehiclePanel.getDistanceTravelledTF().setText("");
        }
        return errorMsg.toString();
    }

    private VehicleBuilder createVehicle() {
        VehicleBuilder builder = new VehicleBuilderImpl();
        builder.setName(createVehiclePanel.getNameTF().getText());
        builder.setX(Float.parseFloat(createVehiclePanel.getCoordinatesXTF().getText()));
        builder.setY(Float.parseFloat(createVehiclePanel.getCoordinatesYTF().getText()));
        builder.setEnginePower(Integer.parseInt(createVehiclePanel.getEnginePowerTF().getText()));
        builder.setNumberOfWheels(Integer.parseInt(createVehiclePanel.getNumberOfWheelsTF().getText()));
        builder.setFuelType((FuelType) createVehiclePanel.getFuelTypeComboBox().getSelectedItem());
        builder.setDistanceTravelled(Integer.parseInt(createVehiclePanel.getDistanceTravelledTF().getText()));
        return builder;
    }

    public void start() {
        updatingCollectionThread = new Thread(() -> {
            while (true) {
                try {
                    if (authManager.getUser() != null && updatingCollection) {
                        if(synchronizeCollection()) {
                            tableModel.fireTableDataChanged();
                            mainPanel.getVisualize().update(authManager.getUser());
                        }
                    }
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {

                }
            }
        });
        updatingCollectionThread.start();
        authPanel();
        frame.setVisible(true);
    }

    private boolean synchronizeCollection() {
        Response response = commandManager.getResponse("sync");
        if(response.isSuccessful()) {
            collectionManager.setVehicles(response.getCollection());
            return true;
        } else
            return false;
    }

    private void setLocale(Locale locale) {
        Locale.setDefault(locale);
        mainPanel.setTexts();
        authPanel.setTexts();
        createVehiclePanel.setTexts();
    }
}