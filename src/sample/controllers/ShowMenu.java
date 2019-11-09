package sample.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;

public class ShowMenu {

    public void UpdateMenu(MouseEvent event) throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/update_menu.fxml")));
    }
}
