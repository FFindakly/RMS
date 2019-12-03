package tables;

import daos.InventoryItemsDAO;
import database.Const;
import database.Database;
import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controllers.Login;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fadi Findakly
 */

public class InventoyTable implements InventoryItemsDAO {

    Database db = Database.getInstance();
    ArrayList<InventoryItem> items;
    ObservableList<InventoryItem> itemsForTrackInventoryTable;

    @Override
    public ArrayList<InventoryItem> getAllInventoryItems() {
        String query = "SELECT * FROM " + Const.TABLE_INVENTORY + " WHERE " + Const.INVENTORY_USER_ID + " = " + Login.userID.get("ID");
        items = new ArrayList<>();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new InventoryItem(
                            data.getString(Const.INVENTORY_ITEM_NAME),
                            data.getString(Const.MEASUREMENT_UNIT),
                            data.getDouble(Const.INVENTORY_ITEM_QUANTITY),
                            data.getDouble(Const.CRITICAL_QUANTITY),
                            data.getInt(Const.ITEM_CATEGORY_ID),
                            data.getInt(Const.INVENTORY_USER_ID)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public InventoryItem getInventoryItem(InventoryItem item) {
        return null;
    }


    @Override
    public void createInventoryItem(InventoryItem item) {
        String query = "INSERT INTO " + Const.TABLE_INVENTORY +
                "(" + Const.INVENTORY_ITEM_NAME + ", " +
                Const.MEASUREMENT_UNIT + ", " +
                Const.INVENTORY_ITEM_QUANTITY + ", " +
                Const.CRITICAL_QUANTITY + ", " +
                Const.ITEM_CATEGORY_ID + ", " +
                Const.INVENTORY_USER_ID +") VALUES ('" +
                item.getItemName() + "', '" + item.getMeasurementUnit() + "', '" +
                item.getQuantity() + "', '" + item.getCriticalQuantity() + "', '" +
                item.getCategoryId() + "', '" + Login.userID.get("ID") +"')";
        System.out.println(query);

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("New item has been inserted to inventory successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void deleteInventoryItem(InventoryItem item) {
        String query = "DELETE FROM " + Const.TABLE_INVENTORY + " WHERE " +
                Const.INVENTORY_ITEM_ID + " = " + item.getItemId() + " AND " + Const.INVENTORY_USER_ID + " = " + Login.userID.get("ID");

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Item has been deleted from the inventory successfully!");
        } catch (SQLException e) {
            showAlert("The item you are trying to delete is used as an ingredient, You may want to update it instead!");
        }
    }

    @Override
    public void updateInventoryItem(InventoryItem item) {
        //UPDATE table_name
        //SET column1 = value1, column2 = value2, ...
        //WHERE condition;
        String query = "UPDATE " + Const.TABLE_INVENTORY + " SET " +
                Const.INVENTORY_ITEM_NAME + " = '" + item.getItemName() + "', " +
                Const.MEASUREMENT_UNIT + " = '" + item.getMeasurementUnit() + "', " +
                Const.INVENTORY_ITEM_QUANTITY + " = " + item.getQuantity() + ", " +
                Const.CRITICAL_QUANTITY + " = " + item.getCriticalQuantity() + ", " +
                Const.ITEM_CATEGORY_ID + " = " + item.getCategoryId() + " " +
                " WHERE " + Const.INVENTORY_ITEM_ID + " = " + item.getItemId() + " AND " + Const.INVENTORY_USER_ID + " = " + Login.userID.get("ID");
        try {
            db.getConnection().createStatement().execute(query);
            showAlert("Item has been updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ObservableList<InventoryItem> loadTrackInventoryTable() {
        String query = "SELECT * FROM " + Const.TABLE_INVENTORY;
        itemsForTrackInventoryTable = FXCollections.observableArrayList();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                itemsForTrackInventoryTable.add(new InventoryItem(
                                                data.getInt(Const.INVENTORY_ITEM_ID),
                                                data.getString(Const.INVENTORY_ITEM_NAME),
                                                data.getString(Const.MEASUREMENT_UNIT),
                                                data.getDouble(Const.INVENTORY_ITEM_QUANTITY),
                                                data.getDouble(Const.CRITICAL_QUANTITY),
                                                data.getInt(Const.ITEM_CATEGORY_ID)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return itemsForTrackInventoryTable;
    }


    /**
     * This function is to create an alret message
     * @param message
     */
    private void showAlert(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
