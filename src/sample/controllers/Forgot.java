package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Main;
import tables.LoginTable;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Forgot implements Initializable {
    @FXML
    JFXTextField userName, postal;
    @FXML
    Label resultText;
    @FXML
    JFXButton verify, backToLogin;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backToLogin.getStyleClass().add("buttons");
        verify.getStyleClass().add("buttons");
        verify.setOnAction(e->{
            // Ask the user to enter his username and postal code, if they are correct let him to get change password screen.
            LoginTable login = new LoginTable();
            boolean result = login.verify(userName.getText(), postal.getText());
            if(result){
                try {
                    Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/update.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                resultText.setVisible(true);
            }
        });

        backToLogin.setOnAction(e->{
            try {
                Main.openLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

}
