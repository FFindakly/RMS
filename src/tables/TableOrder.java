package tables;

import daos.TableOrderDAO;
import database.Const;
import database.Database;
import javabeans.Orders;
import sample.controllers.Login;

import java.sql.SQLException;

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
}
