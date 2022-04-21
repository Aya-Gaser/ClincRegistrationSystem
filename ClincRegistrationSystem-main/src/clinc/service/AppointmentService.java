package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.contract.SystemCRUDOperations;
import clinc.entity.Appointment;
import clinc.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService implements SystemCRUDOperations {


    @Override
    public void create(String ... data) {
        String query = "insert into `appointment`(`dateTime`, `doctorID`, `patientID`, `type`, `status`) values ( '" +
                data[0] +"','" +data[1] + "','"+data[2] +"','" +data[3]+"','booked');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }
    @Override
    public void delete(String appointmentID) {
        String query = "delete from `appointment` where `ID` = `" + appointmentID + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public void update(String ... data) {
        String query = "update `appointment` SET `dateTime` = `"+ data[0] +"', `doctorID` = `" + data[1]
                + "`, `patientID` = `" + data[2] + "`, `type` = `" + data[3]
                + "`, `status` = `" + data[4]
                + "` where `ID` = `" + data[5] + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    @Override
    public void readAll() {
        String query = "select * from `appointment` order by `dateTime` desc limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }

    public void searchByAppointmentDate(Date appointmentDate) {
        String query = "select * from `appointment` where `dateTime` = '" + appointmentDate +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }

    @Override
    public void searchByID(String appointmentID) {
        String query = "select * from `appointment` where `ID` = '" + appointmentID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    public void searchByAppointmentDoctorID(int doctorID) {
        String query = "select * from `appointment` where `doctorID` = '" + doctorID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    public void changeAppointmentStatus(Appointment appointment){
        String query = "update `appointment` SET `status` = `" + appointment.getStatus()
                + "` where `ID` = `" + appointment.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }
    @Override
    public void displayData(ResultSet result) {
        System.out.println("appointment ID      appointment date ");
        try {
            while (result.next())
                System.out.println(result.getInt(1) + "      " + result.getString(2) );

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void searchByName(String doctorName){}





    
}
