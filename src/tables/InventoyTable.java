package tables;

import daos.InventoryItemsDAO;
import database.Const;
import database.Database;
import javabeans.InventoryCategory;
import javabeans.InventoryItem;

import javax.swing.plaf.nimbus.State;
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

    @Override
    public ArrayList<InventoryItem> getAllInventoryItems() {
        String query = "SELECT * FROM " + Const.TABLE_INVENTORY;
        items = new ArrayList<>();

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new InventoryItem(data.getInt(Const.INVENTORY_ITEM_ID),
                        data.getString(Const.INVENTORY_ITEM_NAME),
                        data.getString(Const.MEASUREMENT_UNIT),
                        data.getDouble(Const.INVENTORY_ITEM_QUANTITY),
                        data.getDouble(Const.CRITICAL_QUANTITY),
                        data.getInt(Const.ITEM_CATEGORY_ID)));
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
                Const.ITEM_CATEGORY_ID + ") VALUES ('" +
                item.getItemName() + "', '" + item.getMeasurementUnit() + "', '" +
                item.getQuantity() + "', '" + item.getCriticalQuantity() + "', '" +
                item.getCategoryId() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("New item has been inserted to inventory successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void deleteInventoryItem(InventoryItem item) {

    }

    @Override
    public void updateInventoryItem(InventoryItem item) {

    }
}
