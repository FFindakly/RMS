package sample.controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Splash implements Initializable {
    @FXML private ImageView logo;
    @FXML private Label name;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        FadeTransition fadeIn = new FadeTransition(Duration.millis(5000), logo);
//        fadeIn.setFromValue(0);
//        fadeIn.setToValue(1);
//
//        ScaleTransition scale = new ScaleTransition(Duration.millis(5000), logo);
//        scale.setByX(0.75);
//        scale.setByY(0.75);


        TranslateTransition transitionLogo = new TranslateTransition(Duration.millis(5000), logo);
        transitionLogo.setFromY(-500);
        transitionLogo.setToY(0);

        TranslateTransition transitionName = new TranslateTransition(Duration.millis(5000), name);
        transitionName.setFromY(500);
        transitionName.setToY(0);
        ParallelTransition parallel = new ParallelTransition();

        parallel.getChildren().addAll(transitionName, transitionLogo);
        parallel.play();

        PauseTransition delay = new PauseTransition(Duration.seconds(7));
        delay.play();
        delay.setOnFinished(event -> {
            try {
                Main.openLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
