package javabeans;

/**
 * @author Fadi Findakly
 */
public class InventoryCategory {

    private int id;
    private String name;

    //Created 2 constructors
    public InventoryCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public InventoryCategory(String name) {
        this.name = name;
    }

    //Create getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //create toString method
    public String toString() {
        return getName();
    }
}
