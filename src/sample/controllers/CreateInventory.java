package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javabeans.InventoryCategory;
import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML private JFXButton nextBtn;
    @FXML private Text message_Text;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Add content to the categories ComboBox from the database
        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));
    }

    //Add an event listener to the addNewCategory button
    public void addNewInventoryCategory() {
        InventoryCategory inventoryCategory = new InventoryCategory(category_TextField.getText());
        inventoryCategoriesTable.createCategory(inventoryCategory);

        //Update the content of the ComboBox after creating the new category
        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));
    }

    //Add an event listener to the addToInventory button
    public void addToInventory() {
        boolean formIsValid = true;

        //Check all the inputs if they have data entered
        if (item_name_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            item_name_TextField.getStyleClass().add("empty_data_fields");
        } else {
            item_name_TextField.getStyleClass().clear();
        }

        if (measurement_unit_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            measurement_unit_ComboBox.getStyleClass().add("empty_data_fields");
        } else {
            measurement_unit_ComboBox.getStyleClass().clear();
        }

        if (quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            quantity_TextField.getStyleClass().add("empty_data_fields");
        } else {
            quantity_TextField.getStyleClass().clear();
        }

        if (critical_quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            critical_quantity_TextField.getStyleClass().add("empty_data_fields");
        } else {
            critical_quantity_TextField.getStyleClass().clear();
        }

        if (categories_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            categories_ComboBox.getStyleClass().add("empty_data_fields");
        } else {
            categories_ComboBox.getStyleClass().clear();
        }

        //Control the process message style and content
        if (!formIsValid) {
            message_Text.setText("Please, enter the missing data!");
            message_Text.setFill(Paint.valueOf("red"));
            message_Text.setVisible(true);
        }

        //If all data fields have data entered process creating a new inventory item
        if (formIsValid) {
            InventoryItem item = new InventoryItem(item_name_TextField.getText(),
                    measurement_unit_ComboBox.getSelectionModel().getSelectedItem(),
                    Double.parseDouble(quantity_TextField.getText()),
                    Double.parseDouble(critical_quantity_TextField.getText()),
                    categories_ComboBox.getSelectionModel().getSelectedIndex() + 1);

            inventoyTable.createInventoryItem(item);
            message_Text.setText("Item has been added successfully!");
            message_Text.setFill(Paint.valueOf("green"));
            message_Text.setVisible(true);

            item_name_TextField.getStyleClass().clear();
            item_name_TextField.clear();
            measurement_unit_ComboBox.getStyleClass().clear();
            measurement_unit_ComboBox.getSelectionModel().clearSelection();
            quantity_TextField.getStyleClass().clear();
            quantity_TextField.clear();
            critical_quantity_TextField.getStyleClass().clear();
            critical_quantity_TextField.clear();
            categories_ComboBox.getStyleClass().clear();
            categories_ComboBox.getSelectionModel().clearSelection();
            formIsValid = false;
        }
    }
}
