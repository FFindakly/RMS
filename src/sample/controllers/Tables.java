package sample.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Main;
import tables.AccountSettingsTable;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Tables implements Initializable {
    @FXML private FlowPane buttonPane;
    public static Map<String, Integer> tableId = new HashMap<String, Integer>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Get the count of the table from the accounts table
        AccountSettingsTable table = new AccountSettingsTable();
        int count = table.getCountOfTables(Login.userID.get("ID"));
        Button btnTable;
        Label lblTableName;


        // Create a for loop to create button for each table
        for(int i = 1; i <= count; i++) {
            buttonPane.setHgap(27);
            buttonPane.setVgap(20);
            buttonPane.setPadding(new Insets(20));
            lblTableName = new Label("Table " + i);
            lblTableName.setStyle("-fx-font-family:Arial; -fx-padding: 100px 0px 0px 0px; -fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: #202020; -fx-fill: #202020;  -fx-effect: dropshadow(three-pass-box , rgba(32,32,32,0.5) , 6, 0.0 , 0 , 2 );");
            btnTable = new Button();
            btnTable.setGraphic(lblTableName);
            btnTable.setMinWidth(150);
            btnTable.setMinHeight(150);
            buttonPane.getChildren().add(btnTable);
            FlowPane.setMargin(btnTable, new Insets(10,0,0,0));
            btnTable.setId(Integer.toString(i));
            int id = i;
            btnTable.setOnAction(event -> {
                tableId.put("table_id", id);
                try {
                    Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/place_order.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            btnTable.getStyleClass().add("tableButton");
        }

    }
}
