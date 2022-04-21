package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.contract.SystemCRUDOperations;
import clinc.entity.Patient;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientService implements SystemCRUDOperations {

    @Override
    public void create(String ... data) {
        String query = "insert into `patient`(`name`, `phone`, `gender`, `age`) values ( '" +
                data[0] +"','" +data[1] + "','"+data[2] + "','" +data[3] +"');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }


    @Override
    public void delete(String patientID) {
        String query = "delete from `patient` where `ID` = `" + patientID + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void update(String ... data) {
        String query = "update `patient` SET `name` = `"+ data[0] +"', `phone` = `" + data[1]
                + "`, `gender` = `" + data[2]  + "`, `age` = `" + data[3]
                + "` where `ID` = `" + data[4] + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void readAll() {
        String query = "select * from `patient` limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }

    @Override
    public void searchByName(String patientName) {
        String query = "select * from `patient` where `name` like `%" + patientName +"%`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void searchByID(String patientID) {
        String query = "select * from `patient` where `ID` = `" + patientID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void displayData(ResultSet result) {
        System.out.println("patient ID   patient Name  patient Phone");
        try {
            while (result.next())
                System.out.println(result.getInt(1) + "      " + result.getString(2) + "      " + result.getString(3));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
