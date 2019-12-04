package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javabeans.Accounts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import sample.Main;
import tables.AccountSettingsTable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountSettings implements Initializable {
    @FXML private JFXTextArea addressTextField;
    @FXML private JFXComboBox<String> province;
    @FXML private JFXTextField postalCode;
    @FXML private JFXTextField phoneNumber;
    @FXML private JFXTextField restName;
    @FXML private JFXTextField tableNum;
    @FXML private Label resultLabel;
    @FXML private JFXTextField email;

    AccountSettingsTable accountSettingsTable = new AccountSettingsTable();
    public void insertAccountSetting() {

            boolean formIsValid = true;
            try {
                if(addressTextField.getText().equals("")){
                    formIsValid = false;
                }
                if(restName.getText().equals("")){
                    formIsValid = false;
                }
                if(tableNum.getText().equals("")){
                    formIsValid = false;
                }
                if(postalCode.getText().equals("")){
                    formIsValid = false;
                }
                if(phoneNumber.getText().equals("")){
                    formIsValid = false;
                }
                if(email.getText().equals("")){
                    formIsValid = false;
                }
                if(province.getSelectionModel().getSelectedItem() == null){
                    formIsValid = false;
                }
                if(formIsValid){
                    Accounts address = new Accounts(Login.userID.get("ID"), addressTextField.getText(), restName.getText(), Integer.parseInt(tableNum.getText()), province.getSelectionModel().getSelectedItem(), postalCode.getText(), phoneNumber.getText(), email.getText());
                    accountSettingsTable.InsertAccountSettings(address);
                    resultLabel.setText("Account Settings have been inserted successfully!");
                    resultLabel.setTextFill(Color.web("#23b023"));
                    Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/create_inventory.fxml")));

                }else{
                    resultLabel.setText("Please, enter the missing data!");
                    resultLabel.setTextFill(Color.web("#f91313"));
                }

            }catch(Exception e) {
                resultLabel.setTextFill(Color.web("#f91313"));
                resultLabel.setText("Could not insert! Please try again!");
                System.out.println(e);
            }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
