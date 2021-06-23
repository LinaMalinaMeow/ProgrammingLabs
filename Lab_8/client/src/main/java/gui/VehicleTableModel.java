package gui;

import collection.ClientCollectionManager;
import message.MessageManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

//для того, чтобы табличка корректно отображалась
public class VehicleTableModel extends AbstractTableModel {
    private ClientCollectionManager collectionManager;
    private List<String> columnHeader;

    public VehicleTableModel(ClientCollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.columnHeader = new ArrayList<>(13);
        updateColumnHeaders();
    }

    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        return collectionManager.size();
    }

    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return collectionManager.fieldCount();
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return collectionManager.getField(rowIndex, columnIndex);
    }

    /**
     * Returns a default name for the column using spreadsheet conventions:
     * A, B, C, ... Z, AA, AB, etc.  If <code>column</code> cannot be found,
     * returns an empty string.
     *
     * @param column the column being queried
     * @return a string containing the default name of <code>column</code>
     */
    @Override
    public String getColumnName(int column) {
        return columnHeader.get(column);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
            case 5:
            case 6:
            case 8:
                return Integer.class;
            case 1:
            case 4:
            case 7:
            case 9:
                return String.class;
            case 2:
            case 3:
                return Float.class;
            default:
                throw new IllegalArgumentException(
                        "Invalid column: " + column);
        }
    }

    public void updateColumnHeaders(){
        columnHeader.clear();
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.id"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.name"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.coordinates_x"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.coordinates_y"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.creation_date"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.engine_power"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.number_of_wheels"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.fuel_type"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.distance_travelled"));
        columnHeader.add(MessageManager.getInstance().getLocalMessages().getString("column.username"));

    }
}
