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

        if (item_name_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            item_name_TextField.getStyleClass().add("empty_data_fields");
        }
        if (measurement_unit_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            measurement_unit_ComboBox.getStyleClass().add("empty_data_fields");
        }
        if (quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            quantity_TextField.getStyleClass().add("empty_data_fields");
        }
        if (critical_quantity_TextField.getText().trim().isEmpty()) {
            formIsValid = false;
            critical_quantity_TextField.getStyleClass().add("empty_data_fields");
        }
        if (categories_ComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            categories_ComboBox.getStyleClass().add("empty_data_fields");
                    //setStyle("-fx-background-color: rgba(255,0,0,0.3)");
        }

        if (!formIsValid) {
            message_Text.setText("Please, enter the missing data!");
            message_Text.setFill(Paint.valueOf("red"));
            message_Text.setVisible(true);
        }

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
            item_name_TextField.getStyleClass().add("valid_data_fields");
            item_name_TextField.clear();
            measurement_unit_ComboBox.getStyleClass().add("valid_data_fields");
            measurement_unit_ComboBox.getSelectionModel().clearSelection();
            quantity_TextField.getStyleClass().add("valid_data_fields");
            quantity_TextField.clear();
            critical_quantity_TextField.getStyleClass().add("valid_data_fields");
            critical_quantity_TextField.clear();
            categories_ComboBox.getStyleClass().add("valid_data_fields");
            categories_ComboBox.getSelectionModel().clearSelection();
        }
    }
}
