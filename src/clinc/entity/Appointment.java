package clinc.entity;
import java.util.Date;

public class Appointment {

   private String ID;
   private Date dateTime;
   private String doctorID;
   private String patientID;
   private String type;
   private String status;
   // status = ['booked', 'completed', 'canceled']
   public Appointment(String ID, Date dateTime, String doctorID, String patientID, String type){
       this.dateTime = dateTime;
       this.doctorID = doctorID;
       this.patientID = patientID;
       this.type = type;
       this.status = "Booked";
   }



}
