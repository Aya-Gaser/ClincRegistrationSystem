package clinc.entity;

import java.util.ArrayList;
import java.util.Date;

public class Nurse {
    private int ID;
    private  String name;
    private String phone;
    private String department;
    private ArrayList<ScheduleDay> schedule;

    public Nurse(  String name, String phone, String department ){
        this.name = name;
        this.phone = phone;
        this.schedule = null;
        this.department = department;
    }
    // SETTERS

    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setSchedule(ArrayList <ScheduleDay> schedule){
        this.schedule = schedule;
    }
    public void setDepartment(String department){
        this.department = department;
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
    public String getDepartment(){
        return this.department;
    }
    public ArrayList <ScheduleDay> getSchedule(){
        return this.schedule;
    }
}
