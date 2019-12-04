package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import database.Const;
import javabeans.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.Main;
import sun.rmi.runtime.Log;
import tables.ReceiptTable;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowReceipt implements Initializable {
    @FXML
    JFXButton payButton;
    @FXML
    ScrollPane itemsPane;
    @FXML Label tableNumber, total, dateText, taxText, subTotalText;
    @FXML
    VBox vContent;
    ReceiptTable receiptTable = new ReceiptTable();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Receipt> receipt = receiptTable.getItems(Tables.tableId.get("table_id"));
        tableNumber.setText(Integer.toString(receipt.get(0).getTableId()));
        dateText.setText(receipt.get(0).getDate());
        double subTotalFinal = 0;
        for(int i = 0; i < receipt.size() ; i++){
            HBox itemHbox = new HBox();
            itemHbox.setStyle("-fx-background-color: #ffffff;");
            itemHbox.setMinHeight(40);
            itemHbox.setMinWidth(800);
            itemHbox.setPadding(new Insets(10));
            Label item_name = new Label(receipt.get(i).getItemName());
            item_name.setMinWidth(295);
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price = new Label("$"+Double.toString(receipt.get(i).getItemPrice()));
            item_price.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            item_price.setMinWidth(235);
            item_price.setTextAlignment(TextAlignment.CENTER);
            Label item_quantity = new Label(Integer.toString(receipt.get(i).getQuantity()));
            item_quantity.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            item_quantity.setTextAlignment(TextAlignment.CENTER);
            item_quantity.setMinWidth(230);
            double subtotal = receipt.get(i).getItemPrice() * receipt.get(i).getQuantity();
            subTotalFinal = subTotalFinal + subtotal;
            Label subTotalText = new Label();
            subTotalText.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            subTotalText.setText("$"+ subtotal);
            itemHbox.getChildren().addAll(item_name, item_quantity, item_price, subTotalText);
            vContent.getChildren().addAll(itemHbox);
            vContent.setSpacing(10.0);
        }
        subTotalText.setText("$"+subTotalFinal);
        double afterTax = (subTotalFinal * 13) / 100;
        taxText.setText("$" + afterTax);
        total.setText("$" + (afterTax + subTotalFinal));
        itemsPane.setContent(vContent);
        itemsPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        itemsPane.setFitToWidth(true);

        payButton.setOnAction(e->{
           boolean res = receiptTable.updateTableOrder(Integer.parseInt(tableNumber.getText()), Login.userID.get("ID"));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Thank you for the payment!");
            alert.showAndWait();
            try {
                Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/tables.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
