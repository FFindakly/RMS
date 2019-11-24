package tables;

import daos.MenuItemTableDAO;
import database.Const;
import database.Database;
import javabeans.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */

public class MenuItemsTable implements MenuItemTableDAO {

    Database db = Database.getInstance();
    ArrayList<MenuItem> items;

    @Override
    public ArrayList<MenuItem> getAllMenuItems() {
        return null;
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
