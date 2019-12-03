package tables;

import Bcrypt.BCrypt;
import daos.AccountSettingDAO;
import database.Const;
import database.Database;
import javabeans.Accounts;
import sample.controllers.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountSettingsTable implements AccountSettingDAO {
    Database db = Database.getInstance();


    @Override
    public void InsertAccountSettings(Accounts account) {
        String query = "INSERT INTO " + Const.TABLE_ACCOUNTS +
                "(" + Const.ACCOUNTS_ADDRESS + ", " +
                Const.ACCOUNTS_NAME + ", " +
                Const.ACCOUNTS_TABLENUM + ", " +
                Const.ACCOUNTS_POSTALCODE + ", " +
                Const.ACCOUNTS_PROVINCE + ", " +
                Const.ACCOUNTS_PHONE + ", " +
                Const.ACCOUNTS_EMAIL + ", " +
                Const.ACCOUNTS_USERID + ") VALUES ('" +
                account.getAddress() + "', '" + account.getRestaurantName() + "', '" + account.getNumOfTable() + "', '" + account.getPostalCode() + "', '" + account.getProvince() + "',  '" +
                account.getPhone() + "', '" + account.getEmail() + "', '" +
                Login.userID.get("ID") + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Address has been inserted to the table successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCountOfTables(int user_id) {
        int count = 0;
        String query = "SELECT " +  Const.ACCOUNTS_TABLENUM + " FROM " + Const.TABLE_ACCOUNTS + " WHERE " + Const.ACCOUNTS_USERID + " = " + user_id;
        try{
            Statement getUserId = db.getConnection().createStatement();
            ResultSet data = getUserId.executeQuery(query);
            while (data.next()) {
                count = data.getInt(Const.ACCOUNTS_TABLENUM);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
