package javabeans;

public class Ingredient {

    private String itemName;
    private String quantity;
    private String unit;

    public Ingredient(String itemName, String quantity, String unit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
