package tables;

import daos.IngredientsTableDAO;
import database.Const;
import database.Database;
import javabeans.IngredientItem;
import javabeans.InventoryItem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */

public class IngredientTable implements IngredientsTableDAO {

    Database db = Database.getInstance();
    ArrayList<IngredientItem> ingredients;


    @Override
    public ArrayList<IngredientItem> getAllItemIngredients() {
        return null;
    }

    @Override
    public IngredientItem getIngredientItem(IngredientItem item) {
        return null;
    }

    @Override
    public void createItemIngredient(IngredientItem item) {
        //(int ingredientId, int menuItemId, int inventoryItemId, double ingredientQuantity)
        String query = "INSERT INTO " + Const.TABLE_INGREDIENTS +
                "(" + Const.INGREDIENT_MENU_ITEM_ID + ", " +
                Const.INGREDIENT_INVENTORY_ITEM_ID + ", " +
                Const.INGREDIENT_QUANTITY + ") VALUES ('" +
                item.getMenuItemId() + "', '" + item.getInventoryItemId() + "', '" +
                item.getIngredientQuantity() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("New ingredient has been added to database successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteIngredientItem(IngredientItem item) {

    }

    @Override
    public void deductQuantityFromInventory(Double quantityInInventory, IngredientItem item, Double usage) {
        //UPDATE table_name
        //SET column1 = value1, column2 = value2, ...
        //WHERE condition;

        String query = "UPDATE " + Const.TABLE_INVENTORY +
                " SET " + Const.INVENTORY_ITEM_QUANTITY + " = " + quantityInInventory + " - " +
                usage + " WHERE " + Const.INVENTORY_ITEM_ID + " = " + item.getInventoryItemId();

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Ingredient quantity has been deducted from inventory successfully!");
        } catch (SQLException e) {

        }
    }
}
