package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javabeans.InventoryCategory;
import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import tables.InventoryCategoryTable;
import tables.InventoyTable;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateInventory implements Initializable {

    /**
     * @author Fadi Findakly
     */
    //Import InventoryCategoryTable
    InventoryCategoryTable inventoryCategoriesTable = new InventoryCategoryTable();
    InventoyTable inventoyTable = new InventoyTable();

    //Link all FXML elements
    @FXML private JFXTextField category_TextField;
    @FXML private JFXButton add_category_button;
    @FXML private JFXComboBox<InventoryCategory> categories_ComboBox;
    @FXML private JFXTextField item_name_TextField;
    @FXML private JFXComboBox<String> measurement_unit_ComboBox;
    @FXML private JFXTextField quantity_TextField;
    @FXML private JFXTextField critical_quantity_TextField;
    @FXML private JFXButton addCtBt;
    @FXML private JFXButton addToInventoryBt;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Add content to the categories ComboBox from the database
        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));


        addCtBt.getStyleClass().add("buttons");
        addToInventoryBt.getStyleClass().add("buttons");
    }

    //Add an event listener to the addNewCategory button
    public void addNewInventoryCategory() {
        InventoryCategory inventoryCategory = new InventoryCategory(category_TextField.getText());
        inventoryCategoriesTable.createCategory(inventoryCategory);

        //Update the content of the ComboBox after creating the new category
        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Category has been added to inventory successfully!");
        alert.showAndWait();

        category_TextField.setText("");
    }

    //Add an event listener to the addToInventory button
    public void addToInventory() {
        boolean formIsValid = true;

        //Check all the inputs if they have data entered
        if (item_name_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            item_name_TextField.getStyleClass().add("empty");
        } else {
            item_name_TextField.getStyleClass().add("valid");
        }

        if (measurement_unit_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            measurement_unit_ComboBox.getStyleClass().add("empty");
        } else {
            measurement_unit_ComboBox.getStyleClass().add("valid");
        }

        if (quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            quantity_TextField.getStyleClass().add("empty");
        } else {
            quantity_TextField.getStyleClass().add("valid");
        }

        if (critical_quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            critical_quantity_TextField.getStyleClass().add("empty");
        } else {
            critical_quantity_TextField.getStyleClass().add("valid");
        }

        if (categories_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            categories_ComboBox.getStyleClass().add("empty");
        } else {
            categories_ComboBox.getStyleClass().add("valid");
        }

        //Control the process message style and content
        if (!formIsValid) {
            //message_Text.setText("Please, enter the missing data!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please enter missing data!");
            alert.showAndWait();
        }

        //If all data fields have data entered process creating a new inventory item
        if (formIsValid) {
            InventoryItem item = new InventoryItem(item_name_TextField.getText(),
                    measurement_unit_ComboBox.getSelectionModel().getSelectedItem(),
                    Double.parseDouble(quantity_TextField.getText()),
                    Double.parseDouble(critical_quantity_TextField.getText()),
                    categories_ComboBox.getSelectionModel().getSelectedIndex()+1,
                    Login.userID.get("ID"));

            inventoyTable.createInventoryItem(item);
            //message_Text.setText("Item has been added successfully!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Item has been added to inventory successfully!");
            alert.showAndWait();

            item_name_TextField.getStyleClass().add("valid");
            item_name_TextField.getStyleClass().add("valid");
            measurement_unit_ComboBox.getStyleClass().add("valid");
            measurement_unit_ComboBox.getSelectionModel().clearSelection();
            quantity_TextField.getStyleClass().add("valid");
            quantity_TextField.getStyleClass().add("valid");
            critical_quantity_TextField.getStyleClass().add("valid");
            critical_quantity_TextField.getStyleClass().add("valid");
            categories_ComboBox.getStyleClass().add("valid");
            categories_ComboBox.getSelectionModel().clearSelection();
            formIsValid = false;
        }
    }
}
