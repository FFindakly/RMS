package daos;

import javabeans.User;

/**
 * @author Ugur Demir
 */
public interface LoginDAO {

    public User getUser(String username, String password);

}
