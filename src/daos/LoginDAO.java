package daos;

import javabeans.User;

/**
 * @author Ugur Demir
 */
public interface LoginDAO {

    public User getUser(String username, String password);
    public boolean verify(String username, String postalCode);
    public boolean updatePass(int userId, String password);

}
