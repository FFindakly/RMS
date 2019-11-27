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
    ArrayList<Order> breakfast;
    ArrayList<Order> dinner;
    ArrayList<Order> dessert;
    ArrayList<Order> beverage;
    ArrayList<Order> lunch;


    @Override
    public ArrayList<Order> breakfast() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER + " WHERE " + Const.ORDER_CATEGORY_ID + "= 2";
        breakfast = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                breakfast.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return breakfast;

    }

    @Override
    public ArrayList<Order> lunch() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER + " WHERE " + Const.ORDER_CATEGORY_ID + "= 1";
        lunch = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                lunch.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return lunch;
    }

    @Override
    public ArrayList<Order> dinner() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER + " WHERE " + Const.ORDER_CATEGORY_ID + "= 3";
        dinner = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                dinner.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return dinner;
    }

    @Override
    public ArrayList<Order> beverage() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER + " WHERE " + Const.ORDER_CATEGORY_ID + "= 4";
        beverage = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                beverage.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return beverage;
    }

    @Override
    public ArrayList<Order> dessert() {
        String query = "SELECT " + Const.ORDER_ITEM_MENU + " , " + Const.ORDER_PRICE +  ", " + Const.ORDER_ITEM_IMAGE + " FROM " + Const.TABLE_ORDER + " WHERE " + Const.ORDER_CATEGORY_ID + "= 5";
        dessert = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                dessert.add(new Order(
                        data.getString(Const.ORDER_ITEM_MENU),
                        data.getDouble(Const.ORDER_PRICE),
                        data.getString(Const.ORDER_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return dessert;
    }

    @Override
    public void PlaceOrder(Order order) {
    }
}
