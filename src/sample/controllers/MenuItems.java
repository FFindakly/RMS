package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuItems  implements Initializable {

    @FXML
    public ListView<String> lister;

    ObservableList<String> list = FXCollections.observableArrayList("Ing1","Ing2","Ing3");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lister.setItems(list);
    }
}
