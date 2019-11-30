package tables;

import daos.MenuItemTableDAO;
import database.Const;
import database.Database;
import javabeans.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */

public class MenuItemsTable implements MenuItemTableDAO {

    Database db = Database.getInstance();
    ArrayList<MenuItem> menuItems;
    ObservableList<MenuItem> allItems;

    @Override
    public ArrayList<MenuItem> getAllMenuItems() {
        String query = "SELECT * FROM " + Const.TABLE_MENU_ITEMS;
        menuItems = new ArrayList<>();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                //int id, String itemName, String itemCategory, String itemDisc, double price, String imagePath
                menuItems.add(new MenuItem(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getString(Const.MENU_ITEM_CATEGORY),
                        data.getString(Const.MENU_ITEM_DISC),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    @Override
    public MenuItem getMenuItem(MenuItem item) {
        return null;
    }

    @Override
    public void createMenuItem(MenuItem item) {

        String query = "INSERT INTO " + Const.TABLE_MENU_ITEMS +
                "(" + Const.MENU_ITEM_NAME + ", " +
                Const.MENU_ITEM_CATEGORY + ", " +
                Const.MENU_ITEM_DISC + ", " +
                Const.MENU_ITEM_PRICE + ", " +
                Const.MENU_ITEM_IMAGE + ") VALUES ('" +
                item.getItemName() + "', '" + item.getItemCategory() + "', '" + item.getItemDisc() + "', '" +
                item.getPrice() + "', '" + item.getImagePath() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("New item has been inserted to menu successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenuItem(MenuItem item) {

        String query = "DELETE FROM " + Const.TABLE_MENU_ITEMS + " WHERE " +
                Const.MENU_ITEM_ID + " = " + item.getId();

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Item has been deleted from the inventory successfully!");
        } catch (SQLException e) {
            showAlert(e.getMessage());
        }

    }

    @Override
    public void updateMenuItem(MenuItem item) {

        String query = "UPDATE " + Const.TABLE_MENU_ITEMS + " SET " +
                Const.MENU_ITEM_NAME + " = '" + item.getItemName() + "', " +
                Const.MENU_ITEM_CATEGORY + " = '" + item.getItemCategory() + "', " +
                Const.MENU_ITEM_PRICE + " = " + item.getPrice() + ", " +
                Const.MENU_ITEM_DISC + " = '" + item.getItemDisc() + "' " +
                " WHERE " + Const.MENU_ITEM_ID + " = " + item.getId();

        try {
            db.getConnection().createStatement().execute(query);
            showAlert("Item has been updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<MenuItem> loadUpdateMenuItemsTableView() {
        String query = "SELECT * FROM " + Const.TABLE_MENU_ITEMS;
        allItems = FXCollections.observableArrayList();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                //int id, String itemName, String itemCategory, String itemDisc, double price, String imagePath
                allItems.add(new MenuItem(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getString(Const.MENU_ITEM_CATEGORY),
                        data.getString(Const.MENU_ITEM_DISC),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return allItems;
    }


    /**
     * This function is to create an alert message
     * @param message
     */
    private void showAlert(String message){

        JOptionPane.showMessageDialog(null, message);
    }
}
