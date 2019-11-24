package javabeans;

/**
 * @author Fadi Findakly
 */

public class IngredientItem {

    private int ingredientId;
    private int menuItemId;
    private int inventoryItemId;
    private double ingredientQuantity;

    //Create 2 constructors
    public IngredientItem(int ingredientId, int menuItemId, int inventoryItemId, double ingredientQuantity) {
        this.ingredientId = ingredientId;
        this.menuItemId = menuItemId;
        this.inventoryItemId = inventoryItemId;
        this.ingredientQuantity = ingredientQuantity;
    }

    public IngredientItem(int menuItemId, int inventoryItemId, double ingredientQuantity) {
        this.menuItemId = menuItemId;
        this.inventoryItemId = inventoryItemId;
        this.ingredientQuantity = ingredientQuantity;
    }

    //Create getters and setters

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public double getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(double ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

}
