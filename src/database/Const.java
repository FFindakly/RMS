package database;

/**
 * @author Fadi Findakly
 */

public class Const {

    //Create constants to represent each column in each table
    //Categories table
    public static final String TABLE_INVENTORY_CATEGORIES = "inventory_categories";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "category_name";


    //Login table
    public static final String TABLE_LOGIN = "login";
    public static final String LOGIN_ID = "id";
    public static final String LOGIN_PASSWORD = "password";
    public static final String LOGIN_USERNAME = "user_name";
    public static final String LOGIN_PERMISSION = "permission";


    //Inventory table
    public static final String TABLE_INVENTORY = "inventory";
    public static final String INVENTORY_ITEM_ID = "id";
    public static final String INVENTORY_ITEM_NAME = "item_name";
    public static final String MEASUREMENT_UNIT = "measurement_unit";
    public static final String INVENTORY_ITEM_QUANTITY = "quantity";
    public static final String CRITICAL_QUANTITY = "critical_quantity";
    public static final String ITEM_CATEGORY_ID = "cat_id";

    //Addresses table
    public static final String TABLE_ACCOUNTS = "accounts";
    public static final String ACCOUNTS_ADDRESS = "address";
    public static final String ACCOUNTS_POSTALCODE = "postal_code";
    public static final String ACCOUNTS_PHONE = "phone";
    public static final String ACCOUNTS_EMAIL = "email";
    public static final String ACCOUNTS_USERID = "userid";
    public static final String ACCOUNTS_NAME = "restaurant_name";
    public static final String ACCOUNTS_TABLENUM = "number_of_table";

}
