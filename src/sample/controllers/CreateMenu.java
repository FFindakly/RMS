package sample.controllers;

import com.jfoenix.controls.*;
import javabeans.Ingredient;
import javabeans.InventoryItem;
import javabeans.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML private JFXComboBox<MenuItem> menuItemsComboBox;
    @FXML private JFXComboBox<InventoryItem> ingredientComboBox;
    @FXML private JFXTextField quantityTextField;
    @FXML private JFXListView<String> ingredientsListView;
    @FXML private ImageView itemImageView;
    @FXML private Text add_new_item;
    @FXML private Text add_ingredient;
    @FXML private JFXButton uploadImageBt;
    @FXML private JFXButton addItemBt;
    @FXML private JFXButton addIngredientBt;

    @FXML private TableView<Ingredient> ingredientsListTableView;
    @FXML private TableColumn<Ingredient, String> ingredientNameCol;
    @FXML private TableColumn<Ingredient, Double> ingredientQtyCol;
    @FXML private TableColumn<Ingredient, String> ingredientUnitCol;
    private ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList();

    private FileChooser fileChooser;
    private File imageFile;
    private URL imageUrl;
    private Image uploadedImage;

    MenuItemsTable menuItemsTable = new MenuItemsTable();
    InventoyTable inventoryTable = new InventoyTable();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Add all menu items to the menu items ComboBox
        menuItemsComboBox.setItems(FXCollections.observableArrayList(menuItemsTable.getAllMenuItems()));
        //Add all inventory items to the ingredients ComboBox
        ingredientComboBox.setItems(FXCollections.observableArrayList(inventoryTable.getAllInventoryItems()));
        //Set TableView columns
        ingredientNameCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String> ("itemName"));
        ingredientQtyCol.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("quantity"));
        ingredientUnitCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("unit"));

        uploadImageBt.getStyleClass().add("buttons");
        addItemBt.getStyleClass().add("buttons");
        addIngredientBt.getStyleClass().add("buttons");


    }

    public void uploadImage() throws IOException {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Upload menu item image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.png", "*.jpeg"));

//      Stage stage = (Stage) createMenuPane.getScene().getWindow();
//      imageFile = fileChooser.showOpenDialog(createMenuPane.getScene().getWindow());
        imageFile = fileChooser.showOpenDialog(new Stage());

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
        //(String itemName, String itemCategory, double price, String imagePath)
        //Create a new menu item by retrieving the data frm the form
        boolean formIsValid = true;

        //Check all the inputs if they have data entered
        if (itemNameTextField.getText().trim().isEmpty()) {
            formIsValid = false;
            itemNameTextField.getStyleClass().add("empty");
        } else {
            itemNameTextField.getStyleClass().add("valid");
        }
        if (itemCategoryComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValid = false;
            itemCategoryComboBox.getStyleClass().add("empty");
        } else {
            itemCategoryComboBox.getStyleClass().add("valid");
        }
        if (itemPriceTextField.getText().trim().isEmpty()) {
            formIsValid = false;
            itemPriceTextField.getStyleClass().add("empty");
        } else {
            itemPriceTextField.getStyleClass().add("valid");
        }

        if (itemDiscTextArea.getText().trim().isEmpty()) {
            formIsValid = false;
            itemDiscTextArea.getStyleClass().add("empty");
        } else {
            itemDiscTextArea.getStyleClass().add("valid");
        }
        if(formIsValid){
            MenuItem item = new MenuItem(itemNameTextField.getText(),
                    itemCategoryComboBox.getSelectionModel().getSelectedItem(),
                    itemDiscTextArea.getText(),
                    Double.parseDouble(itemPriceTextField.getText()),
                    imageUrl.toExternalForm());
            //Insert the new created menu item to database table
            menuItemsTable.createMenuItem(item);
            menuItemsComboBox.setItems(FXCollections.observableArrayList(menuItemsTable.getAllMenuItems()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Item has been updated successfully!");
            alert.showAndWait();
            //Update the content of the menu items ComboBox
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("please enter the missing data");
            alert.showAndWait();

        }



    }

    /**
     * A function to create a new ingredient and add it to the database
     */
    public void addIngredient() {
        boolean formIsValidIngredient = true;
        if (ingredientComboBox.getSelectionModel().getSelectedItem() == null) {
            formIsValidIngredient = false;
            ingredientComboBox.getStyleClass().add("empty");
        } else {
            ingredientComboBox.getStyleClass().add("valid");
        }
        if (quantityTextField.getText().trim().isEmpty()) {
            formIsValidIngredient = false;
            quantityTextField.getStyleClass().add("empty");
        } else {
            quantityTextField.getStyleClass().add("valid");
        }
        if (formIsValidIngredient){
            Ingredient ingredientItem = new Ingredient(
                    ingredientComboBox.getSelectionModel().getSelectedItem().getItemName(),
                    quantityTextField.getText(),
                    ingredientComboBox.getSelectionModel().getSelectedItem().getMeasurementUnit());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ingredient has been updated successfully!");
            alert.showAndWait();
            ingredientsList.add(ingredientItem);
            ingredientsListTableView.setItems(ingredientsList);
            ingredientsListTableView.setEditable(false);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("please enter the missing data");
            alert.showAndWait();
        }



    }

}


//https://stackoverflow.com/questions/5613898/storing-images-in-sql-server