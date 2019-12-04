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
    public static final String CATEGORY_USER_ID = "user_id";


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
    public static final String INVENTORY_USER_ID = "user_id";

    //Addresses table
    public static final String TABLE_ACCOUNTS = "accounts";
    public static final String ACCOUNTS_ADDRESS = "address";
    public static final String ACCOUNTS_ID = "id";
    public static final String ACCOUNTS_POSTALCODE = "postal_code";
    public static final String ACCOUNTS_PHONE = "phone";
    public static final String ACCOUNTS_PROVINCE = "province";
    public static final String ACCOUNTS_EMAIL = "email";
    public static final String ACCOUNTS_USERID = "user_id";
    public static final String ACCOUNTS_NAME = "restaurant_name";
    public static final String ACCOUNTS_TABLENUM = "number_of_tables";
    public static final String ACCOUNTS_USER_ID = "user_id";

    //Menu_items table
    public static final String TABLE_MENU_ITEMS = "menu_items";
    public static final String MENU_ITEM_ID = "id";
    public static final String MENU_ITEM_NAME = "item_name";
    public static final String MENU_ITEM_CATEGORY = "item_category";
    public static final String MENU_ITEM_DISC = "item_disc";
    public static final String MENU_ITEM_PRICE = "item_price";
    public static final String MENU_ITEM_IMAGE = "item_image";
    public static final String MENU_ITEM_USER_ID = "user_id";


    //Ingredients table
    public static final String TABLE_INGREDIENTS = "ingredients";
    public static final String INGREDIENT_ID = "id";
    public static final String INGREDIENT_MENU_ITEM_ID = "menu_item_id";
    public static final String INGREDIENT_INVENTORY_ITEM_ID = "inventory_item_id";
    public static final String INGREDIENT_QUANTITY = "quantity";
    public static final String INGREDIENT_USER_ID = "user_id";


    //Orders Table
    public static final String TABLE_ORDER = "table_order";
    public static final String TABLE_ORDER_ID = "id";
    public static final String TABLE_USER_ID = "user_id";
    public static final String TABLE_ORDER_TABLE_ID = "table_id";
    public static final String TABLE_ORDER_ITEM_ID = "item_id";
    public static final String TABLE_ORDER_QUANTITY = "quantity";
    public static final String TABLE_ORDER_DATE = "date";
    public static final String TABLE_ORDER_STATUS = "status";






    /**
     * tables that will be created according to the info ^
     */

    public static final String CREATE_TABLE_INVENTORY_CATEGORIES =
            "CREATE TABLE " + TABLE_INVENTORY_CATEGORIES + "(" +
                    CATEGORY_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    CATEGORY_NAME + " varchar(50) NOT NULL, " +
                    CATEGORY_USER_ID + " int(11) NOT NULL " +
                    ")"
                    + " ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;";

    // i did not have access to this table so Ugure if you are reading this update it as you see fit since this is your table - Yonis
    public static final String CREATE_TABLE_LOGIN =
            "CREATE TABLE " + TABLE_LOGIN + "(" +
                    LOGIN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    LOGIN_PASSWORD + " VARCHAR(80), " +
                    LOGIN_USERNAME  + " VARCHAR(30) "+ ")" +
                    " ENGINE=InnoDB DEFAULT CHARSET=latin1;";

    public static final String CREATE_TABLE_INVENTORY =
            "CREATE TABLE " + TABLE_INVENTORY + "( " +
                    INVENTORY_ITEM_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    INVENTORY_ITEM_NAME + " varchar(80) NOT NULL, " +
                    MEASUREMENT_UNIT  + " varchar(20) NOT NULL, "+
                    INVENTORY_ITEM_QUANTITY  + " decimal(10,0) NOT NULL, "+
                    CRITICAL_QUANTITY  + " decimal(10,0) NOT NULL, "+
                    ITEM_CATEGORY_ID  + " int(11) NOT NULL, "+
                    INVENTORY_USER_ID + " int(11) NOT NULL " +")" +
                    " ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;";

    // i did not have access to this table so Ugure if you are reading this update it as you see fit since this is your table - Yonis
    public static final String CREATE_TABLE_ACCOUNTS =
            "CREATE TABLE " + TABLE_ACCOUNTS + "(" +
                    ACCOUNTS_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    ACCOUNTS_ADDRESS + " varchar(80) NOT NULL, " +
                    ACCOUNTS_POSTALCODE + " char(6) NOT NULL, " +
                    ACCOUNTS_PROVINCE + " char(6) NOT NULL, " +
                    ACCOUNTS_PHONE  + " char (10) NOT NULL, "+
                    ACCOUNTS_EMAIL  + " varchar(50) NOT NULL, "+
                    ACCOUNTS_USERID  + " int(11) NOT NULL, "+
                    ACCOUNTS_NAME  + " varchar(30) NOT NULL, "+
                    ACCOUNTS_TABLENUM  + " int(15) NOT NULL "+
                    ");";


    public static final String CREATE_TABLE_MENU_ITEMS =
            "CREATE TABLE " + TABLE_MENU_ITEMS + "(" +
                    MENU_ITEM_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    MENU_ITEM_NAME + " varchar(80) NOT NULL, " +
                    MENU_ITEM_CATEGORY  + " varchar(25) NOT NULL, "+
                    MENU_ITEM_DISC  + " varchar(400) NOT NULL, "+
                    MENU_ITEM_PRICE  + " decimal(10,0) NOT NULL, "+
                    MENU_ITEM_IMAGE  + " varchar(150) NOT NULL, "+
                    MENU_ITEM_USER_ID + " int(11) NOT NULL " + ")"
                    +  "ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;";

    public static final String CREATE_TABLE_INGREDIENTS =
            "CREATE TABLE " + TABLE_INGREDIENTS + "(" +
                    INGREDIENT_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    INGREDIENT_MENU_ITEM_ID + " varchar(80) NOT NULL, " +
                    INGREDIENT_INVENTORY_ITEM_ID  + " decimal(10) NOT NULL, "+
                    INVENTORY_USER_ID + " int(11) NOT NULL, " +
                    INGREDIENT_QUANTITY  + " decimal(10,0) NOT NULL "+ ")"
                    + " ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;";


    public static final String CREATE_TABLE_ORDER =
            "CREATE TABLE " + TABLE_ORDER + "(" +
                    TABLE_ORDER_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    TABLE_USER_ID + " int(11) NOT NULL, " +
                    TABLE_ORDER_ITEM_ID  + " int(11) NOT NULL, "+
                    TABLE_ORDER_TABLE_ID  + " int(11) NOT NULL, "+
                    TABLE_ORDER_QUANTITY + " int(11) NOT NULL, " +
                    TABLE_ORDER_DATE + " date NOT NULL, " +
                    TABLE_ORDER_STATUS  + " tinyint(1) NOT NULL "+ ")"
                    + " ENGINE=InnoDB DEFAULT CHARSET=utf8;";

}
