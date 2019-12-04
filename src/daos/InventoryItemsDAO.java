package daos;

import javabeans.InventoryCategory;
import javabeans.InventoryItem;
import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */

public interface InventoryItemsDAO {

    public ArrayList<InventoryItem> getAllInventoryItems();
    public InventoryItem getInventoryItem(InventoryItem item);
    public void createInventoryItem(InventoryItem item);
    public void deleteInventoryItem(InventoryItem item);
    public void updateInventoryItem(InventoryItem item);
}
