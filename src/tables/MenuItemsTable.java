package tables;

import daos.MenuItemTableDAO;
import database.Const;
import database.Database;
import javabeans.InventoryItem;
import javabeans.MenuItem;

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

    @Override
    public ArrayList<MenuItem> getAllMenuItems() {
        String query = "SELECT * FROM " + Const.TABLE_MENU_ITEMS;
        menuItems = new ArrayList<>();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                //int id, String itemName, String itemCategory, String itemDisc, double price, String imagePath
                menuItems.add(new MenuItem(data.getInt(Const.MENU_ITEM_ID),
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

    }

    @Override
    public void updateMenuItem(MenuItem item) {

    }
}
