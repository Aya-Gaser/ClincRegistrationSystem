package clinc.contract;

import java.sql.ResultSet;

public interface SystemStakeholdersOperations {

    public void create(String ... data);
    public void readAll();
    public void delete(String doctorID);
    public void update(String ... data);
    public void searchByName(String doctorName);
    public void displayData(ResultSet result);
}
