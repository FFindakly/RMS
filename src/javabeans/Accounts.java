package javabeans;

public class Accounts {
    private int userid;
    private String address;
    private String restaurantName;
    private int numOfTable;
    private String postalCode;
    private String province;
    private String phone;
    private String email;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getNumOfTable() {
        return numOfTable;
    }

    public void setNumOfTable(int numOfTable) {
        this.numOfTable = numOfTable;
    }

    public Accounts(int userid, String address, String restaurantName, int numOfTable, String province, String postalCode, String phone, String email) {
        this.userid = userid;
        this.address = address;
        this.restaurantName = restaurantName;
        this.numOfTable = numOfTable;
        this.province = province;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
