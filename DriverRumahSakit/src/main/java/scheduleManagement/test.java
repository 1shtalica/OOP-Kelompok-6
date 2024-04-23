/*package scheduleManagement;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import user.Doctor;
import user.DoctorType;
import user.Patient;

public class Schedule {
    private String id;
    private Doctor doctor;
    private Patient[] patients;
    private String date;
    private String timeStart;
    private String timeEnd;
    private Status status;
    private int maxPatients;
    private DoctorType clinic;
    private int totalPatient;
    Scanner scanner = new Scanner(System.in);
    
    public Schedule(Doctor doctor, String date, String timeStart, String timeEnd, Status status, int maxPatients, DoctorType clinic) {
        this.doctor = doctor;
        this.patients = new Patient[maxPatients];
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
        this.maxPatients = maxPatients;
        this.clinic = clinic;
        this.id = generateID();
        this.totalPatient = 0;
        
        
        
        
       
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotalPatient(int totalPatient) {
        this.totalPatient = totalPatient;
    }

    public String getId() {
        return id;
    }

    public int getTotalPatient() {
        return totalPatient;
    }
    
    

    private String generateID() {
        Random random = new Random();
        StringBuilder adminIDBuilder = new StringBuilder();
 
       
        for (int i = 0; i < 5; i++) {
            adminIDBuilder.append(random.nextInt(10));
        }
 
        return adminIDBuilder.toString();
    }



    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient[] getPatients() {
        return patients;
    }
    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    public String getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getMaxPatients() {
        return maxPatients;
    }
    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }
    public DoctorType getClinic() {
        return clinic;
    }
    public void setClinic(DoctorType clinic) {
        this.clinic = clinic;
    }

    public Schedule addSchedule(List<Schedule> Schedules,Map<Doctor, String> doctors){
       //make scanner for input
        System.out.println("Enter Doctor UserName: ");
        String userName = scanner.nextLine();

        Doctor doctor = new Doctor(null,null,null,null,null,null,null,null,null,null);
        for (Doctor existingDoctor : doctors.keySet()) {
            if (existingDoctor.getUsername().equals(userName)) {
                
                doctor = existingDoctor;
                break;
            }
        }
        
        if (doctor.getUsername() != null){
            System.out.println("Enter schedule details:");
            
            
            String date = getDateInput();
           
            String timeStart = getTimeInput();
           
            String timeEnd = getTimeInput(); 
            
            System.out.print("input max patients: ");
            int maxPatient = scanner.nextInt();   
            
            scanner.nextLine();
            DoctorType clinic = getClinicInput();
            


            Schedule schedule = new Schedule(doctor, date, timeStart, timeEnd, Status.AVAILABLE, maxPatient, clinic);
            
            
            return schedule;
        }
        return null;
        
    }


    public void listOfPatient(List<Schedule> schedules) {
        // Loop melalui daftar Schedule
        for (Schedule schedulebaru : schedules) {
            // Cetak informasi tentang jadwal
           
            System.out.println("Date: " + schedulebaru.getDate());
            System.out.println("Time Start: " + schedulebaru.getTimeStart());
            System.out.println("Time End: " + schedulebaru.getTimeEnd());
            
            // Mendapatkan daftar pasien yang terjadwal
            for(int i = 0; i<schedulebaru.getTotalPatient();i++){
                System.out.println(schedulebaru.getPatients()[i].getName());
            }
            
            if(schedulebaru.totalPatient == 0){
                System.out.println("No patients scheduled.");
            }
            

            
           

            // Cetak pemisah untuk setiap jadwal
            System.out.println("-------------------");
        }
        
        System.out.println("");
    }




    public String getDateInput() {
        DateTimeFormatter inputDateFormatter = DateTimeFormatter.ofPattern("d M uuuu");
      LocalDate birthDate = null;
       while (birthDate == null) {
            System.out.print("Enter date (day month year, e.g. 25 5 1990 for 25 May 1990): ");
            String input = scanner.nextLine();

            try {
                
                birthDate = LocalDate.parse(input, inputDateFormatter);
            } catch (Exception e) {

                System.out.println("Invalid date format. Please enter date in the format 'day month year' (e.g. 25 5 1990).");
            }
        }
       DateTimeFormatter outputDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String birthDateString = birthDate.format(outputDateFormatter);
       return birthDateString;
    }

    public String getTimeInput() {
        LocalTime time = null;

        // Ulangi permintaan input waktu sampai waktu valid diberikan
        while (time == null) {
            try {
                // Minta input waktu dari pengguna
                System.out.print("Enter time (HH:mm): ");
                String timeInput = scanner.nextLine();

                // Coba parse input waktu ke dalam LocalTime
                time = LocalTime.parse(timeInput);
            } catch (DateTimeParseException e) {
                // Jika parsing gagal, beri tahu pengguna bahwa format waktu tidak valid
                System.out.println("Invalid time format. Please enter a valid time (HH:mm).");
            }
        }

        // Kembalikan waktu yang valid
        return time.toString();
    }

    public DoctorType getClinicInput(){
        DoctorType[] doctorTypes = DoctorType.values();
        for (int i = 0; i < doctorTypes.length; i++) {
            System.out.println((i + 1) + ". " + doctorTypes[i].name());
        }

        int doctorTypeIndex = -1;
        boolean validDoctorTypeIndex = false;
        while (!validDoctorTypeIndex) {
            System.out.print("Enter the number corresponding to the doctor type or type 0 for the same value: ");
            doctorTypeIndex = scanner.nextInt() - 1;
            if (doctorTypeIndex == 0) {
                validDoctorTypeIndex = true;
            }

            if (doctorTypeIndex >= 0 && doctorTypeIndex < doctorTypes.length) {
                validDoctorTypeIndex = true;
            } else {
                System.out.println("Invalid index. Please enter a number between 1 and " + doctorTypes.length + ".");
            }
        }
        return doctorTypes[doctorTypeIndex];
    }

}*/
