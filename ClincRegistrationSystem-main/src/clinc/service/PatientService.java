package clinc.service;

import clinc.asset.DatabaseConnection;
import clinc.contract.SystemStakeholdersOperations;
import clinc.entity.Patient;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientService implements SystemStakeholdersOperations {

    public static void createPatient(String name, String phone, String gender, Date birthdate) {
        Patient patient = new Patient(name, phone, birthdate, gender);
        String query = "insert into `nurse`(`name`, `phone`, `gender`, `birthdate`) values ( '" +
                name +"','" +phone + "','"+gender + "','" +birthdate +"');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }


    public void deletePatient(Patient patient) {
        String query = "delete from `patient` where `ID` = `" + patient.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public void updatePatient(Patient patient) {
        String query = "update `patient` SET `name` = `"+ patient.getName() +"', `phone` = `" + patient.getPhone()
                + "`, `gender` = `" + patient.getGender()  + "`, `birthdate` = `" + patient.getBirthdate()
                + "` where `ID` = `" + patient.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public void readAllPatient() {
        String query = "select * from `patient` limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }

    public void searchByPatientName(String patientName) {
        String query = "select * from `patient` where `name` like `%" + patientName +"%`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        displayData(result);
    }
    public void displayData(ResultSet result) {
        System.out.println("Patient ID   Patient Name  Patient Phone");
        try {
            while (result.next())
                System.out.println(result.getInt(1) + "      " + result.getString(2) + "      " + result.getString(3));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
