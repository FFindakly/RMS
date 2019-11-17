package daos;

import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */
public interface InventoryCategoriesDAO {

    public ArrayList<String> getAllCategories();
    public void createCategory();
    public void deleteCategory();
    public void updateCategory();
    public String getCategory();

}
