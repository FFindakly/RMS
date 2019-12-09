package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javabeans.InventoryItem;
import javabeans.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.DoubleStringConverter;
import tables.MenuItemsTable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Fadi Findakly
 */

public class UpdateMenu implements Initializable {

    //Link the fxml elements
    @FXML private TableView<MenuItem> updateMenuTableView;
    @FXML private TableColumn<MenuItem, String> menuItemNameCol;
    @FXML private TableColumn<MenuItem, String> menuItemCatCol;
    @FXML private TableColumn<MenuItem, Double> menuItemPriceCol;
    @FXML private TableColumn<MenuItem, String> menuItemDescCol;
    @FXML private JFXButton updateBt;
    @FXML private JFXButton deleteBt;

    //Create an instance of the MenuItemsTable
    MenuItemsTable menuItemsTable = new MenuItemsTable();
    //Create an observable list to store the menu items categories in
    ObservableList<String> menuItemsCategories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set the columns of the table view
        menuItemNameCol.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("itemName"));
        menuItemCatCol.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("itemCategory"));
        menuItemPriceCol.setCellValueFactory(new PropertyValueFactory<MenuItem, Double>("price"));
        menuItemDescCol.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("itemDisc"));


        //Load the data in the table view
        updateMenuTableView.setItems(menuItemsTable.loadUpdateMenuItemsTableView());

        //Set the TableView to editable
        updateMenuTableView.setEditable(true);

        //Assign the observable list and populate it with values
        menuItemsCategories = FXCollections.observableArrayList();
        menuItemsCategories.addAll("Breakfast", "Lunch", "Dinner", "Desserts", "Beverages");

        //Set the table view cells to TextField s or ComboBox
        menuItemNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        menuItemCatCol.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), menuItemsCategories));
        menuItemPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        menuItemDescCol.setCellFactory(TextFieldTableCell.forTableColumn());

        updateBt.getStyleClass().add("buttons");
        deleteBt.getStyleClass().add("delete_buttons");
    }


    /**
     * These functions are override the content of the table cells with new content
     * @param e
     */
    public void updateName(TableColumn.CellEditEvent <MenuItem, String> e) {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();
        item.setItemName(e.getNewValue());
    }

    public void updateCategory(TableColumn.CellEditEvent <MenuItem, String> e) {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();
        item.setItemCategory(e.getNewValue());
    }

    public void updatePrice(TableColumn.CellEditEvent <MenuItem, Double> e) {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();
        item.setPrice(e.getNewValue());
    }

    public void updateDescription(TableColumn.CellEditEvent <MenuItem, String> e) {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();
        item.setItemDisc(e.getNewValue());
    }


    /**
     * This function is to update an item from menu items table in database
     */
    public void updateItem() {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();
        menuItemsTable.updateMenuItem(item);

        //Update the TableView after the item gets deleted
        updateMenuTableView.setItems(menuItemsTable.loadUpdateMenuItemsTableView());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Item has been updated successfully!");
        alert.showAndWait();
    }


    /**
     * This function is to delete an item from menu items table in database
     */
    public void deleteItem() {
        MenuItem item = updateMenuTableView.getSelectionModel().getSelectedItem();

        if (item == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please select a row to be deleted!");
            alert.showAndWait();
        } else {
            menuItemsTable.deleteMenuItem(item);

            //Update the TableView after the item gets deleted
            updateMenuTableView.setItems(menuItemsTable.loadUpdateMenuItemsTableView());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Item has been deleted successfully!");
            alert.showAndWait();
        }
    }
}
