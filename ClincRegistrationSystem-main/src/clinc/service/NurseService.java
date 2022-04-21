package clinc.service;
import clinc.asset.DatabaseConnection;
import clinc.contract.SystemCRUDOperations;
import clinc.entity.Nurse;
import clinc.entity.ScheduleDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NurseService implements SystemCRUDOperations {


    @Override
    public void create(String ... data) {
        String query = "insert into `nurse`(`name`, `phone`, `department`) values ( '" +
                data[0] +"','" +data[1] + "','"+data[2]+"');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }


    @Override
    public void delete(String nurseID) {
        String query = "delete from `nurse` where `ID` = `" + nurseID + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void update(String ... data) {
        String query = "update `nurse` SET `name` = `"+ data[0] +"', `phone` = `" + data[1]
                + "`, `department` = `" + data[2] + "` where `ID` = `" + data[3] + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void readAll() {
        String query = "select * from `nurse` limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }

    @Override
    public void searchByName(String nurseName) {
        String query = "select * from `nurse` where `name` like `%" + nurseName +"%`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void searchByID(String nurseID) {
        String query = "select * from `nurse` where `ID` = `" + nurseID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void displayData(ResultSet result) {
        System.out.println("nurse ID   nurse Name     nurse Department   nurse Phone");
        try {
            while (result.next())
                System.out.println(result.getInt(1) + "      " + result.getString(2) + "      " + result.getString(4) + "      " + result.getString(3));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
