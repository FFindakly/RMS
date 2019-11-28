package sample.controllers;

import database.Const;

import java.sql.*;

public class setUp {
    private Connection connection = null;

//        try {
//        createTable(Const.TABLE_INVENTORY_CATEGORIES,
//                Const.CREATE_TABLE_INVENTORY_CATEGORIES,
//                connection);
//        createTable(Const.TABLE_LOGIN,
//                Const.CREATE_TABLE_LOGIN,
//                connection);
//        createTable(Const.TABLE_INVENTORY,
//                Const.CREATE_TABLE_INVENTORY,
//                connection);
//        createTable(Const.TABLE_ACCOUNTS,
//                Const.CREATE_TABLE_ACCOUNTS,
//                connection);
//        createTable(Const.TABLE_MENU_ITEMS,
//                Const.CREATE_TABLE_MENU_ITEMS,
//                connection);
//        createTable(Const.TABLE_INGREDIENTS,
//                Const.CREATE_TABLE_INGREDIENTS,
//                connection);
//    } catch (
//    SQLException e) {
//        e.printStackTrace();
//    }



    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {

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
