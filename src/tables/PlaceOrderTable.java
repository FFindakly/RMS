package tables;

import daos.PlaceOrderDAO;
import database.Const;
import database.Database;
import javabeans.PlaceOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PlaceOrderTable implements PlaceOrderDAO {
    Database db = Database.getInstance();
    ArrayList<PlaceOrder> breakfast;
    ArrayList<PlaceOrder> dinner;
    ArrayList<PlaceOrder> dessert;
    ArrayList<PlaceOrder> beverage;
    ArrayList<PlaceOrder> lunch;

    @Override
    public ArrayList<PlaceOrder> breakfast() {
        String cat = "Breakfast";
        String query = "SELECT " + Const.MENU_ITEM_ID + " , " + Const.MENU_ITEM_NAME + " , " + Const.MENU_ITEM_PRICE +  ", " + Const.MENU_ITEM_IMAGE + " FROM " + Const.TABLE_MENU_ITEMS + " WHERE " + Const.MENU_ITEM_CATEGORY + " = '"+ cat +"'";
        breakfast = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                breakfast.add(new PlaceOrder(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return breakfast;

    }

    @Override
    public ArrayList<PlaceOrder> lunch() {
        String cat = "Lunch";
        String query = "SELECT " + Const.MENU_ITEM_ID + " , " + Const.MENU_ITEM_NAME + " , " + Const.MENU_ITEM_PRICE +  ", " + Const.MENU_ITEM_IMAGE + " FROM " + Const.TABLE_MENU_ITEMS + " WHERE " + Const.MENU_ITEM_CATEGORY + " = '"+ cat +"'";
        lunch = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                lunch.add(new PlaceOrder(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return lunch;
    }

    @Override
    public ArrayList<PlaceOrder> dinner() {
        String cat = "Dinner";
        String query = "SELECT " + Const.MENU_ITEM_ID + " , " + Const.MENU_ITEM_NAME + " , " + Const.MENU_ITEM_PRICE +  ", " + Const.MENU_ITEM_IMAGE + " FROM " + Const.TABLE_MENU_ITEMS + " WHERE " + Const.MENU_ITEM_CATEGORY + " = '"+ cat +"'";
        dinner = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                dinner.add(new PlaceOrder(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return dinner;
    }

    @Override
    public ArrayList<PlaceOrder> beverage() {
        String cat = "Beverages";
        String query = "SELECT " + Const.MENU_ITEM_ID + " , " + Const.MENU_ITEM_NAME + " , " + Const.MENU_ITEM_PRICE +  ", " + Const.MENU_ITEM_IMAGE + " FROM " + Const.TABLE_MENU_ITEMS + " WHERE " + Const.MENU_ITEM_CATEGORY + " = '"+ cat +"'";
        beverage = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                beverage.add(new PlaceOrder(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return beverage;
    }

    @Override
    public ArrayList<PlaceOrder> dessert() {
        String cat = "Desserts";
        String query = "SELECT " + Const.MENU_ITEM_ID + " , " + Const.MENU_ITEM_NAME + " , " + Const.MENU_ITEM_PRICE +  ", " + Const.MENU_ITEM_IMAGE + " FROM " + Const.TABLE_MENU_ITEMS + " WHERE " + Const.MENU_ITEM_CATEGORY + " = '"+ cat +"'";
        dessert = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                dessert.add(new PlaceOrder(
                        data.getInt(Const.MENU_ITEM_ID),
                        data.getString(Const.MENU_ITEM_NAME),
                        data.getDouble(Const.MENU_ITEM_PRICE),
                        data.getString(Const.MENU_ITEM_IMAGE)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return dessert;
    }

    @Override
    public void PlaceOrder(PlaceOrder order) {

    }
}
