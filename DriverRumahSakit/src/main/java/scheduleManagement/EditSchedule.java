/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scheduleManagement;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import user.Doctor;
import user.DoctorType;
import user.Patient;

/**
 *
 * @author adibf
 */
public class EditSchedule {

    private String idSchedule;
    private Doctor varDoctor;
    private String day;
    private String workingHour;
    private Patient[] varPatient;

    private String status;
    private int maxPatient;
    private int sumPatient;
    private DoctorType specialization;

    List<Doctor> doctorList;
    List<EditSchedule> scheduleList;

    Scanner scanner = new Scanner(System.in);

    public EditSchedule(String idSchedule, Doctor varDoctor, String day, String workingHour, String status, List<Doctor> doctorList, List<EditSchedule> scheduleList) {
        this.idSchedule = generateScheduleID();
        this.varDoctor = varDoctor;
        this.day = day;
        this.workingHour = workingHour;
        this.varPatient = new Patient[20];
        this.status = status;
        this.maxPatient = 20;
        this.sumPatient = 0;
        this.specialization = specialization;
        this.doctorList = new ArrayList<>();
        this.scheduleList = new ArrayList<>();
    }

    //==========CHECK SECTION==========
    private String generateScheduleID() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            id.append(random.nextInt(10));
        }

        return id.toString();
    }

    public boolean checkDoctorName(String name) {
        for (Doctor doctor : doctorList) {
            if (doctor.getUsername().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDoctorID(String id) {
        for (Doctor dokter : doctorList) {
            if (dokter.getDoctorID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //==========EDIT SCHEDULE SECTION==========
    public String getWorkingHour() {
        String start, end;
        System.out.println("Enter the start time: ");
        start = scanner.nextLine();

        System.out.println("Enter the end time");
        end = scanner.nextLine();

        return start + "-" + end;
    }

    public void addDoctorSchedule(Doctor doctor, String day) {
        boolean isReady = false;

        if (doctor == null) {
            System.out.println("Doctor not found");
        } else {
            if (scheduleList == null) {
                System.out.println("List Empty");
            } else {
                for (EditSchedule jadwal : scheduleList) {
                    if (jadwal.checkDoctorID(doctor.getDoctorID()) && jadwal.getDay().equalsIgnoreCase(day)) {
                        isReady = true;
                        break;
                    }
                }
            }

            if (isReady) {
                System.out.println("Schedule already exist!");
            } else {
                
                String workingHour = getWorkingHour();
                EditSchedule jadwalBaru = new EditSchedule(generateScheduleID(), doctor, day, workingHour, null, doctorList, scheduleList);
                scheduleList.add(jadwalBaru);
                System.out.println("Jadwal dokter berhasil ditambahkan!");
            }
        }
    }

    public void addSchedulePatient(Patient patient, String idSchedule, EditSchedule arr) {
        EditSchedule schedule = null;
        for (EditSchedule jadwal : arr.scheduleList) {
            if (jadwal.getIdSchedule().equals(idSchedule)) {
                schedule = jadwal;
                break;
            }
        }
        Patient existPatient = null;
        if (patient != null){
            
        for (EditSchedule prevJadwal : arr.scheduleList){
             if(prevJadwal.getSumPatient()>0){
                for(int i =0; i < prevJadwal.getSumPatient(); i++){
                if(patient.getPatientID()== prevJadwal.getVarPatient()[i].getPatientID()){
                    existPatient =patient;
                }
               }
            }
        }
        }
        
        if(existPatient != null){
            System.out.println("you can't book 2 times in one schedule");
        }
        else if (patient == null) {
            System.out.println("Patient not found");
        } else {
            if (schedule != null && schedule.getSumPatient() < schedule.getMaxPatient()) {
                schedule.getVarPatient()[schedule.getSumPatient()] = patient;
                schedule.setSumPatient(schedule.getSumPatient() + 1);
                System.out.println("Patient " + patient.getName() + " added to schedule " + idSchedule);
            } else if (schedule == null) {
                System.out.println("null");
            }
            else { 
                System.out.println("Patient is full or schedule not found");
            }
        }
    }

    public void deleteSchedule(String idS) {
        for (EditSchedule shecdule : scheduleList) {
            if (shecdule.idSchedule.equalsIgnoreCase(idS)) {
                scheduleList.remove(shecdule);
                System.out.println("Doctor's schedule has been removed");
                break;
            }
        }
    }

    public void updateSchedule(String idS) {
        boolean isReady = false;
        EditSchedule schedule = null;

        for (EditSchedule jadwal : scheduleList) {
            if (jadwal.getIdSchedule().equals(idS)) {
                schedule = jadwal;
                isReady = true;
                break;
            }
        }

        if (isReady) {
            System.out.println("Monday");
            System.out.println("Tuesday");
            System.out.println("Wednesday");
            System.out.println("Thursday");
            System.out.println("Friday");
            System.out.println("Saturday");
            System.out.print("Enter day: ");
            String newDay = scanner.nextLine();
            System.out.print("Enter new working hour: ");
            String workingHour = scanner.nextLine();
            
            schedule.setDay(newDay);
            schedule.setWorkingHour(workingHour);
      
            System.out.println("Successfully updated the schedule!");
        } else {
            System.out.println("Schedule with ID " + idS + " not found!");
        }
    }

    public void previewJadwalDokter() {
        for (EditSchedule prevJadwal : scheduleList) {
            System.out.println("Schedule ID: " + prevJadwal.getIdSchedule());
            System.out.println("Doctor ID: " + prevJadwal.getVarDoctor().getDoctorID());
            System.out.println("Doctor Name: " + prevJadwal.getVarDoctor().getUsername());
            System.out.println("Specialization: " + prevJadwal.getVarDoctor().getDoctorType());
            System.out.println("Day: " + prevJadwal.day);
            System.out.println("Working Hour: " + prevJadwal.workingHour);
            System.out.println("");
            if(prevJadwal.getSumPatient()>0){
                for(int i =0; i < prevJadwal.getSumPatient(); i++)
                System.out.println("nama : " + prevJadwal.getVarPatient()[i].getName());
            }
        }
    }

    /*
    public void previewDaftarDokter(){
        for (Doctor dokter : doctorList) {
            System.out.println("Doctor ID: " + dokter.getDoctorID());
            System.out.println("Username: " + dokter.getUsername());
        }
    }*/
    public Doctor viewSchedule(Map<Doctor, String> doctor) {
        System.out.println("Enter the doctor's ID");
        String id = scanner.nextLine();
        for (Map.Entry<Doctor, String> entry : doctor.entrySet()) {
            if (id.equals(entry.getKey().getDoctorID())) {

                return entry.getKey();

            }

        }
        System.out.println("not found");
        return null;
    }
    
    
    //==========GETTER-SETTER SECTION==========
    public int getMaxPatient() {
        return maxPatient;
    }

    public void setMaxPatient(int maxPatient) {
        this.maxPatient = maxPatient;
    }

    public int getSumPatient() {
        return sumPatient;
    }

    public void setSumPatient(int sumPatient) {
        this.sumPatient = sumPatient;
    }

    public DoctorType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(DoctorType specialization) {
        this.specialization = specialization;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Doctor getVarDoctor() {
        return varDoctor;
    }

    public void setVarDoctor(Doctor varDoctor) {
        this.varDoctor = varDoctor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setWorkingHour(String prev) {
        this.workingHour = prev;
    }

    public Patient[] getVarPatient() {
        return varPatient;
    }

    public void setVarPatient(Patient[] varPatient) {
        this.varPatient = varPatient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<EditSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<EditSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
