package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HospitalSystem<T extends User> implements Hospital{
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
    


    @Override
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


    /*
    Kodingan versi sebelum menjadi hasmhap


    public List<Patient> getPatients() {
        return patients;
    }

    public void pendaftaranMedicalCheckUp(Patient patient) {
        if (patients.contains(patient)) {
            System.out.println("Pasien sudah melakukan pendaftaran untuk medical check up.");
        } else {
            System.out.println("Pasien belum terdaftar. Silakan lakukan pendaftaran terlebih dahulu.");
        }
    }

    public Patient getPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getPatientID().equals(id)) {
                return patient;
            }
        }
        return null;
    }


    public void resetPatientsId() {
        int id = 1;
        for (User user : patients) {
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                patient.setPatientID(Integer.toString(id++));
            }
        }
    }


    @Override
    public void addPatients(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void removePatients(Patient patient) {
        patients.remove(patient);
        System.out.println("Removed -> " + patient);
    }

    public void getAll() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    */
}
