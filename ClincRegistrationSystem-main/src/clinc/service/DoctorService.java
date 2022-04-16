package clinc.service;


import clinc.asset.DatabaseConnection;
import clinc.entity.Doctor;
import clinc.entity.ScheduleDay;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DoctorService extends DatabaseConnection {

    public static void createDoctor(String name, String phone, String department) {
        Doctor doctor = new Doctor(name, phone, department);
        String query = "insert into `doctor`(`name`, `phone`, `department`) values ( '" +
                name +"','" +phone + "','"+department+"');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }


    public void deleteDoctor(Doctor doctor) {
        String query = "delete from `doctor` where `ID` = `" + doctor.getID() + "');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }

    public void updateDoctor(Doctor doctor) {
        String query = "update `doctor` SET `name` = `"+ doctor.getName() +"', `phone` = `" + doctor.getPhone()
                + "`, `department` = `" + doctor.getDepartment() + "` where `ID` = `" + doctor.getID() + "');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }

    public ResultSet readAllDoctors() {
        String query = "select * from `doctor` limit 100";
        ResultSet result = executeReadingQuery(query);
        return result;
    }

    public ResultSet searchByDoctorName(String doctorName) {
        String query = "select * from `doctor` where `name` like `%" + doctorName +"%`;";
        ResultSet result = executeReadingQuery(query);
        return result;
    }
}
