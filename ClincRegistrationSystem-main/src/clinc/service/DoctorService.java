package clinc.service;


import clinc.asset.DatabaseConnection;
import clinc.contract.SystemCRUDOperations;
import clinc.entity.Doctor;
import clinc.entity.ScheduleDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorService implements SystemCRUDOperations {


    @Override
    public void create(String ... data) {
        String query = "insert into `doctor`(`name`, `phone`, `department`) values ( '" +
                data[0] +"','" +data[1] + "','"+data[2]+"');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void delete(String doctorID) {
        String query = "delete from `doctor` where `ID` = `" + doctorID + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }
    @Override
    public void update(String ... data) {
        //id-name-phone-department
        String query = "update `doctor` SET `name` = `"+ data[0] +"', `phone` = `" + data[1]
                + "`, `department` = `" + data[2] + "` where `ID` = `" + data[3] + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }
    @Override
    public void readAll() {
        String query = "select * from `doctor` limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void searchByName(String doctorName) {
        String query = "select * from `doctor` where `name` like `%" + doctorName +"%`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void searchByID(String doctorID) {
        String query = "select * from `doctor` where `ID` = `" + doctorID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    @Override
    public void displayData(ResultSet result) {
        System.out.println("Doctor ID   Doctor Name     Doctor Department   Doctor Phone");
        try {
            while (result.next())
                System.out.println(result.getInt(1) + "      " + result.getString(2) + "      " + result.getString(4) + "      " + result.getString(3));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
