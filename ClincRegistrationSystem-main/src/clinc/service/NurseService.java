package clinc.service;
import clinc.asset.DatabaseConnection;
import clinc.contract.SystemStakeholdersOperations;
import clinc.entity.Nurse;
import clinc.entity.ScheduleDay;

import java.sql.ResultSet;

public class NurseService implements SystemStakeholdersOperations {



    public static void createNurse(String name, String phone, String department) {
        Nurse nurse = new Nurse(name, phone, department);
        String query = "insert into `nurse`(`name`, `phone`, `department`) values ( '" +
                name +"','" +phone + "','"+department+"');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }


    public void deleteNurse(Nurse nurse) {
        String query = "delete from `nurse` where `ID` = `" + nurse.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public void updateNurse(Nurse nurse) {
        String query = "update `nurse` SET `name` = `"+ nurse.getName() +"', `phone` = `" + nurse.getPhone()
                + "`, `department` = `" + nurse.getDepartment() + "` where `ID` = `" + nurse.getID() + "');";
        boolean result = DatabaseConnection.executeWritingQuery(query);
        System.out.println(result);
    }

    public ResultSet readAllNurses() {
        String query = "select * from `nurse` limit 100";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        return result;
    }

    public ResultSet searchByNurseName(String nurseName) {
        String query = "select * from `nurse` where `name` like `%" + nurseName +"%`;";
        ResultSet result = DatabaseConnection.executeReadingQuery(query);
        return result;
    }
}
