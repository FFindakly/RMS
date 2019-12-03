package sample.controllers;

import javabeans.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import tables.InventoyTable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Fadi Findakly
 */

public class TrackInventory implements Initializable {

    //Link fxml elements
    @FXML private ScatterChart<String, Double> inventoryChart;
    @FXML private CategoryAxis catAxis;
    @FXML private NumberAxis numAxis;

    //Create an instance of the InventoryTable
    InventoyTable inventoryTable = new InventoyTable();

    //Create an ObservableList for the scattered chart
    ObservableList<XYChart.Series<String, Double>> data;

    //Create 2 series for inventory items quantities and their critical quantities
    XYChart.Series<String, Double> quantities;
    XYChart.Series<String, Double> criticalQuantities;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Assign the Series
        quantities = new XYChart.Series<>();
        criticalQuantities = new XYChart.Series<>();

        //Set the name of the series
        quantities.setName("Actual Quantities");
        criticalQuantities.setName("Minimum Quantities");

        //Loop through of the ObservableList from the InventoryTable and feed that 2 series
        for (InventoryItem item : inventoryTable.getAllInventoryItems()) {
            quantities.getData().add(new XYChart.Data(item.getItemName(), item.getQuantity()));
            criticalQuantities.getData().add(new XYChart.Data(item.getItemName(), item.getCriticalQuantity()));
        }


        //Assign the data ObservableList and add the series to it
        data = FXCollections.observableArrayList();
        data.addAll(quantities, criticalQuantities);


        //Add the data to the scattered chart
        inventoryChart.setData(data);

    }
}
