package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static BorderPane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("FXMLs/login.fxml"));
        scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RMS - Restaurant Management System");
        primaryStage.show();
    }

    /**
     * Method to switch panes of the scene of the primary stage
     * @param pane
     * @author Fadi Findakly
     */
    public static void setPane(BorderPane pane) {
        root.setCenter(pane);
    }

    /**
     * Method to switch panes of the scene of the primary stage
     * @param pane
     * @author Fadi Findakly
     */
    public static void toLogin(BorderPane pane) {
        root.setCenter(pane.getCenter());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
