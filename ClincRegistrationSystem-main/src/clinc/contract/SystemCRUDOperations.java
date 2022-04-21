package clinc.contract;

import java.sql.ResultSet;

public interface SystemCRUDOperations {

    public void create(String ... data);
    public void readAll();
    public void delete(String ID);
    public void update(String ... data);
    public void searchByName(String name);
    public void searchByID(String ID);
    public void displayData(ResultSet result);
}
