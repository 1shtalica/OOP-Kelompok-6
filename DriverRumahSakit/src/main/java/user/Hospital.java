package user;

import java.util.Map;

public interface Hospital {
    
    public  void removePatients(Patient patient);
    public void removeDoctors(Doctor doctor) ;
    public  void removeAdmins(Admin admin);
    public void deletePatientsData(String username ,Map<Patient, String> patients);
    public void  deleteDoctorsData(String username, Map<Doctor, String> doctors);
}
