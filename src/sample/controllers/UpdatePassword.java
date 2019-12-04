package sample.controllers;

import Bcrypt.BCrypt;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.Main;
import tables.LoginTable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdatePassword implements Initializable {
    @FXML
    JFXPasswordField newPass, newPass2;
    @FXML
    Label resultText;
    @FXML
    JFXButton update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update.setOnAction(e->{
            boolean result = false;
            LoginTable login = new LoginTable();

            //If password matches, verify them with the data in the database
            if(newPass.getText().equals(newPass2.getText())){
                result  = login.updatePass(LoginTable.userID.get("id"), BCrypt.hashpw(newPass.getText(), BCrypt.gensalt(10)));
            }
            else{
                resultText.setVisible(true);
            }
            if(result){
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("You password successfully changed!");
                    alert.showAndWait();
                    Main.openLogin(FXMLLoader.load(getClass().getResource("../FXMLs/login.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                System.out.println("Fuck");
            }
        });

    }
}
