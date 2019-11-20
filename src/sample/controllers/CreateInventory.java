package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javabeans.InventoryCategory;
import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML private JFXButton add_to_inventory_button;
    @FXML private Text message_Text;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        categories_ComboBox.setItems(FXCollections.observableArrayList(inventoryCategoriesTable.getAllCategories()));
    }

    //Add an event listener to the addNewCategory button
    public void addNewInventoryCategory() {
        InventoryCategory inventoryCategory = new InventoryCategory(category_TextField.getText());
        inventoryCategoriesTable.createCategory(inventoryCategory);
        System.out.println(category_TextField.getText());
    }

    //Add an event listener to the addToInventory button
    public void addToInventory() {
        InventoryItem item = new InventoryItem(item_name_TextField.getText(),
                measurement_unit_ComboBox.getSelectionModel().getSelectedItem(),
                Double.parseDouble(quantity_TextField.getText()),
                Double.parseDouble(critical_quantity_TextField.getText()),
                categories_ComboBox.getSelectionModel().getSelectedIndex() + 1);

        inventoyTable.createInventoryItem(item);
        System.out.println("item is added to inventory");
    }
}
