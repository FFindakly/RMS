package javabeans;

import tables.InventoryCategoryTable;

/**
 * @author Fadi Findakly
 */
public class InventoryItem {

    private int itemId;
    private int userId;
    private String itemName;
    private String measurementUnit;
    private double quantity;
    private double criticalQuantity;
    private int categoryId;
    private String categoryName;


    //Create 2 constructors
    public InventoryItem(String itemName, String measurementUnit,
                         double quantity, double criticalQuantity, int categoryId, int userId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
        this.criticalQuantity = criticalQuantity;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public InventoryItem(int itemId, String itemName, String measurementUnit,
                         double quantity, double criticalQuantity, int categoryId) {
        InventoryCategoryTable inventoryCategoriesTable = new InventoryCategoryTable();
        this.itemId = itemId;
        this.itemName = itemName;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
        this.criticalQuantity = criticalQuantity;
        this.categoryId = categoryId;
        this.categoryName = inventoryCategoriesTable.getCategoriesHashMap().get(categoryId);
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

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    //Create toString method
    public String toString() {
        return getItemName();
    }
}
