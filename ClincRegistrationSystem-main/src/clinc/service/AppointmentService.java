package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.contract.SystemStakeholdersOperations;
import clinc.entity.Appointment;
import clinc.entity.Doctor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService implements SystemStakeholdersOperations {


    public void createAppointment(int ID, Date dateTime, int doctorID, int patientID, String type) {
        Appointment appointment = new Appointment( ID,  dateTime, doctorID,  patientID,  type);
        String query = "insert into `appointment`(`dateTime`, `doctorID`, `patientID`, `type`, `status`) values ( '" +
                dateTime +"','" +doctorID + "','"+patientID +"','" +type+"','booked');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }
    public void deleteAppointment(String appointmentID) {
        String query = "delete from `appointment` where `ID` = `" + appointmentID + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public void updateAppointment(Appointment appointment) {
        String query = "update `appointment` SET `dateTime` = `"+ appointment.getDateTime() +"', `doctorID` = `" + appointment.getDoctorID()
                + "`, `patientID` = `" + appointment.getPatientID() + "`, `type` = `" + appointment.getType()
                + "`, `status` = `" + appointment.getStatus()
                + "` where `ID` = `" + appointment.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public ResultSet readAllAppointments() {
        String query = "select * from `appointment` order by `dateTime` desc limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        return result;
    }

    public ResultSet searchByAppointmentDate(Date appointmentDate) {
        String query = "select * from `appointment` where `dateTime` = '" + appointmentDate +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        return result;
    }
    public ResultSet searchByAppointmentDoctorID(int doctorID) {
        String query = "select * from `appointment` where `doctorID` = '" + doctorID +"`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        return result;
    }
    public void changeAppointmentStatus(Appointment appointment){
        String query = "update `appointment` SET `status` = `" + appointment.getStatus()
                + "` where `ID` = `" + appointment.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }





    
}
