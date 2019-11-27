package sample.controllers;

import com.jfoenix.controls.JFXTextField;
import javabeans.Order;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tables.MenuItemsTable;
import tables.OrderTable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaceOrder implements Initializable {

    @FXML
    private ListView orderMenu;
    private OrderTable menuItemsTable = new OrderTable();
    ArrayList<String> listViewMenuItems = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderMenu.setItems(FXCollections.observableArrayList(menuItemsTable.allOrders()));
    }



}
