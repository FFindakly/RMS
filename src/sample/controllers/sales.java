package sample.controllers;

import database.Const;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import tables.InventoryCategoryTable;
import tables.InventoyTable;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class sales implements Initializable {
    Database db = Database.getInstance();
    InventoryCategoryTable inventoryCategoriesTable = new InventoryCategoryTable();
    InventoyTable inventoyTable = new InventoyTable();

    @FXML
    private BarChart<String,Double> barChart;
    @FXML
   private Button loader;
    private Connection connection;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void generate(){
        //the data will be graphed according to this query
        String query = "SELECT " + Const.INVENTORY_ITEM_NAME +   "," + Const.INVENTORY_ITEM_QUANTITY + " FROM " + Const.TABLE_INVENTORY + " ORDER BY " + Const.ITEM_CATEGORY_ID +  " asc ";

        XYChart.Series<String,Double> series = new XYChart.Series<>();
      try{
          Statement statement = db.getConnection().createStatement();
          ResultSet data = statement.executeQuery(query);

          //loop through the data set until there are no items left to graph
          while (data.next()){
              series.getData().add(new XYChart.Data<>(data.getString(1),data.getDouble(2)));
          }
          //set the database query to the graph
          barChart.getData().add(series);

     } catch (SQLException e) {
          e.printStackTrace();
      }
    }
}
