package clinc.entity;
import java.util.Date;

public class Patient {
    private String ID;
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
}
