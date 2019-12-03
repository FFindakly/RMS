package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javabeans.Accounts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import tables.AccountSettingsTable;

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

                if (addressTextField.getText().trim().isEmpty()) {
                    formIsValid = false;
                    addressTextField.getStyleClass().add("empty_data_fields");
                } else {
                    addressTextField.getStyleClass().clear();
                }


                if (restName.getText().trim().isEmpty()) {
                    formIsValid = false;
                    restName.getStyleClass().add("empty_data_fields");
                } else {
                    restName.getStyleClass().clear();
                }
                if (tableNum.getText().trim().isEmpty()) {
                    formIsValid = false;
                    tableNum.getStyleClass().add("empty_data_fields");
                } else {
                    tableNum.getStyleClass().clear();
                }
                if (postalCode.getText().trim().isEmpty()) {
                    formIsValid = false;
                    postalCode.getStyleClass().add("empty_data_fields");
                } else {
                    postalCode.getStyleClass().clear();
                }
                if (phoneNumber.getText().trim().isEmpty()) {
                    formIsValid = false;
                    phoneNumber.getStyleClass().add("empty_data_fields");
                } else {
                    phoneNumber.getStyleClass().clear();
                }
                if (email.getText().trim().isEmpty()) {
                    formIsValid = false;
                    email.getStyleClass().add("empty_data_fields");
                } else {
                    email.getStyleClass().clear();
                }
                if(province.getSelectionModel().getSelectedItem() == null){
                    province.getStyleClass().add("empty_data_fields");
                    formIsValid = false;
                } else {
                    province.getStyleClass().clear();
                }
                if(formIsValid){
                    Accounts address = new Accounts(Login.userID.get("ID"), addressTextField.getText(), restName.getText(), Integer.parseInt(tableNum.getText()), province.getSelectionModel().getSelectedItem(), postalCode.getText(), phoneNumber.getText(), email.getText());
                    accountSettingsTable.InsertAccountSettings(address);
                    resultLabel.setText("Account Settings have been inserted successfully!");
                    resultLabel.setTextFill(Color.web("#23b023"));

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
