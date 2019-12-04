package sample.controllers;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


import java.net.URL;
import java.util.ResourceBundle;

public class Credits implements Initializable {
    @FXML
    Pane pane;
    @FXML
    Label tableViewVideo,item7,item8,vid1,vid2,vid3,vid4,vid5,vid6,vid7,vid8;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane.setClip(new Rectangle(900, 570));
        TranslateTransition transition_tableViewVideo = new TranslateTransition(Duration.millis(20000), tableViewVideo);
        transition_tableViewVideo.setFromY(500);
        transition_tableViewVideo.setToY(-1000);
        TranslateTransition transition_vid1 = new TranslateTransition(Duration.millis(20000), vid1);
        transition_vid1.setFromY(505);
        transition_vid1.setToY(-1000);
        TranslateTransition transition_vid2 = new TranslateTransition(Duration.millis(20000), vid2);
        transition_vid2.setFromY(510);
        transition_vid2.setToY(-1000);
        TranslateTransition transition_vid3 = new TranslateTransition(Duration.millis(20000), vid3);
        transition_vid3.setFromY(515);
        transition_vid3.setToY(-1000);
        TranslateTransition transition_vid4 = new TranslateTransition(Duration.millis(20000), vid4);
        transition_vid4.setFromY(520);
        transition_vid4.setToY(-1000);
        TranslateTransition transition_vid5 = new TranslateTransition(Duration.millis(20000), vid5);
        transition_vid5.setFromY(525);
        transition_vid5.setToY(-1000);




        TranslateTransition transition_scatterChart = new TranslateTransition(Duration.millis(20000), item7);
        transition_scatterChart.setFromY(530);
        transition_scatterChart.setToY(-1000);
        TranslateTransition transition_vid6 = new TranslateTransition(Duration.millis(20000), vid6);
        transition_vid6.setFromY(535);
        transition_vid6.setToY(-1000);

        TranslateTransition transition_fileChooser = new TranslateTransition(Duration.millis(20000), item8);
        transition_fileChooser.setFromY(540);
        transition_fileChooser.setToY(-1000);
        TranslateTransition transition_vid7 = new TranslateTransition(Duration.millis(20000), vid7);
        transition_vid7.setFromY(545);
        transition_vid7.setToY(-1000);
        TranslateTransition transition_vid8 = new TranslateTransition(Duration.millis(20000), vid8);
        transition_vid8.setFromY(550);
        transition_vid8.setToY(-1000);

        ParallelTransition parallel = new ParallelTransition();
        parallel.getChildren().addAll(transition_tableViewVideo,transition_vid1,transition_vid2,transition_vid3,transition_vid4,transition_vid5,transition_scatterChart,transition_vid6,transition_fileChooser,transition_vid7,transition_vid8);
        parallel.play();
    }
}
