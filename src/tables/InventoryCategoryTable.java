package tables;

import daos.InventoryCategoriesDAO;
import database.Const;
import database.Database;
import javabeans.InventoryCategory;
import sample.controllers.Login;
import sun.rmi.runtime.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Fadi Findakly
 */

public class InventoryCategoryTable implements InventoryCategoriesDAO {

    Database db = Database.getInstance();
    ArrayList<InventoryCategory> categories;
    HashMap<Integer,String> categoriesHashMap;

    @Override
        public ArrayList<InventoryCategory> getAllCategories() {
            String query = "SELECT * FROM " + Const.TABLE_INVENTORY_CATEGORIES;
            categories = new ArrayList<>();

        try {
            Statement getCategories = db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);
            while(data.next()) {
                categories.add(
                        new InventoryCategory(
                                data.getInt(Const.CATEGORY_ID),
                                data.getString(Const.CATEGORY_NAME)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    @Override
    public void createCategory(InventoryCategory category) {
        String query = "INSERT INTO " + Const.TABLE_INVENTORY_CATEGORIES +
                        "(" + Const.INVENTORY_USER_ID + ","  + Const.CATEGORY_NAME + ") VALUES ('" + Login.userID.get("ID") + "' , '" +
                        category.getName() + "')";
        System.out.println(query);
        try {
            Statement addCategory = db.getConnection().createStatement();
            addCategory.execute(query);
            System.out.println("A new category is inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory() {

    }

    @Override
    public void updateCategory() {

    }

    @Override
    public String getCategory() {

        return null;
    }

    //This method is to return a HashMap that contains each category with its id
    public HashMap<Integer, String> getCategoriesHashMap() {
        String query = "SELECT * FROM " + Const.TABLE_INVENTORY_CATEGORIES + " WHERE " + Const.INVENTORY_USER_ID + " = " + Login.userID.get("ID");
        categoriesHashMap = new HashMap<>();
        try {
            Statement getCategories = db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);
            while(data.next()) {
                categoriesHashMap.put(data.getInt(Const.CATEGORY_ID),
                        data.getString(Const.CATEGORY_NAME));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriesHashMap;
    }

}
