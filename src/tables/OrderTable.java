package tables;

import daos.OrderTableDAO;
import database.Const;
import database.Database;
import javabeans.MenuItem;
import javabeans.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderTable implements OrderTableDAO {
    Database db = Database.getInstance();
    ArrayList<Order> items;


    @Override
    public ArrayList<Order> allOrders() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER;
        items = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
