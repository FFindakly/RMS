package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateMenu implements Initializable {

    @FXML private JFXButton uploadImageButton;
    @FXML private ImageView itemImageView;
    @FXML private BorderPane createMenuPane;
    private FileChooser fileChooser;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void uploadImage() throws IOException {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Upload menu item image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.png", "*.jpeg"));

        Stage stage = (Stage) createMenuPane.getScene().getWindow();
        File imageFile = fileChooser.showOpenDialog(stage);

        if (imageFile != null) {
            URL url = imageFile.toURI().toURL();
            Image uploadedImage = new Image(url.toExternalForm());
            itemImageView.setImage(uploadedImage);
        }
    }

}


//https://stackoverflow.com/questions/5613898/storing-images-in-sql-server