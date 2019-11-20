package javabeans;

/**
 * @author Fadi Findakly
 */
public class InventoryItem {

    private int itemId;
    private String itemName;
    private String measurementUnit;
    private double quantity;
    private double criticalQuantity;
    private int categoryId;


    //Create 2 constructors
    public InventoryItem(int itemId, String itemName, String measurementUnit,
                         double quantity, double criticalQuantity, int categoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
        this.criticalQuantity = criticalQuantity;
        this.categoryId = categoryId;
    }

    public InventoryItem(String itemName, String measurementUnit,
                         double quantity, double criticalQuantity, int categoryId) {
        this.itemName = itemName;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
        this.criticalQuantity = criticalQuantity;
        this.categoryId = categoryId;
    }

    //Create getters and setters

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCriticalQuantity() {
        return criticalQuantity;
    }

    public void setCriticalQuantity(double criticalQuantity) {
        this.criticalQuantity = criticalQuantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    //Create toString method
    public String toString() {
        return getItemName();
    }
}
