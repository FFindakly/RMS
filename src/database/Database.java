package database;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.sql.*;

public class Database {

    /**
     * @author Fadi Findakly
     * This class will use the Singleton design pattern
     * to access the database from different classes
     */

    //Create an instance variable
    static private Database instance = null;
    private Connection connection = null;
    @FXML
    Button connecting;
    @FXML
    JFXTextField host;
    @FXML JFXTextField dbName;
    @FXML JFXTextField dbUsername;
    @FXML
    JFXPasswordField dbPassword;
    @FXML
    Label messageIndicator;
    @FXML
    Label hostMessage;
    @FXML
    Label dbMessage;
    @FXML
    Label usernameMessage;
    @FXML
    Label passwordMessage;

    //Create a private constructor for the class
    public void makeConnection() {
        try {
            boolean validation = true;

                if(host.getText().equals("")){
                    validation = false;
                    hostMessage.setText("please enter host");
                    hostMessage.setTextFill(Color.web("#f91313"));

                } else {
                    hostMessage.setVisible(false);
                }
                if(dbName.getText().equals("")){
                    validation = false;
                    dbMessage.setText("please enter db name");
                    dbMessage.setTextFill(Color.web("#f91313"));
                } else {
                    dbMessage.setVisible(false);
                }
                if(dbUsername.getText().equals("")){
                    validation = false;
                    usernameMessage.setText("please enter db username");
                    usernameMessage.setTextFill(Color.web("#f91313"));
                } else {
                    usernameMessage.setVisible(false);
                }
                if(dbPassword.getText().equals("")){
                    passwordMessage.setText("please enter Password");
                    passwordMessage.setTextFill(Color.web("#f91313"));
                    validation = false;
                } else {
                    passwordMessage.setVisible(false);
                }

                if(validation){
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://" +host.getText()+"/" + dbName.getText(), dbUsername.getText(), dbPassword.getText());

                    createTable(Const.TABLE_INVENTORY_CATEGORIES,
                            Const.CREATE_TABLE_INVENTORY_CATEGORIES,
                            connection);
                    createTable(Const.TABLE_LOGIN,
                            Const.CREATE_TABLE_LOGIN,
                            connection);
                    createTable(Const.TABLE_INVENTORY,
                            Const.CREATE_TABLE_INVENTORY,
                            connection);
                    createTable(Const.TABLE_ACCOUNTS,
                            Const.CREATE_TABLE_ACCOUNTS,
                            connection);
                    createTable(Const.TABLE_MENU_ITEMS,
                            Const.CREATE_TABLE_MENU_ITEMS,
                            connection);
                    createTable(Const.TABLE_INGREDIENTS,
                            Const.CREATE_TABLE_INGREDIENTS,
                            connection);
                    messageIndicator.setText("Database has been created successfully");
                    messageIndicator.setTextFill(Color.valueOf("#23b023"));
                }


        } catch (SQLException | ClassNotFoundException e) {
            messageIndicator.setTextFill(Color.web("#f91313"));
            messageIndicator.setText("please enter the correct information");
//            e.printStackTrace();
        }
    }

    //Create getInstance method
    public static Database getInstance() {
        if (instance == null) {
            return new Database();
        }

        return instance;
    }

    //Create getConnection method
    public Connection getConnection() {
        return connection;
    }


    private void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {

        Statement sqlStatement;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet result = md.getTables(null, null, tableName, null);
        if(result.next()) {
            System.out.println(tableName + " table already exists");
        }
        else {
            sqlStatement = connection.createStatement();
            sqlStatement.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

}

