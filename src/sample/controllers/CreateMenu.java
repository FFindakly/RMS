package sample.controllers;

import com.jfoenix.controls.*;
import javabeans.InventoryItem;
import javabeans.IngredientItem;
import javabeans.MenuItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tables.IngredientTable;
import tables.InventoyTable;
import tables.MenuItemsTable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateMenu implements Initializable {

    @FXML private JFXTextField itemNameTextField;
    @FXML private JFXComboBox<String> itemCategoryComboBox;
    @FXML private JFXTextField itemPriceTextField;
    @FXML private JFXTextArea itemDiscTextArea;
    @FXML private JFXButton addItemButton;
    @FXML private JFXComboBox<MenuItem> menuItemsComboBox;
    @FXML private JFXComboBox<InventoryItem> ingredientComboBox;
    @FXML private JFXTextField quantityTextField;
    @FXML private JFXButton addIngredientButton;
    @FXML private JFXListView<String> ingredientsListView;
    @FXML private JFXButton saveItemButton;
    @FXML private JFXButton uploadImageButton;
    @FXML private ImageView itemImageView;
    @FXML private BorderPane createMenuPane;
    @FXML private Text errorMessage;
    @FXML private Text errorMessageIngredient;



    private FileChooser fileChooser;
    private File imageFile;
    private URL imageUrl;
    private Image uploadedImage;

    MenuItemsTable menuItemsTable = new MenuItemsTable();
    InventoyTable inventoryTable = new InventoyTable();
    IngredientTable ingredientsTable = new IngredientTable();
    ArrayList<String> listViewItems = new ArrayList<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Add all menu items to the menu items ComboBox
        menuItemsComboBox.setItems(FXCollections.observableArrayList(menuItemsTable.getAllMenuItems()));

        //Add all inventory items to the ingredients ComboBox
        ingredientComboBox.setItems(FXCollections.observableArrayList(inventoryTable.getAllInventoryItems()));

    }

    public void uploadImage() throws IOException {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Upload menu item image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.png", "*.jpeg"));

        Stage stage = (Stage) createMenuPane.getScene().getWindow();
        imageFile = fileChooser.showOpenDialog(stage);

        if (imageFile != null) {
            imageUrl = imageFile.toURI().toURL();
            uploadedImage = new Image(imageUrl.toExternalForm());
            itemImageView.setImage(uploadedImage);
        }
    }

    /**
     * A function to create new menu item and add it to the database
     */
    public void addItemToMenu() {
        boolean validation_add_menu = true;
        //(String itemName, String itemCategory, double price, String imagePath)
        //Create a new menu item by retrieving the data frm the form
        if (itemNameTextField.getText().trim().isEmpty()) {
            validation_add_menu = false;
            itemNameTextField.getStyleClass().add("empty_data_fields");
        } else {
            itemNameTextField.getStyleClass().clear();
        }

        if (itemCategoryComboBox.getSelectionModel().getSelectedItem() == null) {
            validation_add_menu = false;
            itemCategoryComboBox.getStyleClass().add("empty_data_fields");
        } else {
            itemCategoryComboBox.getStyleClass().clear();
        }

        if (itemDiscTextArea.getText().trim().isEmpty()) {
            validation_add_menu = false;
            itemDiscTextArea.getStyleClass().add("empty_data_fields");
        } else {
            itemDiscTextArea.getStyleClass().clear();
        }

        if (itemPriceTextField.getText().trim().isEmpty()) {
            validation_add_menu = false;
            itemPriceTextField.getStyleClass().add("empty_data_fields");
        } else {
            itemPriceTextField.getStyleClass().clear();
        }

        if (!validation_add_menu) {
            errorMessage.setText("Enter data in the missing fields");
            errorMessage.setFill(Paint.valueOf("red"));
            errorMessage.setVisible(true);
        }
        if(validation_add_menu){
            MenuItem item = new MenuItem(itemNameTextField.getText(),
                    itemCategoryComboBox.getSelectionModel().getSelectedItem(),
                    itemDiscTextArea.getText(),
                    Double.parseDouble(itemPriceTextField.getText()),
                    imageUrl.toExternalForm());
            //Insert the new created menu item to database table
            menuItemsTable.createMenuItem(item);

            //Update the content of the menu items ComboBox
            menuItemsComboBox.setItems(FXCollections.observableArrayList(menuItemsTable.getAllMenuItems()));
        }
    }

    /**
     * A function to create a new ingredient and add it to the database
     */
    public void addIngredient() {
        boolean validation_add_ingredients = true;

        if (menuItemsComboBox.getSelectionModel().getSelectedItem() == null) {
            validation_add_ingredients = false;
            menuItemsComboBox.getStyleClass().add("empty_data_fields");
        } else {
            menuItemsComboBox.getStyleClass().clear();
        }

        if (ingredientComboBox.getSelectionModel().getSelectedItem() == null) {
            validation_add_ingredients = false;
            ingredientComboBox.getStyleClass().add("empty_data_fields");
        } else {
            ingredientComboBox.getStyleClass().clear();
        }

        if (quantityTextField.getText().trim().isEmpty()) {
            validation_add_ingredients = false;
            quantityTextField.getStyleClass().add("empty_data_fields");
        } else {
            quantityTextField.getStyleClass().clear();
        }

        if (!validation_add_ingredients) {
            errorMessageIngredient.setText("Enter data in the missing fields");
            errorMessageIngredient.setFill(Paint.valueOf("red"));
            errorMessageIngredient.setVisible(true);
        }
        if(validation_add_ingredients){
            IngredientItem itemIngredient = new IngredientItem(menuItemsComboBox.getSelectionModel().getSelectedItem().getId(),
                    ingredientComboBox.getSelectionModel().getSelectedItem().getItemId(),
                    Double.parseDouble(quantityTextField.getText()));
            ingredientsTable.createItemIngredient(itemIngredient);

            //Add the ingredients names with their quantity to the list view
            listViewItems.add(ingredientComboBox.getSelectionModel().getSelectedItem().getItemName() +
                    "                         " + quantityTextField.getText() +
                    ingredientComboBox.getSelectionModel().getSelectedItem().getMeasurementUnit());
            ingredientsListView.setItems(FXCollections.observableArrayList(listViewItems));

            //Update the inventory item quantity as being used as an ingredient
            ingredientsTable.deductQuantityFromInventory(ingredientComboBox.getSelectionModel().getSelectedItem().getQuantity(),
                    itemIngredient, Double.parseDouble(quantityTextField.getText()));
        }

    }

}


//https://stackoverflow.com/questions/5613898/storing-images-in-sql-server