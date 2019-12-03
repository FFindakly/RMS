package daos;

import javabeans.Accounts;

public interface AccountSettingDAO {
    public void InsertAccountSettings(Accounts address);
    public int getCountOfTables(int user_id);

}
