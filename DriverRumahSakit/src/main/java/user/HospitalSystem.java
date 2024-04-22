package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HospitalSystem<T extends User> {
    private T user;
    private Map<Patient, String> patients;
    private Map<Admin, String> admins;
    private Map<Doctor, String> doctors;
    
    public HospitalSystem(T user, Map<Patient, String> patients, Map<Admin, String> admins, Map<Doctor, String> doctors) {
        this.user = user;
        this.patients = patients;
        this.admins = admins;
        this.doctors = doctors;
    }
    
    public void removePatients(Patient patient) {
        patients.remove(patient);
        System.out.println("remove Data Succesfull");
    }
    
    public  void removeAdmins(Admin admin) {
        admins.remove(admin);
        System.out.println("remove Data Succesfull");
    }
    
    public void removeDoctors(Doctor doctor) {
        doctors.remove(doctor);
        System.out.println("remove Data Succesfull");
    }
    
    public void deletePatientsData(String username ,Map<Patient, String> patients) {
        boolean find = false;
         for (Map.Entry<Patient, String> entry : patients.entrySet()) {
            if(username.equals(entry.getKey().getUsername())) {
             find = true;
             patients.remove(entry.getKey());
             break;   
            }
          
        }
         
         if(!find) {
             System.out.println("username not found");
         } else {
             System.out.println("username " + username + " Succesfull deleted" );
         }
    }
    
    public void  deleteDoctorsData(String username, Map<Doctor, String> doctors) {
        boolean find = false;
         for (Map.Entry<Doctor, String> entry : doctors.entrySet()) {
            if(username.equals(entry.getKey().getUsername())) {
             find = true;
             doctors.remove(entry.getKey());
             break;   
            }
          
        }
         
         if(!find) {
             System.out.println("username not found");
         } else {
             System.out.println("username " + username + " Succesfull deleted" );
         }
    }
}
