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
    public static final String ACCOUNTS_PROVINCE = "province";
    public static final String ACCOUNTS_EMAIL = "email";
    public static final String ACCOUNTS_USERID = "user_id";
    public static final String ACCOUNTS_NAME = "restaurant_name";
    public static final String ACCOUNTS_TABLENUM = "number_of_tables";

    //Menu_items table
    public static final String TABLE_MENU_ITEMS = "menu_items";
    public static final String MENU_ITEM_ID = "id";
    public static final String MENU_ITEM_NAME = "item_name";
    public static final String MENU_ITEM_CATEGORY = "item_category";
    public static final String MENU_ITEM_DISC = "item_disc";
    public static final String MENU_ITEM_PRICE = "item_price";
    public static final String MENU_ITEM_IMAGE = "item_image";


    //Ingredients table
    public static final String TABLE_INGREDIENTS = "ingredients";
    public static final String INGREDIENT_ID = "id";
    public static final String INGREDIENT_MENU_ITEM_ID = "menu_item_id";
    public static final String INGREDIENT_INVENTORY_ITEM_ID = "inventory_item_id";
    public static final String INGREDIENT_QUANTITY = "quantity";


    //Orders Table
    public static final String TABLE_ORDER = "table_order";
    public static final String TABLE_ORDER_ID = "id";
    public static final String TABLE_USER_ID = "user_id";
    public static final String TABLE_ORDER_TABLE_ID = "table_id";
    public static final String TABLE_ORDER_ITEM_ID = "item_id";
    public static final String TABLE_ORDER_QUANTITY = "quantity";
    public static final String TABLE_ORDER_DATE = "date";
    public static final String TABLE_ORDER_STATUS = "status";

}
