package daos;

import javabeans.IngredientItem;
import javabeans.InventoryItem;

import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */
public interface IngredientsTableDAO {

    public ArrayList<IngredientItem> getAllItemIngredients();
    public IngredientItem getIngredientItem(IngredientItem item);
    public void createItemIngredient(IngredientItem item);
    public void deleteIngredientItem(IngredientItem item);
    public void deductQuantityFromInventory(Double quantityInInventory, IngredientItem item, Double usage);

}
