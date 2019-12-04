package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javabeans.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Main;
import tables.AccountSettingsTable;
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
    @FXML private Label warning, forgot;
    @FXML private Button logBtn;

    // Create and hash map store the userID
    public static Map<String, Integer> userID = new HashMap<String, Integer>();

    Preferences preferences;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logBtn.getStyleClass().add("buttons");
        menu.setVisible(false);

        // Create a preferences to store username and password permanently
        preferences = Preferences.userNodeForPackage(Login.class);

        // If preferences is not null set the data for username and password field
        if(preferences != null){
            if(preferences.get("username", null) != null && !preferences.get("username", null).isEmpty()){
                username.setText(preferences.get("username", null));
                password.setText(preferences.get("password", null));
                rememberMe.setSelected(true);
            }
        }

        // When forget the password, user can click here to get verify screen
        forgot.setOnMouseClicked(e->{
            try {
                Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/forgot.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    public void logon() throws IOException{
        LoginTable login = new LoginTable();
        User result = login.getUser(username.getText(), password.getText());

        // If result is not null, it means user entered the correct information. Store the data to remember for the next time.
        if(result != null){
            if(rememberMe.isSelected()){
                preferences.put("username", username.getText());
                preferences.put("password", password.getText());
            }else{
                preferences.put("username", "");
                preferences.put("password", "");
            }

            // Add the user id into the hash map
            userID.put("ID", result.getId());

            //Set menu visible true, so user can see the menu after login
            menu.setVisible(true);

            AccountSettingsTable accountSettingsTable = new AccountSettingsTable();
            int count = accountSettingsTable.getCountOfTables(Login.userID.get("ID"));

            // If the user already added his account settings, pass this screen to get the inventory screen.
            if(count > 0){
                try {
                    Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/create_inventory.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/account_settings.fxml")));
            }
        }
        else{
            // Show the warning to the user
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("The username or password you have entered is wrong!");
            alert.showAndWait();
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
        menu.setVisible(false);
        Main.openLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
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
    public void switchToCredits() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/credits.fxml")));
    }
}
