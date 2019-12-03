package daos;
import javabeans.PlaceOrder;

import java.util.ArrayList;

public interface PlaceOrderDAO {
    ArrayList<PlaceOrder> breakfast();
    ArrayList<PlaceOrder> lunch();
    ArrayList<PlaceOrder> dinner();
    ArrayList<PlaceOrder> beverage();
    ArrayList<PlaceOrder> dessert();

    void PlaceOrder(PlaceOrder order);
}
