package clinc.entity;

import java.util.ArrayList;

public class Doctor {

    private String ID;
    private String name;
    private String phone;
    private String department;
    private ArrayList <ScheduleDay> schedule;

    public Doctor(String name, String phone, String department, ArrayList <ScheduleDay> schedule){
        this.name = name;
        this.phone = phone;
        this.department = department;
        this.schedule = schedule;
    }
}
