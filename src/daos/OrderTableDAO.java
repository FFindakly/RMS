package daos;


import javabeans.MenuItem;
import javabeans.Order;

import java.util.ArrayList;

public interface OrderTableDAO {
     ArrayList<Order> breakfast();
     ArrayList<Order> lunch();
     ArrayList<Order> dinner();
     ArrayList<Order> beverage();
     ArrayList<Order> dessert();

     void PlaceOrder(Order order);
}
