package javabeans;

public class PlaceOrder {
    private int id;
    private String itemName;
    private String  CategoryId;

    private String  itemDesc;
    private double price;
    private String image;

    public PlaceOrder(int id, String itemName, double price, String image) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.image = image;
    }

    public PlaceOrder(int id, String itemName, String categoryId, String itemDesc, double price, String image) {
        this.id = id;
        this.itemName = itemName;
        CategoryId = categoryId;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
