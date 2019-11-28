package sample.controllers;

import database.Const;
import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import tables.InventoryCategoryTable;
import tables.InventoyTable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class sales implements Initializable {
    private Database db = Database.getInstance();
    @FXML
    private BarChart<String, Double> barChart;
    @FXML
    private PieChart pieGraph;
    private ObservableList<PieChart.Data> pieChartData;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generate();
        generator();
        pieGraph.setData(pieChartData);
    }
    //method to populate the barGraph
    @FXML
    private void generate() {
        //the data will be graphed according to this query
        String query = "SELECT " + Const.INVENTORY_ITEM_NAME
                + "," + Const.INVENTORY_ITEM_QUANTITY + "," + Const.CRITICAL_QUANTITY + " FROM "
                + Const.TABLE_INVENTORY + " ORDER BY "
                + Const.ITEM_CATEGORY_ID + " asc ";
        //bar graph data takes in string and a double value
        //placement of data matters say like inventory item and quantity
        //must be placed accordingly to their datatype
        //sideNote to whoever is reading this, explanation is very hard to do
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        //wrap in try catch so it does not die or god forbid, NullPointerException
        //or so if it throws a sql exception
        try {
            Statement statement = db.getConnection().createStatement();
            //execute order 66...wait wrong execution
            ResultSet data = statement.executeQuery(query);
            //loop through the data set until there are no items left to graph
            while (data.next()) {
                series.getData().add(new XYChart.Data<>(data.getString(Const.INVENTORY_ITEM_NAME), data.getDouble(Const.INVENTORY_ITEM_QUANTITY), data.getDouble(Const.CRITICAL_QUANTITY)));
               // series.getData().add(new XYChart.Data<>(data.getString(Const.INVENTORY_ITEM_NAME), data.getDouble(Const.CRITICAL_QUANTITY)));
            }
            //set the database query to the graph...no more banter
            barChart.getData().add(series);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void generator() {
        InventoyTable inventoyTable = new InventoyTable();
        //query that will be executed
        String query = "SELECT * FROM "+ Const.TABLE_INVENTORY;
        pieChartData = FXCollections.observableArrayList();
        try {
            //execution of  query may it rest in peace
            Statement statement = db.getConnection().createStatement();
            ResultSet data = statement.executeQuery(query);
            //loop through the query until there are no more items set the database that you want to be returned
            while (data.next()) {
                //data will retrieve the item name and the quantity
                pieChartData.add(new PieChart.Data(data.getString(Const.INVENTORY_ITEM_NAME),data.getInt(Const.INVENTORY_ITEM_QUANTITY)));
                //pieChartData.add(new PieChart.Data(data.getString(Const.INVENTORY_ITEM_NAME),data.getInt(Const.CRITICAL_QUANTITY)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
