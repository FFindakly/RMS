package daos;

import javabeans.Receipt;

import java.util.ArrayList;

public interface ReceiptDAO {

    public ArrayList<Receipt> getItems(int tableId);

}
