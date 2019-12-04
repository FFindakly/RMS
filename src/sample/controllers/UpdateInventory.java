package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javabeans.InventoryCategory;
import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.DoubleStringConverter;
import tables.InventoryCategoryTable;
import tables.InventoyTable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @author Fadi Findakly
 */

public class UpdateInventory implements Initializable {

    //Link the TableView and all columns from the fxml
    @FXML private TableView <InventoryItem> trackTableView;
    @FXML private TableColumn <InventoryItem, String> itemNameColumn;
    @FXML private TableColumn<InventoryItem, String> itemCategoryColumn;
//    @FXML private TableColumn<InventoryItem, Integer> itemCategoryColumn;
    @FXML private TableColumn <InventoryItem, String> measurementUnitColumn;
    @FXML private TableColumn <InventoryItem, Double> quantityColumn;
    @FXML private TableColumn <InventoryItem, Double> criticalColumn;
    @FXML private JFXButton updateBt;
    @FXML private JFXButton removeBt;


    //Create an InventoryTable instance
    InventoyTable inventoryTable = new InventoyTable();
    //Create an InventoryCategoryTable instance
    InventoryCategoryTable categoriesTable = new InventoryCategoryTable();

    //Create an ObservableList for the measurement ComboBox
    private ObservableList<String> measurementUnits;
    private ObservableList<String> categories;
    private ArrayList<InventoryCategory> inventoryCategories;
    private HashMap<Integer, String> categoriesHashMap;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set up the columns in the table
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("itemName"));
        measurementUnitColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("measurementUnit"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("quantity"));
        criticalColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("criticalQuantity"));
        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("categoryName"));
//        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("categoryId"));


        //Load the data in the table view
        trackTableView.setItems(inventoryTable.loadTrackInventoryTable());

        //Set the table view to editable
        trackTableView.setEditable(true);

        //Upload the measurementUnits  list with content
        measurementUnits = FXCollections.observableArrayList();
        measurementUnits.addAll("Pound", "Ounce", "Liter", "Count");

        //Upload the categories list with content from inventory_categories table/database
        categories = FXCollections.observableArrayList();
        inventoryCategories = categoriesTable.getAllCategories();
        for (InventoryCategory item : inventoryCategories) {
            categories.add(item.getName());
        }
        //Get the categories HashMap from database
        //categoriesHashMap = categoriesTable.getCategoriesHashMap();

        //Set the table cells to TextField or ComboBox
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        measurementUnitColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), measurementUnits));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        criticalColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        itemCategoryColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), categories));

        //Set the style class of buttons
        updateBt.getStyleClass().add("buttons");
        removeBt.getStyleClass().add("delete_buttons");
    }


    /**
     * These functions are override the content of the table cells with new content
     * @param e
     */
    public void updateName(TableColumn.CellEditEvent <InventoryItem, String> e) {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        item.setItemName(e.getNewValue());
    }
    public void updateUnit(TableColumn.CellEditEvent <InventoryItem, String> e) {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        item.setMeasurementUnit(e.getNewValue());
    }

    public void updateQuantity(TableColumn.CellEditEvent <InventoryItem, Double> e) {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        item.setQuantity(e.getNewValue());
    }

    public void updateCritical(TableColumn.CellEditEvent <InventoryItem, Double> e) {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        item.setCriticalQuantity(e.getNewValue());
    }

    public void updateCategory(TableColumn.CellEditEvent <InventoryItem, String> e) {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        item.setCategoryId(getHashMapKey(categoriesHashMap, e.getNewValue()));
    }


    /**
     * This function is to update an item in the inventory table in database
     */
    public void updateItem() {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        inventoryTable.updateInventoryItem(item);
    }

    /**
     * This function is to delete an item from inventory table in database
     */
    public void deleteItem() {
        InventoryItem item = trackTableView.getSelectionModel().getSelectedItem();
        inventoryTable.deleteInventoryItem(item);

        //Update the TableView after the item gets deleted
        trackTableView.setItems(inventoryTable.loadTrackInventoryTable());
    }

    /**
     * This function is to get the key of a HashMap at a given value
     * @param dictionary
     * @param value
     * @return
     */
    public int getHashMapKey(HashMap<Integer,String> dictionary, String value) {
        for (int key : dictionary.keySet()) {
            if (dictionary.get(key).equals(value)) {
                return key;
            }
        }
        return 0;
    }
}
