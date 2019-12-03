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
            System.out.println(Credentials.DB_NAME);
            System.out.println(Credentials.DB_USERNAME);
            System.out.println(Credentials.DB_PASSWORD);
//          String connectionURL = "jdbc:mysql://php.scweb.ca/"+Credentials.DB_NAME+"?autoReconnect=true&useSSL=false";
            String connectionURL = "jdbc:mysql://localhost/"+Credentials.DB_NAME+"?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(connectionURL, Credentials.DB_USERNAME, Credentials.DB_PASSWORD);
            System.out.println("Connection to database is created!");
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