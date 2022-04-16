package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.entity.Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService extends DatabaseConnection {

    public void createAppointment(int ID, Date dateTime, int doctorID, int patientID, String type) {
        Appointment appointment = new Appointment( ID,  dateTime, doctorID,  patientID,  type);
        String query = "insert into `appointment`(`dateTime`, `doctorID`, `patientID`, `type`, `status`) values ( '" +
                dateTime +"','" +doctorID + "','"+patientID +"','" +type+"','booked');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }





    
}
