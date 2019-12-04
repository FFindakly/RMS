package daos;

import javabeans.InventoryCategory;
import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */
public interface InventoryCategoriesDAO {

    public ArrayList<InventoryCategory> getAllCategories();
    public void createCategory(InventoryCategory category);
    public void deleteCategory();
    public void updateCategory();
    public String getCategory();

}
