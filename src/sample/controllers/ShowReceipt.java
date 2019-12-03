package sample.controllers;

import com.jfoenix.controls.JFXScrollPane;
import database.Const;
import javabeans.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tables.ReceiptTable;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowReceipt implements Initializable {
    @FXML
    ScrollPane itemsPane;
    @FXML
    VBox vContent;
    ReceiptTable receiptTable = new ReceiptTable();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Receipt> receipt = receiptTable.getItems(Tables.tableId.get("table_id"));

        for(int i = 0; i < receipt.size() ; i++){
            HBox itemHbox = new HBox();
            itemHbox.setStyle("-fx-background-color: #cccccc;");
            itemHbox.
            itemHbox.setMinHeight(50);
            itemHbox.setMinWidth(840);

            Label item_name = new Label(receipt.get(i).getItemName());
            Label item_price = new Label(Double.toString(receipt.get(i).getItemPrice()));
            Label item_quantity = new Label(Integer.toString(receipt.get(i).getQuantity()));
            double subtotal = receipt.get(i).getItemPrice() * receipt.get(i).getQuantity();
            Label subTotalText = new Label();
            subTotalText.setText(Double.toString(subtotal));
            itemHbox.getChildren().addAll(item_name, item_quantity, item_price, subTotalText);
            vContent.getChildren().addAll(itemHbox);
        }
        itemsPane.setContent(vContent);
    }
}
