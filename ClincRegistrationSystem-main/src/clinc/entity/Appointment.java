package clinc.entity;
import java.util.Date;

public class Appointment {

   private int ID;
   private Date dateTime;
   private int doctorID;
   private int patientID;
   private String type;
   private String status;
   // status = ['booked', 'completed', 'canceled']
   public Appointment(int ID, Date dateTime, int doctorID, int patientID, String type){
       this.dateTime = dateTime;
       this.doctorID = doctorID;
       this.patientID = patientID;
       this.type = type;
       this.status = "Booked";
   }
   // SETTERS

    public void setDateTime(Date dateTime){
       this.dateTime = dateTime;
    }
    public void setDoctorID(int doctorID){
       this.doctorID = doctorID;
    }
    public void setPatientID(int patientID){
        this.patientID = patientID;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setStatus(String status){
        this.status = status;
    }

    // GETTERS
    public int getID(){
       return this.ID;
    }
    public Date getDateTime(){
        return this.dateTime;
    }
    public int getDoctorID(){
       return this.doctorID;
    }
    public int getPatientID(){
       return this.patientID;
    }
    public String getType(){
       return this.type;
    }
    public String getStatus(){
       return this.status;
    }



}
