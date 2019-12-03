package javabeans;

/**
 * @author Fadi Findakly
 */

public class MenuItem {

    private int id;
    private String itemName;
    private String itemCategory;
    private String itemDisc;
    private double price;
    private String imagePath;


    //Create 2 constructors
    public MenuItem(int id, String itemName, String itemCategory, String itemDisc, double price, String imagePath) {
        this.id = id;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDisc = itemDisc;
        this.price = price;
        this.imagePath = imagePath;
    }

    public MenuItem(String itemName, String itemCategory, String itemDisc, double price, String imagePath) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDisc = itemDisc;
        this.price = price;
        this.imagePath = imagePath;
    }


    //Create setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getItemDisc() {
        return itemDisc;
    }

    public void setItemDisc(String itemDisc) {
        this.itemDisc = itemDisc;
    }


    //Create toString method
    public String toString() {
        return getItemName();
    }
}
