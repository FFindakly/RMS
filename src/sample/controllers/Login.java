package sample.controllers;

import javabeans.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Main;
import tables.LoginTable;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import java.util.Map;

public class Login implements Initializable {

    @FXML private CheckBox rememberMe;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private MenuBar menu;
    @FXML private Label warning;

    public static Map<String, Integer> userID = new HashMap<String, Integer>();

    Preferences preferences;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        warning.setVisible(false);
        menu.setVisible(false);
        preferences = Preferences.userNodeForPackage(Login.class);
        if(preferences != null){
            if(preferences.get("username", null) != null && !preferences.get("username", null).isEmpty()){
                username.setText(preferences.get("username", null));
                password.setText(preferences.get("password", null));
                rememberMe.setSelected(true);
            }
        }
    }

    public void logon() throws IOException{
        LoginTable login = new LoginTable();
        User result = login.getUser(username.getText(), password.getText());
        if(result != null){
            if(rememberMe.isSelected()){
                preferences.put("username", username.getText());
                preferences.put("password", password.getText());
            }else{
                preferences.put("username", "");
                preferences.put("password", "");
            }
            userID.put("ID", result.getId());
            menu.setVisible(true);
            Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/account_settings.fxml")));
        }
        else{
            warning.setVisible(true);
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
}
