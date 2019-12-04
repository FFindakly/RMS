package javabeans;

/**
 * @author Ugur Demir
 */
public class User {
    private int id;
    private String username;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
    //Create getters and setters
    public int getId() {
        return id;
    }
    public String getUserName() {
        return username;
    }

    public String toString() {
        return this.id + "";
    }

}
