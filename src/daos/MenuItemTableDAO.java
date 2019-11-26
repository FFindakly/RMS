package daos;


import javabeans.MenuItem;

import java.util.ArrayList;

/**
 * @author Fadi Findakly
 */
public interface MenuItemTableDAO {

    public ArrayList<MenuItem> getAllMenuItems();
    public MenuItem getMenuItem(MenuItem item);
    public void createMenuItem(MenuItem item);
    public void deleteMenuItem(MenuItem item);
    public void updateMenuItem(MenuItem item);
}
