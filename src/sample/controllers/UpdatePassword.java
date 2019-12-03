package sample.controllers;

import Bcrypt.BCrypt;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tables.LoginTable;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdatePassword implements Initializable {
    @FXML
    JFXTextField newPass, newPass2;

    @FXML
    JFXButton update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update.setOnAction(e->{
            boolean result = false;
            LoginTable login = new LoginTable();
            if(newPass.getText().equals(newPass2.getText())){
                result  = login.updatePass(LoginTable.userID.get("id"), BCrypt.hashpw(newPass.getText(), BCrypt.gensalt(10)));
            }
            else{
                System.out.println("Passwords do not match!");
            }
            if(result){
                System.out.println("Olley");
            }else{
                System.out.println("Fuck");
            }
        });

    }
}
