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


    //Inventory table
    public static final String TABLE_INVENTORY = "inventory";
    public static final String INVENTORY_ITEM_ID = "id";
    public static final String INVENTORY_ITEM_NAME = "item_name";
    public static final String MEASUREMENT_UNIT = "measurement_unit";
    public static final String INVENTORY_ITEM_QUANTITY = "quantity";
    public static final String CRITICAL_QUANTITY = "critical_quantity";
    public static final String ITEM_CATEGORY_ID = "cat_id";


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


    //Order Table
    public static final String TABLE_ORDER  = "menu";
    public static final String ORDER_ID = "id";
    public static final String ORDER_ITEM_MENU = "item_name";
    public static final String ORDER_CATEGORY_ID = "category_id";
    public static final String ORDER_INGREDIENTS = "ingredients";
    public static final String ORDER_PRICE = "price";
    public static final String ORDER_ITEM_IMAGE = "item_image";
}
