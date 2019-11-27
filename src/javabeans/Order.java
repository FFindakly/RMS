package javabeans;

public class Order {
    private int id;
    private String itemName;
    private int  CategoyId;
    private String ingredients;
    private double price;
    private String image;


    public String toString() {
        return  itemName  +"    " + price + "     " + image;
    }

    public Order(String itemName, double price, String image) {
        this.itemName = itemName;
        this.price = price;
        this.image = image;
    }

    public Order(int id, String itemName, int categoyId, String ingredients, double price, String image) {
        this.id = id;
        this.itemName = itemName;
        CategoyId = categoyId;
        this.ingredients = ingredients;
        this.price = price;
        this.image = image;
    }

    public int getCategoyId() {
        return CategoyId;
    }

    public void setCategoyId(int categoyId) {
        CategoyId = categoyId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
