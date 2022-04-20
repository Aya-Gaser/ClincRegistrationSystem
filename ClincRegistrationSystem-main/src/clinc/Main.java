
package clinc;
import clinc.contract.SystemStakeholdersOperations;
import clinc.service.AppointmentService;
import clinc.service.DoctorService;
import clinc.service.NurseService;
import clinc.service.PatientService;
import clinc.entity.Doctor;

import java.util.Scanner;

public class Main {

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
                displayOptions(section);
            else{
                System.out.println("Invalid option");
                break;
            }
            operation = sc.nextLine();
            //validate option
            if(operation.equals("1") || operation.equals("2")  )
                mapToService(section,operation);
            else{
                System.out.println("Invalid option");
                break;
            }




        }
        while(!option.equals("0"));

    }
    static void displayOptions(String section){
        System.out.println("1.Create new "+section);
        System.out.println("2.List All "+section+"s");
        System.out.println("3.Search For "+section);
    }
    static void mapToService(String section, String operation){
        SystemStakeholdersOperations serviceObject = null;
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
        executeOptions(serviceObject, operation);
    }
    static void executeOptions(SystemStakeholdersOperations serviceObject, String operation){
        String name;
        String phone;
        String department;
        if(operation.equals("1")){
            System.out.println("Enter Doctor Name");
            name = sc.nextLine();
            System.out.println("Enter Doctor phone");
            phone = sc1.nextLine();
            System.out.println("Enter Doctor department");
            department = sc2.nextLine();
            serviceObject.create(name, phone, department);
        }
       else if (operation.equals("2")){
            serviceObject.readAll();
        }
        else{
            System.out.println("Enter Doctor Name");
            name = sc.nextLine();
            serviceObject.searchByName(name);
        }
    }

}
