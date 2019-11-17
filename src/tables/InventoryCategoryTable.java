package tables;

import daos.InventoryCategoriesDAO;
import database.Database;

import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */

public class InventoryCategoryTable implements InventoryCategoriesDAO {

    Database db = Database.getInstance();
    ArrayList<String> categories;

    @Override
    public ArrayList<String> getAllCategories() {
        return null;
    }

    @Override
    public void createCategory() {

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
}
