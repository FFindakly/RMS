package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javabeans.Orders;
import javabeans.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sample.Main;
import tables.PlaceOrderTable;
import tables.ReceiptTable;
import tables.TableOrder;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PlaceOrder implements Initializable {
    @FXML
    private JFXButton minus;
    @FXML
    private JFXButton plus;
    @FXML private JFXButton addOrder, details;
    @FXML
    Pane ordersParent, ordersParentLunch, ordersParentDinner, ordersParentBeverage, ordersParentDessert;
    @FXML
    VBox leftItem, leftItemLunch, leftItemDinner, leftItemBeverage, leftItemDessert;
    @FXML
    VBox rightItem, rightItemLunch, rightItemDinner, rightItemBeverage, rightItemDessert;;
    Text count;
    @FXML Label resultText;
    @FXML Pane screenContent;

    public static Map<Integer, Integer> cart = new HashMap<Integer, Integer>();
    private PlaceOrderTable orderList = new PlaceOrderTable();
    TableOrder tableOrder = new TableOrder();
    ReceiptTable receiptTable = new ReceiptTable();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addOrder.getStyleClass().add("buttons");
        details.getStyleClass().add("buttons");
        ArrayList<Receipt> receipt = receiptTable.getItems(Tables.tableId.get("table_id"));
        if(receipt.size() > 0){
            details.setVisible(true);
        }
        else{
            details.setVisible(false);
        }
        //Populate the pane dynamically
        System.out.println("Table number: " + Tables.tableId.get("table_id"));
        ArrayList<javabeans.PlaceOrder> breakfast =  orderList.breakfast();
        ArrayList<javabeans.PlaceOrder> lunch =  orderList.lunch();
        ArrayList<javabeans.PlaceOrder> dinner =  orderList.dinner();
        ArrayList<javabeans.PlaceOrder> beverages =  orderList.beverage();
        ArrayList<javabeans.PlaceOrder> dessert =  orderList.dessert();

        // Breakfast
        for (int i = 0; i < breakfast.size(); i++) {
            HBox item = new HBox();
            item.setId(Integer.toString(breakfast.get(i).getId()));
            item.setMinHeight(80);
            item.setStyle("-fx-background-color: #ffffff");
            item.setPadding(new Insets(10));
            ImageView img = new ImageView();
            img.setFitWidth(100);
            img.setFitHeight(60);
            img.setImage(new Image(breakfast.get(i).getImage()));

            Label item_name = new Label(breakfast.get(i).getItemName());
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price=new Label("$" + breakfast.get(i).getPrice());
            item_price.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 12px;");
            JFXButton plus_btn = new JFXButton("+");
            plus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;  -fx-background-color: #FF0000;");
            Text quantity = new Text("0");
            JFXButton minus_btn=new JFXButton("-");
            item_name.setMinWidth(150);
            minus_btn.setMinWidth(25);
            plus_btn.setMinWidth(25);
            quantity.setWrappingWidth(16);
            item_price.setMinWidth(20);
            quantity.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(item, new Insets(0, 0, 10, 0));

            minus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-color: #FF0000;");
            HBox.setMargin(minus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(plus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(item_price, new Insets(24, 10, 0, 5));
            HBox.setMargin(quantity, new Insets(23, 5, 0, 5));
            HBox.setMargin(item_name, new Insets(24, 5, 0, 10));


            item.getChildren().addAll(img,item_name,item_price,minus_btn,quantity,plus_btn);
            if(i%2==0){
                leftItem.getChildren().add(item);
            }else{
                rightItem.getChildren().add(item);
            }

        }
        for(Node parent: ordersParent.getChildren()) {
            VBox left_or_right = (VBox) parent;
            for (Node child : left_or_right.getChildren()) {
                HBox temp = (HBox) child;
                for (Node childOfChild : temp.getChildren()) {
                    if (childOfChild instanceof JFXButton) {
                        JFXButton quantityButton = (JFXButton) childOfChild;
                        quantityButton.setOnAction(e -> {
                            HBox myParent = (HBox) quantityButton.getParent();
                            for (Node textNode : myParent.getChildren()) {
                                if (textNode instanceof Text) {
                                    count = (Text) textNode;
                                }

                            }
                            if (quantityButton.getText().equals("+")) {
                                count.setText((Integer.parseInt(count.getText()) + 1) + "");
                                if(cart.containsKey(Integer.parseInt(myParent.getId()))){
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                                else{
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }

                            } else {
                                count.setText((Integer.parseInt(count.getText()) - 1) + "");
                            }
                        });
                    }
                }
            }
        }

        // Lunch
        for (int i = 0; i < lunch.size(); i++) {
            HBox item = new HBox();
            item.setId(Integer.toString(lunch.get(i).getId()));
            item.setMinHeight(80);
            item.setStyle("-fx-background-color: #ffffff");
            item.setPadding(new Insets(10));
            ImageView img = new ImageView();
            img.setFitWidth(100);
            img.setFitHeight(60);
            img.setImage(new Image(lunch.get(i).getImage()));

            Label item_name = new Label(lunch.get(i).getItemName());
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price=new Label("$" + lunch.get(i).getPrice());
            item_price.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 12px;");
            JFXButton plus_btn = new JFXButton("+");
            plus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;  -fx-background-color: #FF0000;");
            Text quantity = new Text("0");
            JFXButton minus_btn=new JFXButton("-");
            item_name.setMinWidth(150);
            minus_btn.setMinWidth(25);
            plus_btn.setMinWidth(25);
            quantity.setWrappingWidth(16);
            item_price.setMinWidth(20);
            quantity.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(item, new Insets(0, 0, 10, 0));

            minus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-color: #FF0000;");
            HBox.setMargin(minus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(plus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(item_price, new Insets(24, 10, 0, 5));
            HBox.setMargin(quantity, new Insets(23, 5, 0, 5));
            HBox.setMargin(item_name, new Insets(24, 5, 0, 10));


            item.getChildren().addAll(img,item_name,item_price,minus_btn,quantity,plus_btn);
            if(i%2==0){
                leftItemLunch.getChildren().add(item);
            }else{
                rightItemLunch.getChildren().add(item);
            }

        }
        for(Node parent: ordersParentLunch.getChildren()) {
            VBox left_or_right = (VBox) parent;
            for (Node child : left_or_right.getChildren()) {
                HBox temp = (HBox) child;
                for (Node childOfChild : temp.getChildren()) {
                    if (childOfChild instanceof JFXButton) {
                        JFXButton quantityButton = (JFXButton) childOfChild;
                        quantityButton.setOnAction(e -> {
                            HBox myParent = (HBox) quantityButton.getParent();
                            for (Node textNode : myParent.getChildren()) {
                                if (textNode instanceof Text) {
                                    count = (Text) textNode;
                                }

                            }
                            if (quantityButton.getText().equals("+")) {
                                count.setText((Integer.parseInt(count.getText()) + 1) + "");
                                if(cart.containsKey(Integer.parseInt(myParent.getId()))){
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                                else{
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                            } else {
                                count.setText((Integer.parseInt(count.getText()) - 1) + "");
                            }
                        });
                    }
                }
            }
        }

        // Dinner
        for (int i = 0; i < dinner.size(); i++) {
            HBox item = new HBox();
            item.setId(Integer.toString(dinner.get(i).getId()));
            item.setMinHeight(80);
            item.setStyle("-fx-background-color: #ffffff");
            item.setPadding(new Insets(10));
            ImageView img = new ImageView();
            img.setFitWidth(100);
            img.setFitHeight(60);
            img.setImage(new Image(dinner.get(i).getImage()));

            Label item_name = new Label(dinner.get(i).getItemName());
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price=new Label("$" + dinner.get(i).getPrice());
            item_price.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 12px;");
            JFXButton plus_btn = new JFXButton("+");
            plus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;  -fx-background-color: #FF0000;");
            Text quantity = new Text("0");
            JFXButton minus_btn=new JFXButton("-");
            item_name.setMinWidth(150);
            minus_btn.setMinWidth(25);
            plus_btn.setMinWidth(25);
            quantity.setWrappingWidth(16);
            item_price.setMinWidth(20);
            quantity.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(item, new Insets(0, 0, 10, 0));

            minus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-color: #FF0000;");
            HBox.setMargin(minus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(plus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(item_price, new Insets(24, 10, 0, 5));
            HBox.setMargin(quantity, new Insets(23, 5, 0, 5));
            HBox.setMargin(item_name, new Insets(24, 5, 0, 10));


            item.getChildren().addAll(img,item_name,item_price,minus_btn,quantity,plus_btn);
            if(i%2==0){
                leftItemDinner.getChildren().add(item);
            }else{
                rightItemDinner.getChildren().add(item);
            }

        }
        for(Node parent: ordersParentDinner.getChildren()) {
            VBox left_or_right = (VBox) parent;
            for (Node child : left_or_right.getChildren()) {
                HBox temp = (HBox) child;
                for (Node childOfChild : temp.getChildren()) {
                    if (childOfChild instanceof JFXButton) {
                        JFXButton quantityButton = (JFXButton) childOfChild;
                        quantityButton.setOnAction(e -> {
                            HBox myParent = (HBox) quantityButton.getParent();
                            for (Node textNode : myParent.getChildren()) {
                                if (textNode instanceof Text) {
                                    count = (Text) textNode;
                                }

                            }
                            if (quantityButton.getText().equals("+")) {
                                count.setText((Integer.parseInt(count.getText()) + 1) + "");
                                if(cart.containsKey(Integer.parseInt(myParent.getId()))){
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                                else{
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                            } else {
                                count.setText((Integer.parseInt(count.getText()) - 1) + "");
                            }
                        });
                    }
                }
            }
        }

        // Beverages
        for (int i = 0; i < beverages.size(); i++) {
            HBox item = new HBox();
            item.setId(Integer.toString(beverages.get(i).getId()));
            item.setMinHeight(80);
            item.setStyle("-fx-background-color: #ffffff");
            item.setPadding(new Insets(10));
            ImageView img = new ImageView();
            img.setFitWidth(100);
            img.setFitHeight(60);
            img.setImage(new Image(beverages.get(i).getImage()));

            Label item_name = new Label(beverages.get(i).getItemName());
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price=new Label("$" + beverages.get(i).getPrice());
            item_price.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 12px;");
            JFXButton plus_btn = new JFXButton("+");
            plus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;  -fx-background-color: #FF0000;");
            Text quantity = new Text("0");
            JFXButton minus_btn=new JFXButton("-");
            item_name.setMinWidth(150);
            minus_btn.setMinWidth(25);
            plus_btn.setMinWidth(25);
            quantity.setWrappingWidth(16);
            item_price.setMinWidth(20);
            quantity.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(item, new Insets(0, 0, 10, 0));

            minus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-color: #FF0000;");
            HBox.setMargin(minus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(plus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(item_price, new Insets(24, 10, 0, 5));
            HBox.setMargin(quantity, new Insets(23, 5, 0, 5));
            HBox.setMargin(item_name, new Insets(24, 5, 0, 10));


            item.getChildren().addAll(img,item_name,item_price,minus_btn,quantity,plus_btn);
            if(i%2==0){
                leftItemBeverage.getChildren().add(item);
            }else{
                rightItemBeverage.getChildren().add(item);
            }

        }
        for(Node parent: ordersParentBeverage.getChildren()) {
            VBox left_or_right = (VBox) parent;
            for (Node child : left_or_right.getChildren()) {
                HBox temp = (HBox) child;
                for (Node childOfChild : temp.getChildren()) {
                    if (childOfChild instanceof JFXButton) {
                        JFXButton quantityButton = (JFXButton) childOfChild;
                        quantityButton.setOnAction(e -> {
                            HBox myParent = (HBox) quantityButton.getParent();
                            for (Node textNode : myParent.getChildren()) {
                                if (textNode instanceof Text) {
                                    count = (Text) textNode;
                                }

                            }
                            if (quantityButton.getText().equals("+")) {
                                count.setText((Integer.parseInt(count.getText()) + 1) + "");
                                if(cart.containsKey(Integer.parseInt(myParent.getId()))){
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                                else{
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                            } else {
                                count.setText((Integer.parseInt(count.getText()) - 1) + "");
                            }
                        });
                    }
                }
            }
        }

        // Dessert
        for (int i = 0; i < dessert.size(); i++) {
            HBox item = new HBox();
            item.setId(Integer.toString(dessert.get(i).getId()));
            item.setMinHeight(80);
            item.setStyle("-fx-background-color: #ffffff");
            item.setPadding(new Insets(10));
            ImageView img = new ImageView();
            img.setFitWidth(100);
            img.setFitHeight(60);
            img.setImage(new Image(dessert.get(i).getImage()));

            Label item_name = new Label(dessert.get(i).getItemName());
            item_name.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
            Label item_price=new Label("$" + dessert.get(i).getPrice());
            item_price.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 12px;");
            JFXButton plus_btn = new JFXButton("+");
            plus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;  -fx-background-color: #FF0000;");
            Text quantity = new Text("0");
            JFXButton minus_btn=new JFXButton("-");
            item_name.setMinWidth(150);
            minus_btn.setMinWidth(25);
            plus_btn.setMinWidth(25);
            quantity.setWrappingWidth(16);
            item_price.setMinWidth(20);
            quantity.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(item, new Insets(0, 0, 10, 0));

            minus_btn.setStyle("-fx-font-family: 'Arial'; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-color: #FF0000;");
            HBox.setMargin(minus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(plus_btn, new Insets(20, 5, 0, 5));
            HBox.setMargin(item_price, new Insets(24, 10, 0, 5));
            HBox.setMargin(quantity, new Insets(23, 5, 0, 5));
            HBox.setMargin(item_name, new Insets(24, 5, 0, 10));


            item.getChildren().addAll(img,item_name,item_price,minus_btn,quantity,plus_btn);
            if(i%2==0){
                leftItemDessert.getChildren().add(item);
            }else{
                rightItemDessert.getChildren().add(item);
            }

        }
        for(Node parent: ordersParentDessert.getChildren()) {
            VBox left_or_right = (VBox) parent;
            for (Node child : left_or_right.getChildren()) {
                HBox temp = (HBox) child;
                for (Node childOfChild : temp.getChildren()) {
                    if (childOfChild instanceof JFXButton) {
                        JFXButton quantityButton = (JFXButton) childOfChild;
                        quantityButton.setOnAction(e -> {
                            HBox myParent = (HBox) quantityButton.getParent();
                            for (Node textNode : myParent.getChildren()) {
                                if (textNode instanceof Text) {
                                    count = (Text) textNode;
                                }

                            }
                            if (quantityButton.getText().equals("+")) {
                                count.setText((Integer.parseInt(count.getText()) + 1) + "");
                                if(cart.containsKey(Integer.parseInt(myParent.getId()))){
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                                else{
                                    cart.put(Integer.parseInt(myParent.getId()), Integer.parseInt(count.getText()));
                                }
                            } else {
                                count.setText((Integer.parseInt(count.getText()) - 1) + "");
                            }
                        });
                    }
                }
            }
        }

        addOrder.setOnAction(event -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            for (Map.Entry el : cart.entrySet()) {
                Orders order = new Orders(Tables.tableId.get("table_id"), Login.userID.get("ID"), (Integer)el.getKey(), (Integer)el.getValue(), dtf.format(now), 1);
                Boolean res = tableOrder.findItem(order);
                if(!res) {
                    tableOrder.InsertOrder(order);
                }else{
                    tableOrder.updateQuantity(order);
                }
            }

            cart.clear();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("We added the order successfully!");
            alert.showAndWait();
            try {
                Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/receipt.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultText.setVisible(true);
        });

        details.setOnAction(e->{
            try {
                Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/receipt.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

}
