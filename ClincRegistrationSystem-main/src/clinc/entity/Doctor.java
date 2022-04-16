package clinc.entity;

import java.util.ArrayList;

public class Doctor {

    private int ID;
    private String name;
    private String phone;
    private String department;
    private ArrayList <ScheduleDay> schedule;

    public Doctor(String name, String phone, String department){
        this.name = name;
        this.phone = phone;
        this.department = department;
        this.schedule = null;
    }
    // SETTERS
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSchedule(ArrayList <ScheduleDay> schedule){
        this.schedule = schedule;
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
