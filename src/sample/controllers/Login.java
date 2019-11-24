package sample.controllers;

import javafx.fxml.FXMLLoader;
import sample.Main;


import java.io.IOException;

public class Login {

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
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/update_inventory.fxml")));
    }

    /**
     * function to switch to track inventory screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToTrackInventory() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/track_inventory.fxml")));
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
     * function to switch to menu items screen
     * @autor Fadi Findakly
     * @return void
     */
    public void switchToMenuItems() throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/menu_items.fxml")));
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
