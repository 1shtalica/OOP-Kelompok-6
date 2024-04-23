package user;

import java.util.ArrayList;
import java.util.List;

public class HospitalSystem implements Hospital {
    private List<Patient> patients;



    public HospitalSystem() {
        this.patients = new ArrayList<>();
    }


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

}
