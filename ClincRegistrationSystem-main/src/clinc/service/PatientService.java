package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.entity.Patient;

import java.sql.Date;
import java.sql.ResultSet;

public class PatientService extends DatabaseConnection {

    public static void createPatient(String name, String phone, String gender, Date birthdate) {
        Patient patient = new Patient(name, phone, birthdate, gender);
        String query = "insert into `nurse`(`name`, `phone`, `gender`, `birthdate`) values ( '" +
                name +"','" +phone + "','"+gender + "','" +birthdate +"');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }


    public void deletePatient(Patient patient) {
        String query = "delete from `patient` where `ID` = `" + patient.getID() + "');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }

    public void updatePatient(Patient patient) {
        String query = "update `patient` SET `name` = `"+ patient.getName() +"', `phone` = `" + patient.getPhone()
                + "`, `gender` = `" + patient.getGender()  + "`, `birthdate` = `" + patient.getBirthdate()
                + "` where `ID` = `" + patient.getID() + "');";
        boolean result = executeWritingQuery(query);
        System.out.println(result);
    }

    public ResultSet readAllPatient() {
        String query = "select * from `patient` limit 100";
        ResultSet result = executeReadingQuery(query);
        return result;
    }

    public ResultSet searchByPatientName(String patientName) {
        String query = "select * from `patient` where `name` like `%" + patientName +"%`;";
        ResultSet result = executeReadingQuery(query);
        return result;
    }
}
