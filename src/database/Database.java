package database;

import java.sql.Connection;
import java.sql.DriverManager;

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
    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://"+Credentials.DB_HOST+"/"+Credentials.DB_NAME+"?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(connectionURL, Credentials.DB_USERNAME, Credentials.DB_PASSWORD);
        } catch (Exception e) {
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

}
