package tables;

import Bcrypt.BCrypt;
import daos.LoginDAO;
import database.Const;
import database.Database;
import javabeans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginTable implements LoginDAO {
    Database db = Database.getInstance();

    @Override
    public User getUser(String username, String password) {
        String query = "SELECT * FROM  "+ Const.TABLE_LOGIN +" WHERE  " + Const.LOGIN_USERNAME + " = '"+ username +"'";
        try{
            Statement getUserId = db.getConnection().createStatement();
            ResultSet data = getUserId.executeQuery(query);
            while (data.next()) {
               if(BCrypt.checkpw(password, data.getString(Const.LOGIN_PASSWORD))){
                   User user = new User(data.getInt(Const.LOGIN_ID), data.getString(Const.LOGIN_USERNAME));
                   return user;
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

