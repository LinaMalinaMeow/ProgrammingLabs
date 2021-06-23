package gui;

import collection.ClientCollectionManager;
import message.MessageManager;
import object.VehicleDisplayer;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    private JMenuBar menuBar;
    private JMenu userMenu;
    private JMenuItem changeColor;
    private JMenuItem changeUser;
    private JMenu localeMenu;
    private JMenuItem russianLocale;
    private JMenuItem belarusLocale;
    private JMenuItem bulgarianLocale;
    private JMenuItem costaRicaLocale;
    private JMenu commandsMenu;
    private JMenuItem helpCommand;
    private JMenuItem infoCommand;
    private JMenu addCommandsMenu;
    private JMenuItem addCommand;
    private JMenuItem updateCommand;
    private JMenuItem removeCommand;
    private JMenuItem clearCommand;
    private JMenuItem head;
    private JMenuItem executeScriptCommand;
    private JMenu filter;
    private JMenuItem idFilter;
    private JMenuItem nameFilter;
    private JMenuItem coordinatesXFilter;
    private JMenuItem coordinatesYFilter;
    private JMenuItem creationDateFilter;
    private JMenuItem enginePowerFilter;
    private JMenuItem numberOfWheelsFilter;
    private JMenuItem distanceTravelledFilter;
    private JMenuItem fuelTypeFilter;
    private JMenuItem usernameFilter;
    private JMenuItem remove_head;
    private JMenuItem minByDistance;
    private JMenuItem remove_first;
    private JMenuItem print_field_ascending_number_of_wheels;
    private JTabbedPane tabbedPane;
    private JButton exitTableButton;
    private JButton exitVisualizeButton;
    private JTable table;
    private JScrollPane visualizeScrollPane;
    private Visualize visualize;
    private VehicleTableModel vehicleTableModel;
    private ClientCollectionManager collectionManager;
    private final VehicleDisplayer vehicleDisplayer;

    public MainPanel(VehicleTableModel vehicleTableModel, ClientCollectionManager collectionManager, VehicleDisplayer vehicleDisplayer, ControlManager controlManager) {
        super();
        this.vehicleTableModel = vehicleTableModel;
        this.collectionManager = collectionManager;
        this.vehicleDisplayer = vehicleDisplayer;
        initComponents(controlManager);
    }

    private void initComponents(ControlManager controlManager) {
        menuBar = new JMenuBar();
        userMenu = new JMenu();
        changeColor = new JMenuItem();
        changeUser = new JMenuItem();
        localeMenu = new JMenu();
        russianLocale = new JMenuItem();
        belarusLocale = new JMenuItem();
        bulgarianLocale = new JMenuItem();
        costaRicaLocale = new JMenuItem();
        commandsMenu = new JMenu();
        helpCommand = new JMenuItem();
        infoCommand = new JMenuItem();
        addCommandsMenu = new JMenu();
        addCommand = new JMenuItem();
        updateCommand = new JMenuItem();
        removeCommand = new JMenuItem();
        clearCommand = new JMenuItem();
        minByDistance = new JMenuItem();
        print_field_ascending_number_of_wheels = new JMenuItem();
        head = new JMenuItem();
        remove_head = new JMenuItem();
        executeScriptCommand = new JMenuItem();
        filter = new JMenu();
        idFilter = new JMenuItem();
        nameFilter = new JMenuItem();
        coordinatesXFilter = new JMenuItem();
        coordinatesYFilter = new JMenuItem();
        creationDateFilter = new JMenuItem();
        enginePowerFilter = new JMenuItem();
        remove_first = new JMenuItem();
        numberOfWheelsFilter = new JMenuItem();
        distanceTravelledFilter = new JMenuItem();
        fuelTypeFilter = new JMenuItem();
        usernameFilter = new JMenuItem();
        tabbedPane = new JTabbedPane();
        JPanel tableTab = new JPanel();
        table = new JTable(vehicleTableModel);
        visualize = new Visualize(collectionManager, vehicleDisplayer, controlManager);
        JPanel exitTablePanel = new JPanel();
        exitTableButton = new JButton();
        JPanel exitVisualizePanel = new JPanel();
        exitVisualizeButton = new JButton();
        JScrollPane tableScrollPane = new JScrollPane();
        JPanel visualizeTab = new JPanel();
        visualizeScrollPane = new JScrollPane();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //======== menuBar ========
        {

            //======== userMenu ========
            {
                userMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.login"));

                //---- changeColor ----
                changeColor.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.change_color"));
                userMenu.add(changeColor);

                //---- changeUser ----
                changeUser.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.change_user"));
                userMenu.add(changeUser);
            }
            menuBar.add(userMenu);

            //======== localeMenu ========
            {
                localeMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.locale"));

                //---- russianLocale ----
                russianLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.russian"));
                localeMenu.add(russianLocale);

                //---- serbianLocale ----
                belarusLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.belarus"));
                localeMenu.add(belarusLocale);

                //---- hungarianLocale ----
                bulgarianLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.bulgarian"));
                localeMenu.add(bulgarianLocale);

                //---- spanishLocale ----
                costaRicaLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.costa_rica"));
                localeMenu.add(costaRicaLocale);
            }
            menuBar.add(localeMenu);

            //======== commandsMenu ========
            {
                commandsMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.commands"));

                //---- helpCommand ----
                helpCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.help"));
                commandsMenu.add(helpCommand);

                //---- infoCommand ----
                infoCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.info"));
                commandsMenu.add(infoCommand);

                //---- addCommand ----
                addCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.add"));
                commandsMenu.add(addCommand);

                //---- updateCommand ----
                updateCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.update"));
                commandsMenu.add(updateCommand);

                //---- removeCommand ----
                removeCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove"));
                commandsMenu.add(removeCommand);

                //---- clearCommand ----
                clearCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.clear"));
                commandsMenu.add(clearCommand);

                //---- headCommand ----
                head.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.head"));
                commandsMenu.add(head);

                //---- executeScriptCommand ----
                executeScriptCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.execute_script"));
                commandsMenu.add(executeScriptCommand);

                //---- removeHeadCommand ----
                remove_head.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove_head"));
                commandsMenu.add(remove_head);

                //---- minByDistanceCommand ----
                minByDistance.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.min_by_distance"));
                commandsMenu.add(minByDistance);

                //---- remove_firstCommand ----
                remove_first.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove_first"));
                commandsMenu.add(remove_first);

                //---- print_field_ascending_number_of_wheelsCommand ----
                print_field_ascending_number_of_wheels.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.print_field"));
                commandsMenu.add(print_field_ascending_number_of_wheels);

            }
            menuBar.add(commandsMenu);

            //======== filter ========
            {
                filter.setText(MessageManager.getInstance().getLocalMessages().getString("menu.filter"));

                //---- idFilter ----
                idFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.id_filter"));
                filter.add(idFilter);

                //---- nameFilter ----
                nameFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.name_filter"));
                filter.add(nameFilter);

                //---- coordinatesXFilter ----
                coordinatesXFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.coordinates_x_filter"));
                filter.add(coordinatesXFilter);

                //---- coordinatesYFilter ----
                coordinatesYFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.coordinates_y_filter"));
                filter.add(coordinatesYFilter);

                //---- creationDateFilter ----
                creationDateFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.creation_date_filter"));
                filter.add(creationDateFilter);

                //---- enginePowerFilter ----
                enginePowerFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.engine_power_filter"));
                filter.add(enginePowerFilter);

                //---- numOfWheelsFilter ----
                numberOfWheelsFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.number_of_wheels_filter"));
                filter.add(numberOfWheelsFilter);

                //---- distanceTravelledFilter ----
                distanceTravelledFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.distance_travelled_filter"));
                filter.add(distanceTravelledFilter);

                //---- fuelTypeFilter ----
                fuelTypeFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.fuel_type_filter"));
                filter.add(fuelTypeFilter);

                //---- usernameFilter ----
                usernameFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.username_filter"));
                filter.add(usernameFilter);
            }
            menuBar.add(filter);
        }

        //======== tabbedPane ========
        {

            //======== tableTab ========
            {
                tableTab.setBorder(new javax.swing.border.EmptyBorder(6, 6, 6, 6));
                tableTab.setLayout(new BorderLayout(6, 6));

                //======== exitTablePanel ========
                {
                    exitTablePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    //---- exitTableButton ----
                    exitTableButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.exit"));
                    exitTablePanel.add(exitTableButton);
                }
                tableTab.add(exitTablePanel, BorderLayout.SOUTH);

                //======== tableScrollPane ========
                {
                    tableScrollPane.setViewportView(table);
                }
                tableTab.add(tableScrollPane, BorderLayout.CENTER);
            }
            tabbedPane.addTab(MessageManager.getInstance().getLocalMessages().getString("tab.table"), tableTab);

            //======== visualizeTab ========
            {
                visualizeTab.setLayout(new BorderLayout(6, 6));
                visualizeTab.setBorder(new javax.swing.border.EmptyBorder(6, 6, 6, 6));

                //======== exitVisualizePanel ========
                {
                    exitVisualizePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    //---- exitTableButton ----
                    exitVisualizeButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.exit"));
                    exitVisualizePanel.add(exitVisualizeButton);
                }
                visualizeTab.add(exitVisualizePanel, BorderLayout.SOUTH);

                //======== visualizeScrollPane ========
                {
                    visualizeScrollPane = new JScrollPane(visualize);
                }
                visualizeTab.add(visualizeScrollPane, BorderLayout.CENTER);

            }
            tabbedPane.addTab(MessageManager.getInstance().getLocalMessages().getString("tab.visualize"), visualizeTab);
        }
        add(tabbedPane);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getUserMenu() {
        return userMenu;
    }

    public JMenuItem getChangeColor() {
        return changeColor;
    }

    public JMenuItem getChangeUser() {
        return changeUser;
    }

    public JMenuItem getRussianLocale() {
        return russianLocale;
    }

    public JMenuItem getBelarusLocale() {
        return belarusLocale;
    }

    public JMenuItem getBulgarianLocale() {
        return bulgarianLocale;
    }

    public JMenuItem getCostaRicaLocale() {
        return costaRicaLocale;
    }

    public JMenuItem getHelpCommand() {
        return helpCommand;
    }

    public JMenuItem getInfoCommand() {
        return infoCommand;
    }

    public JMenuItem getAddCommand() {
        return addCommand;
    }

    public JMenuItem getUpdateCommand() {
        return updateCommand;
    }

    public JMenuItem getRemoveCommand() {
        return removeCommand;
    }

    public JMenuItem getClearCommand() {
        return clearCommand;
    }


    public JMenuItem getHead() {
        return head;
    }

    public JMenuItem getExecuteScriptCommand() {
        return executeScriptCommand;
    }

    public JMenuItem getIdFilter() {
        return idFilter;
    }

    public JMenuItem getCoordinatesXFilter() {
        return coordinatesXFilter;
    }

    public JMenuItem getCoordinatesYFilter() {
        return coordinatesYFilter;
    }

    public JMenuItem getCreationDateFilter() {
        return creationDateFilter;
    }

    public JMenuItem getEnginePowerFilter() {
        return enginePowerFilter;
    }

    public JMenuItem getRemove_head() {
        return remove_head;
    }

    public JMenuItem getMinByDistance() {
        return minByDistance;
    }

    public JMenuItem getRemove_first() {
        return remove_first;
    }

    public JMenuItem getPrint_field_ascending_number_of_wheels() {
        return print_field_ascending_number_of_wheels;
    }

    public JMenuItem getNumberOfWheelsFilter() {
        return numberOfWheelsFilter;
    }

    public JMenuItem getNameFilter() {
        return nameFilter;
    }

    public JMenuItem getDistanceTravelledFilter() {
        return distanceTravelledFilter;
    }

    public JMenuItem getFuelTypeFilter() {
        return fuelTypeFilter;
    }

    public JMenuItem getUsernameFilter() {
        return usernameFilter;
    }

    public JButton getExitTableButton() {
        return exitTableButton;
    }

    public JButton getExitVisualizeButton() {
        return exitVisualizeButton;
    }

    public JTable getTable() {
        return table;
    }

    public Visualize getVisualize() {
        return visualize;
    }

    public void setTexts(){
        localeMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.locale"));
        commandsMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.commands"));
        addCommandsMenu.setText(MessageManager.getInstance().getLocalMessages().getString("menu.add"));
        filter.setText(MessageManager.getInstance().getLocalMessages().getString("menu.filter"));
        changeColor.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.change_color"));
        changeUser.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.change_user"));
        russianLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.russian"));
        bulgarianLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.bulgarian"));
        belarusLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.belarus"));
        costaRicaLocale.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.costa_rica"));
        helpCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.help"));
        infoCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.info"));
        addCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.add"));
        updateCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.update"));
        removeCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove"));
        clearCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.clear"));
        head.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.head"));
        executeScriptCommand.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.execute_script"));
        idFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.id_filter"));
        nameFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.name_filter"));
        coordinatesXFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.coordinates_x_filter"));
        coordinatesYFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.coordinates_y_filter"));
        creationDateFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.creation_date_filter"));
        enginePowerFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.engine_power_filter"));
        numberOfWheelsFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.number_of_wheels_filter"));
        distanceTravelledFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.distance_travelled_filter"));
        fuelTypeFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.fuel_type_filter"));
        usernameFilter.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.username_filter"));
        tabbedPane.setTitleAt(0, MessageManager.getInstance().getLocalMessages().getString("tab.table"));
        tabbedPane.setTitleAt(1, MessageManager.getInstance().getLocalMessages().getString("tab.visualize"));
        exitTableButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.exit"));
        exitVisualizeButton.setText(MessageManager.getInstance().getLocalMessages().getString("button.exit"));
        minByDistance.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.min_by_distance"));
        remove_head.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove_head"));
        remove_first.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.remove_first"));
        print_field_ascending_number_of_wheels.setText(MessageManager.getInstance().getLocalMessages().getString("menu_item.print_field"));
        vehicleTableModel.updateColumnHeaders();
        vehicleTableModel.fireTableStructureChanged();
    }
}