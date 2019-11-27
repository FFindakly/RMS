package daos;


import javabeans.MenuItem;
import javabeans.Order;

import java.util.ArrayList;

public interface OrderTableDAO {
     ArrayList<Order> allOrders();
}
