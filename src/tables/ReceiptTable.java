package tables;

import daos.ReceiptDAO;
import database.Const;
import database.Database;
import javabeans.Receipt;
import sample.controllers.Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReceiptTable implements ReceiptDAO {
    Database db = Database.getInstance();
    ArrayList<Receipt> items;

    @Override
    public ArrayList<Receipt> getItems(int tableId) {
        String query = "SELECT " + "login." + Const.LOGIN_ID + ", " +
                Const.TABLE_ORDER_TABLE_ID + ", " +
                Const.TABLE_ORDER_QUANTITY + ", " +
                Const.TABLE_ORDER_DATE + ", " +
                Const.TABLE_ORDER_STATUS + ", " +
                Const.MENU_ITEM_NAME + ", " +
                Const.TABLE_ORDER_DATE + ", " +
                Const.MENU_ITEM_PRICE + ", " + "menu_items." +
                Const.MENU_ITEM_ID +  " FROM "
                + Const.TABLE_LOGIN + " INNER JOIN "
                + Const.TABLE_ORDER + " INNER JOIN "
                + Const.TABLE_MENU_ITEMS + " ON "
                + Const.TABLE_ORDER_TABLE_ID + " = "
                + Tables.tableId.get("table_id") + " AND "
                + Const.TABLE_ORDER_STATUS + " = " + 1 + " AND "
                + Const.TABLE_ORDER_ITEM_ID + " = " + "menu_items." + Const.MENU_ITEM_ID;
        items = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new Receipt(data.getString(Const.MENU_ITEM_NAME), data.getInt(Const.TABLE_ORDER_QUANTITY), data.getDouble(Const.MENU_ITEM_PRICE), data.getInt(Const.TABLE_ORDER_TABLE_ID), data
                .getString(Const.TABLE_ORDER_DATE)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean updateTableOrder(int tableId, int userId){
        String query = "UPDATE " + Const.TABLE_ORDER + " SET " + Const.TABLE_ORDER_STATUS + " = " + 0 + " WHERE " + Const.TABLE_ORDER_TABLE_ID + " = " + tableId + " AND " + Const.TABLE_USER_ID + " = " + userId;
                ;
        System.out.println(query);
        try{
            Statement getVerify = db.getConnection().createStatement();
            int data = getVerify.executeUpdate(query);
            if(data > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
