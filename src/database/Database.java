package database;

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

    //Create a private constructor for the class
    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String connectionURL = "jdbc:mysql://localhost:8889/"+Credentials.DB_NAME+"?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" + Credentials.DB_NAME,
                    Credentials.DB_USERNAME, Credentials.DB_PASSWORD);
            System.out.println("Created Connection");


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void createTable(String tableName, String tableQuery,Connection connection) throws SQLException {

        //
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

