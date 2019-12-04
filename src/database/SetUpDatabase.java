package database;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import sample.Main;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class SetUpDatabase {

    /**
     * @author Fadi Findakly
     * This class will use the Singleton design pattern
     * to access the database from different classes
     */

    //Create an instance variable
            @FXML
    MenuBar menu;
    static private SetUpDatabase instance = null;
    private Connection connection = null;
    @FXML
    Button connecting;
    @FXML
    JFXTextField host;
    @FXML JFXTextField dbName;
    @FXML JFXTextField dbUsername;
    @FXML
    JFXPasswordField dbPassword;
    @FXML
    Text errorMessage;
    public static Map<String, String> database = new HashMap<String, String>();
    //Create a private constructor for the class
    public void makeConnection() {
        try {
            boolean validation = true;
                if(host.getText().trim().isEmpty()){
                    validation = false;
                    host.getStyleClass().add("empty_data_fields");
                } else {
                    host.getStyleClass().clear();
                }
            if(dbName.getText().trim().isEmpty()){
                validation = false;
                dbName.getStyleClass().add("empty_data_fields");
            } else {
                dbName.getStyleClass().clear();
            }
            if(dbUsername.getText().trim().isEmpty()){
                validation = false;
                dbUsername.getStyleClass().add("empty_data_fields");
            } else {
                dbUsername.getStyleClass().clear();
            }
            if(dbPassword.getText().trim().isEmpty()){
                validation = false;
                dbPassword.getStyleClass().add("empty_data_fields");
            } else {
                dbPassword.getStyleClass().clear();
            }
            if (!validation){
                errorMessage.setText("Enter data in the missing fields");
                errorMessage.setFill(Paint.valueOf("red"));
                errorMessage.setVisible(true);
            }

                if(validation){
                    database.put("DB_HOST", host.getText());
                    database.put("DB_NAME", dbName.getText());
                    database.put("DB_USERNAME", dbUsername.getText());
                    database.put("DB_PASSWORD", dbPassword.getText());

                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://" +database.get("DB_HOST")+"/" + database.get("DB_NAME"), database.get("DB_USERNAME"), database.get("DB_PASSWORD"));

                    createTable(Const.TABLE_INVENTORY_CATEGORIES,
                            Const.CREATE_TABLE_INVENTORY_CATEGORIES,
                            connection);
                    createTable(Const.TABLE_LOGIN,
                            Const.CREATE_TABLE_LOGIN,
                            connection);
                    createTable(Const.TABLE_INVENTORY,
                            Const.CREATE_TABLE_INVENTORY,
                            connection);
                    createTable(Const.TABLE_ORDER,
                            Const.CREATE_TABLE_ORDER,
                            connection);
                    createTable(Const.TABLE_ACCOUNTS,
                            Const.CREATE_TABLE_ACCOUNTS,
                            connection);
                    createTable(Const.TABLE_MENU_ITEMS,
                            Const.CREATE_TABLE_MENU_ITEMS,
                            connection);
                    createTable(Const.TABLE_INGREDIENTS,
                            Const.CREATE_TABLE_INGREDIENTS,
                            connection);
                    Main.openLogin(FXMLLoader.load(getClass().getResource("../sample/FXMLs/splash.fxml")));
                }


        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    //Create getInstance method
    public static SetUpDatabase getInstance() {
        if (instance == null) {
            return new SetUpDatabase();
        }

        return instance;
    }

    //Create getConnection method
    public Connection getConnection() {
        return connection;
    }


    private void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {

        Statement sqlStatement;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet result = md.getTables(null, null, tableName, null);
        if(result.next()) {
            System.out.println(tableName + " table already exists");
        }
        else {
            sqlStatement = connection.createStatement();
            sqlStatement.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    /**
     * function to exit from application
     * @autor Fadi Findakly
     * @return void
     */
    public void close() {
        System.exit(1);
    }

    /**
     * function to switch to account settings screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToLogin() throws IOException {
        //Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
        Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
    }
    /**
     * function to switch to account settings screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToAcctSettings() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/account_settings.fxml")));
    }

    /**
     * function to switch to account settings screen
     * @autor Ugur Demir
     * @return void
     */
    public void forgot() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/forgot.fxml")));
    }

    /**
     * function to switch to shop settings screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToShopSettings() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/restaurant_settings.fxml")));
    }

    /**
     * function to switch to create inventory screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToCreateInventory() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/create_inventory.fxml")));
    }

    /**
     * function to switch to update inventory screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToUpdateInventory() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/track_inventory.fxml")));
    }

    /**
     * function to switch to track inventory screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToTrackInventory() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/update_inventory.fxml")));
    }

    /**
     * function to switch to create menu screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToCreateMenu() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/create_menu.fxml")));
    }

    /**
     * function to switch to update menu screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToUpdateMenu() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/update_menu.fxml")));
    }

    /**
     * function to switch to tables screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToTables() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/tables.fxml")));
    }

    /**
     * function to switch to place orders screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToPlaceOrders() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/place_order.fxml")));
    }

    /**
     * function to switch to orders details screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToOrdersDetails() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/order_details.fxml")));
    }


    public void switchToOrdersStats() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/sales.fxml")));
    }

}

