package sample.controllers;

import com.jfoenix.controls.*;
import javabeans.InventoryItem;
import javabeans.MenuItem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tables.MenuItemsTable;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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


    private FileChooser fileChooser;
    private File imageFile;
    private URL imageUrl;
    private Image uploadedImage;

    MenuItemsTable menuItemsTable = new MenuItemsTable();



    @Override
    public void initialize(URL location, ResourceBundle resources) {


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

    public void addItemToMenu() {
        //(String itemName, String itemCategory, double price, String imagePath)
        //Create a new menu item by retrieving the data frm the form
        MenuItem item = new MenuItem(itemNameTextField.getText(),
                itemCategoryComboBox.getSelectionModel().getSelectedItem(),
                itemDiscTextArea.getText(),
                Double.parseDouble(itemPriceTextField.getText()),
                imageUrl.toExternalForm());
        //Insert the new created menu item to database table
        menuItemsTable.createMenuItem(item);
    }

}


//https://stackoverflow.com/questions/5613898/storing-images-in-sql-server