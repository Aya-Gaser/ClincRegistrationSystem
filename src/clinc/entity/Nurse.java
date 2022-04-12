package clinc.entity;

import java.util.ArrayList;

public class Nurse {
    private String ID;
    private  String name;
    private String phone;
    private String doctorID;
    private ArrayList<ScheduleDay> schedule;

    public Nurse(  String name, String phone, String doctorID , ArrayList<ScheduleDay> schedule){
        this.name = name;
        this.phone = phone;
        this.schedule = schedule;
        this.doctorID = doctorID;
    }
}
