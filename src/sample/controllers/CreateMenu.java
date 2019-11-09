package sample.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;

public class CreateMenu {
    public void switchToShowMenu(MouseEvent event) throws IOException {
        Main.setPane(FXMLLoader.load(getClass().getResource("../FXMLs/show_menu.fxml")));
    }
}
