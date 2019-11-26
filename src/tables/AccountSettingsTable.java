package tables;

import daos.AccountSettingDAO;
import database.Const;
import database.Database;
import javabeans.Accounts;
import sample.controllers.Login;

import java.sql.SQLException;

public class AccountSettingsTable implements AccountSettingDAO {
    Database db = Database.getInstance();


    @Override
    public void InsertAccountSettings(Accounts account) {
        String query = "INSERT INTO " + Const.TABLE_ACCOUNTS +
                "(" + Const.ACCOUNTS_ADDRESS + ", " +
                Const.ACCOUNTS_NAME + ", " +
                Const.ACCOUNTS_TABLENUM + ", " +
                Const.ACCOUNTS_POSTALCODE + ", " +
                Const.ACCOUNTS_PHONE + ", " +
                Const.ACCOUNTS_EMAIL + ", " +
                Const.ACCOUNTS_USERID + ") VALUES ('" +
                account.getAddress() + "', '" + account.getRestaurantName() + "', '" + account.getNumOfTable() + "', '" + account.getPostalCode() + "', '" +
                account.getPhone() + "', '" + account.getEmail() + "', '" +
                Login.userID.get("ID") + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Address has been inserted to the table successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
