package clinc.entity;
import java.util.ArrayList;
import java.util.Date;

public class Patient {
    private int ID;
    private  String name;
    private String phone;
    private Date birthdate;
    private String gender;

    public Patient(String name, String phone, Date birthdate, String gender){
        this.name = name;
        this.phone = phone;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    // SETTERS

    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    // GETTERS
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public Date getBirthdate(){
        return this.birthdate;
    }
    public String getGender(){
        return this.gender;
    }
}
