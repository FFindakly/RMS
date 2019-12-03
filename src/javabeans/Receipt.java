package javabeans;


public class Receipt {

    private String itemName;
    private int quantity;
    private double itemPrice;
    private int tableId;

    public Receipt(String itemName, int quantity, double itemPrice, int tableId) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.tableId = tableId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
