
package clinc;
import clinc.contract.SystemCRUDOperations;
import clinc.service.AppointmentService;
import clinc.service.DoctorService;
import clinc.service.NurseService;
import clinc.service.PatientService;
import clinc.entity.Doctor;

import java.util.Scanner;

public class Main {
    static Main mainObject = new Main();

    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);
   static Scanner sc2 = new Scanner(System.in);
    public static void main(String[] args)  {


        String option = "-1";
        String section;
        String operation;
        do {
            System.out.println("Welcome to Clinc System");
            System.out.println("Select Data Section ..");
            System.out.println("1.Appointments \n2.Patients \n3.Doctors \n4.Nurses");
            section = sc.nextLine();
            //validate option
            if(section.equals("1") || section.equals("2") || section.equals("3") ||section.equals("4") )
                mainObject.displayOptions(section);
            else{
                System.out.println("Invalid option");
                break;
            }
            operation = sc.nextLine();
            //validate option
            if(operation.equals("1") || operation.equals("2") || operation.equals("3") || operation.equals("4") || operation.equals("5") )
                mainObject.mapToService(section,operation);
            else{
                System.out.println("Invalid option");
                break;
            }




        }
        while(!option.equals("0"));

    }
     void displayOptions(String section){
          String[] sections = new String[] {"Appointment","Patient","Doctor","Nurse"};
         int sectionInt = Integer.parseInt(section)-1;

        System.out.println("1.Create new "+sections[sectionInt]);
        System.out.println("2.List All "+sections[sectionInt]+"s");
        System.out.println("3.Search For "+sections[sectionInt]);
         System.out.println("4.Delete  "+sections[sectionInt]);
         System.out.println("5.Update For "+sections[sectionInt]);
    }
     void mapToService(String section, String operation){
        SystemCRUDOperations serviceObject = null;
        switch (section){
            case "1" : {
                 serviceObject = new AppointmentService();

                break;
            }
            case "2" : {
                 serviceObject = new PatientService();
                break;
            }
            case "3" : {
                 serviceObject = new DoctorService();
                break;
            }
            case "4" : {
                 serviceObject = new NurseService();
                break;
            }
            default: break;

        }
         mainObject.executeOptions(section, serviceObject, operation);
    }
     void executeOptions(String section, SystemCRUDOperations serviceObject, String operation){
        String ID;

        if(operation.equals("1")){
            mainObject.excuteCreateOrUpdate(section, serviceObject, false);
        }
       else if (operation.equals("2")){
            serviceObject.readAll();
        }
        else if (operation.equals("3")){
            System.out.println("Enter ID");
            ID = sc.nextLine();
            serviceObject.searchByID(ID);
        }
        else if (operation.equals("4")){ // delete
            System.out.println("Enter ID");
            ID = sc.nextLine();
            serviceObject.delete(ID);
        }
        else{ //update
            mainObject.excuteCreateOrUpdate(section, serviceObject, true);
        }
    }
     void excuteCreateOrUpdate(String section, SystemCRUDOperations serviceObject, boolean isUpdate){
        String input;
          String[] doctorData  = new String[] {"name","phone","department"};
          String[] nurseData  = new String[] {"name","phone","department"};
          String[] patientData  = new String[] {"name", "phone", "gender", "age"};
          String[] appointmentData  = new String[] {"dateTime", "doctorID", "patientID", "type", "status"};

         String[] creationDataHeaders = new String[0];

        switch (section){
            case "1" : {
                creationDataHeaders = appointmentData;

                break;
            }
            case "2" : {
                creationDataHeaders =  patientData;
                break;
            }
            case "3" : {
                creationDataHeaders =  doctorData;
                break;
            }
            case "4" : {
                creationDataHeaders =  nurseData;
                break;
            }
            default: break;

        }
        String[] creationDataValues = new String[creationDataHeaders.length+1];
        for (int i = 0; i < creationDataHeaders.length; i++) {
            System.out.println("Enter "+creationDataHeaders[i]);
            input = sc.nextLine();
            creationDataValues[i] = input;
        }
        if(isUpdate){
            System.out.println("Enter ID");
            input = sc.nextLine();
            creationDataValues[creationDataHeaders.length] = input;
            serviceObject.update(creationDataValues);
        }

        else{
            serviceObject.create(creationDataValues);
        }
    }

}
