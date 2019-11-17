package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javabeans.InventoryCategory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tables.InventoryCategoryTable;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateInventory implements Initializable {

    /**
     * @author Fadi Findakly
     */
    //Import InventoryCategoryTable
    InventoryCategoryTable inventoryCategoriesTable = new InventoryCategoryTable();

    //Link all FXML elements
    @FXML
    private JFXTextField category_TextField;
    @FXML
    private JFXButton add_category_button;
    @FXML
    private JFXComboBox<InventoryCategory> categories_ComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));
    }

    //Add an event listener to the addNewCategory button
    public void addNewInventoryCategory() {
        InventoryCategory inventoryCategory = new InventoryCategory(category_TextField.getText());
        inventoryCategoriesTable.createCategory(inventoryCategory);
    }
}
