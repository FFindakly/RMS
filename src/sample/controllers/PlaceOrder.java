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
    private ListView breakfast;
    @FXML
    private ListView lunch;
    @FXML
    private ListView dinner;
    @FXML
    private ListView beverage;
    @FXML
    private ListView dessert;
    private OrderTable menuItemsTable = new OrderTable();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        breakfast.setItems(FXCollections.observableArrayList(menuItemsTable.breakfast()));
        lunch.setItems(FXCollections.observableArrayList(menuItemsTable.lunch()));
        dinner.setItems(FXCollections.observableArrayList(menuItemsTable.dinner()));
        beverage.setItems(FXCollections.observableArrayList(menuItemsTable.beverage()));
        dessert.setItems(FXCollections.observableArrayList(menuItemsTable.dessert()));
    }



}
