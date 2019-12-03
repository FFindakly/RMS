package tables;

import Bcrypt.BCrypt;
import daos.LoginDAO;
import database.Const;
import database.Database;
import javabeans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoginTable implements LoginDAO {
    Database db = Database.getInstance();
    public static Map<String, Integer> userID = new HashMap<String, Integer>();
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

    public boolean verify(String username, String postalCode) {
        String query = "SELECT " + Const.LOGIN_USERNAME + " , " + Const.TABLE_USER_ID + " , " + Const.ACCOUNTS_POSTALCODE +  " FROM " + Const.TABLE_LOGIN + " INNER JOIN "  + Const.TABLE_ACCOUNTS +  " ON " + Const.LOGIN_USERNAME +  " = '" + username + "'";
        System.out.println(query);
        try{
            Statement getVerify = db.getConnection().createStatement();
            ResultSet data = getVerify.executeQuery(query);
            while (data.next()) {
                if(data.getString(Const.ACCOUNTS_POSTALCODE).equals(postalCode)){
                    userID.put("id", data.getInt(Const.TABLE_USER_ID));
                    return  true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updatePass(int userid, String password) {
        String query = "UPDATE " + Const.TABLE_LOGIN + " SET " + Const.LOGIN_PASSWORD + " = '" + password + "'" + " WHERE " + Const.LOGIN_ID + " = '" + userid + "'";
        System.out.println(query);
        try{
            Statement getVerify = db.getConnection().createStatement();
            int data = getVerify.executeUpdate(query);
            if(data == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

