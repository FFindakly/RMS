package tables;

import daos.TableOrderDAO;
import database.Const;
import database.Database;
import javabeans.Orders;
import javabeans.Receipt;
import sample.controllers.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableOrder implements TableOrderDAO {
    Database db = Database.getInstance();
    @Override
    public void InsertOrder(Orders order) {
        String query = "INSERT INTO " + Const.TABLE_ORDER +
                "(" + Const.TABLE_USER_ID + ", " +
                Const.TABLE_ORDER_ITEM_ID + ", " +
                Const.TABLE_ORDER_TABLE_ID + ", " +
                Const.TABLE_ORDER_QUANTITY + ", " +
                Const.TABLE_ORDER_DATE + ", " +
                Const.TABLE_ORDER_STATUS + ") VALUES ('" +
                Login.userID.get("ID") + "', '" + order.getItemId() + "', '" + order.getTableId() + "', '" + order.getQuantity() + "', '" + order.getDate() + "',  '" +
                order.isStatus() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Address has been inserted to the table successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean findItem(Orders order){
        String query = "SELECT * FROM " + Const.TABLE_ORDER + " WHERE " + Const.TABLE_ORDER_TABLE_ID + " = " + order.getTableId() + " AND " + Const.TABLE_ORDER_STATUS + " = " + 1 + " AND " + Const.TABLE_USER_ID + " = " + order.getUserId() + " AND " + Const.TABLE_ORDER_ITEM_ID + " = " + order.getItemId();
        System.out.println(query);
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                    return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //UPDATE table SET quantity = quantity + 5 WHERE Item_id = <x>

    public boolean updateQuantity(Orders order) {
        String query = "UPDATE " + Const.TABLE_ORDER + " SET " + Const.TABLE_ORDER_QUANTITY + " = " + (Const.TABLE_ORDER_QUANTITY + " + " +  order.getQuantity()) + " WHERE " + Const.TABLE_USER_ID + " = " + order.getUserId() + " AND " + Const.TABLE_ORDER_TABLE_ID + " = " + order.getTableId() + " AND " + Const.TABLE_ORDER_STATUS + " = " + 1 + " AND " + Const.TABLE_ORDER_ITEM_ID + " = " + order.getItemId();
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
