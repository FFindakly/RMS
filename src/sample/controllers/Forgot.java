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

        verify.setOnAction(e->{
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
                Main.toLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

}
