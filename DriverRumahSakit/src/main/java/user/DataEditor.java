/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;



/**
 *
 * @author LENOVO
 */
public class DataEditor<T extends User> {
    private T user;
    private Map<Patient, String> patients;
    private Map<Admin, String> admins;
    private Map<Doctor, String> doctors;
    Scanner scanner = new Scanner(System.in);
    
    
    
    
  //admin fills every constructor paramater, doctor and paient only fills T user
    //safety for the methods, they can ensure by using ifs checking the generic attribute, error message if thtey dont have access
    public DataEditor(T user, Map<Patient, String> patients, Map<Admin, String> admins, Map<Doctor, String> doctors) {
        this.user = user;
        this.patients = patients;
        this.admins = admins;
        this.doctors = doctors;
    }
    
    public void input(){
        try{
        if (user instanceof Doctor) {
    try {
        System.out.println("(press enter to leave data as it was)");
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input phoneNumber: ");
        String phone = scanner.nextLine();
        System.out.println("Input address: ");
        String address = scanner.nextLine();
        System.out.println("Select doctor type:");
        DoctorType[] doctorTypes = DoctorType.values();
        for (int i = 0; i < doctorTypes.length; i++) {
            System.out.println((i + 1) + ". " + doctorTypes[i].name());
        }

        int doctorTypeIndex = -1;
        boolean validDoctorTypeIndex = false;
        while (!validDoctorTypeIndex) {
            System.out.print("Enter the number corresponding to the doctor type or type 0 for the same value: ");
            try {
                doctorTypeIndex = scanner.nextInt() - 1;
                if (doctorTypeIndex == 0) {
                    validDoctorTypeIndex = true;
                }

                if (doctorTypeIndex >= -1 && doctorTypeIndex < doctorTypes.length) {
                    validDoctorTypeIndex = true;
                } else {
                    System.out.println("Invalid index. Please enter a number between 1 and " + doctorTypes.length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume newline character after nextInt()
        DoctorType doctorType = null;
        if (doctorTypeIndex != -1) {
            doctorType = doctorTypes[doctorTypeIndex];
        }

        updateDoctorData(name, phone, address, doctorType);
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}   else if (user instanceof Patient) {
    try {
        System.out.println("(press enter to leave data as it was)");
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input phoneNumber: ");
        String phone = scanner.nextLine();
        System.out.println("Input address: ");
        String address = scanner.nextLine();
        System.out.println("Input blood type:");
        UserBloodType[] bloodTypes = UserBloodType.values();
        for (int i = 0; i < bloodTypes.length; i++) {
            System.out.println((i + 1) + ". " + bloodTypes[i].name());
        }

        int bloodIndex = -1;
        boolean validBloodTypeIndex = false;
        while (!validBloodTypeIndex) {
            System.out.print("Enter the number corresponding to the blood type or type 0 for the same value: ");
            try {
                bloodIndex = scanner.nextInt() - 1;
                if (bloodIndex == 0) {
                    validBloodTypeIndex = true;
                }

                if (bloodIndex >= -1 && bloodIndex < bloodTypes.length) {
                    validBloodTypeIndex = true;
                } else {
                    System.out.println("Invalid index. Please enter a number between 1 and " + bloodTypes.length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume newline character after nextInt()
        UserBloodType bloodType = null;
        if (bloodIndex != -1) {
            bloodType = bloodTypes[bloodIndex];
        }

        updatePatientData(name, phone, address, bloodType);
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }

    } else if (user instanceof Admin) {
    try {
        System.out.println("1. Edit your data");
        System.out.println("2. Edit doctor data");
        System.out.println("3. Edit patient data");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("(press enter to leave data as it was)");
                System.out.println("Input name: ");
                String name = scanner.nextLine();
                System.out.println("Input phoneNumber: ");
                String phone = scanner.nextLine();
                System.out.println("Input email: ");
                String email = scanner.nextLine();

                updateAdminData(name, phone, email);
                break;
            case 2:
                System.out.println("Select a doctor to edit:");
                Doctor selectedDoctor = viewSchedule(doctors);
                if (selectedDoctor != null) {
                    System.out.println("(press enter to leave data as it was)");
                    System.out.println("Input name: ");
                    name = scanner.nextLine();
                    System.out.println("Input phoneNumber: ");
                    phone = scanner.nextLine();
                    System.out.println("Input address: ");
                    String address = scanner.nextLine();

                    DoctorType[] doctorTypes = DoctorType.values();
                    for (int i = 0; i < doctorTypes.length; i++) {
                        System.out.println((i + 1) + ". " + doctorTypes[i].name());
                    }

                    int doctorTypeIndex = -1;
                    boolean validDoctorTypeIndex = false;
                    while (!validDoctorTypeIndex) {
                        System.out.print("Enter the number corresponding to the doctor type or type 0 for the same value: ");
                        try {
                            doctorTypeIndex = scanner.nextInt() - 1;
                            if (doctorTypeIndex == 0) {
                                validDoctorTypeIndex = true;
                            }

                            if (doctorTypeIndex >= -1 && doctorTypeIndex < doctorTypes.length) {
                                validDoctorTypeIndex = true;
                            } else {
                                System.out.println("Invalid index. Please enter a number between 1 and " + doctorTypes.length + ".");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }
                    scanner.nextLine(); // Consume newline character after nextInt()
                    DoctorType doctorType = null;
                    if (doctorTypeIndex != -1) {
                        doctorType = doctorTypes[doctorTypeIndex];
                    }

                    editDoctorData(selectedDoctor, name, phone, address, doctorType);
                }
                break;
            case 3:
                System.out.println("Select a patient to edit:");
                Patient selectedPatient = viewPatients(patients);
                if (selectedPatient != null) {
                    System.out.println("(press enter to leave data as it was)");
                    System.out.println("Input name: ");
                    name = scanner.nextLine();
                    System.out.println("Input phoneNumber: ");
                    phone = scanner.nextLine();
                    System.out.println("Input address: ");
                    String address = scanner.nextLine();
                    System.out.println("Input blood type:");
                    UserBloodType[] bloodTypes = UserBloodType.values();
                    for (int i = 0; i < bloodTypes.length; i++) {
                        System.out.println((i + 1) + ". " + bloodTypes[i].name());
                    }

                    int bloodIndex = -1;
                    boolean validBloodTypeIndex = false;
                    while (!validBloodTypeIndex) {
                        System.out.print("Enter the number corresponding to the blood type or type 0 for the same value: ");
                        try {
                            bloodIndex = scanner.nextInt() - 1;
                            if (bloodIndex == 0) {
                                validBloodTypeIndex = true;
                            }

                            if (bloodIndex >= -1 && bloodIndex < bloodTypes.length) {
                                validBloodTypeIndex = true;
                            } else {
                                System.out.println("Invalid index. Please enter a number between 1 and " + bloodTypes.length + ".");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }
                    scanner.nextLine(); // Consume newline character after nextInt()
                    UserBloodType bloodType = null;
                    if (bloodIndex != -1) {
                        bloodType = bloodTypes[bloodIndex];
                    }

                    updatePatientData(name, phone, address, bloodType);
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
} else {
    System.out.println("User type not recognized.");
}

        } catch(Exception e){
            System.out.println("An error occured: "+ e.getMessage());
        }
        
    }

    
    
    // doctors edit their own data
    public void updateDoctorData(String name, String phoneNumber, String address, DoctorType doctorType) {
        
        if (user instanceof Doctor) {
            Doctor doctor = (Doctor) user;
            doctor.updateDoctorData(name, doctorType, phoneNumber, address);
            
            System.out.println("Doctor data updated successfully.");
        } else {
            System.out.println("Only doctors can edit their own data.");
        }
    }

    // admins  edit their own data
    public void updateAdminData(String name, String phoneNumber, String email) {
        if (user instanceof Admin) {
            Admin admin = (Admin) user;
            admin.updateAdminData(name, phoneNumber, email);
            System.out.println("Admin data updated successfully.");
        } else {
            System.out.println("Only admins can edit their own data.");
        }
    }

    // patients  edit their own data
    public void updatePatientData(String name, String phoneNumber, String address, UserBloodType bloodType) {
        if (user instanceof Patient) {
            Patient patient = (Patient) user;
            patient.updatePatientData(name, phoneNumber, address, bloodType);
            System.out.println("Patient data updated successfully.");
        } else {
            System.out.println("Only patients can edit their own data.");
        }
    }
    
    
        // admins to edit doctor data
    public void editDoctorData(Doctor doctor, String name, String phoneNumber, String address, DoctorType doctorType) {
        if (user instanceof Admin) {
            if (doctors.containsKey(doctor)) {
                doctor.updateDoctorData(name, doctorType, phoneNumber, address);
                doctors.put(doctor, doctors.get(doctor)); // Update the doctor in the map
                System.out.println("Doctor data updated successfully.");
            } else {
                System.out.println("Doctor not found.");
            }
        } else {
            System.out.println("Only admins can edit doctor data.");
        }
    }

    // admins to edit patient data
    public void editPatientData(Patient patient, String name, String phoneNumber, String address, UserBloodType bloodType) {
        if (user instanceof Admin) {
            if (patients.containsKey(patient)) {
                patient.updatePatientData(name, phoneNumber, address, bloodType);
                patients.put(patient, patients.get(patient)); // Update the patient in the map
                System.out.println("Patient data updated successfully.");
            } else {
                System.out.println("Patient not found.");
            }
        } else {
            System.out.println("Only admins can edit patient data.");
        }
    }
    
    

    public Doctor viewSchedule(Map<Doctor, String> doctor) {
        try {
            System.out.println("Input username:");
            String username = scanner.nextLine();
            for (Map.Entry<Doctor, String> entry : doctor.entrySet()) {
                if (username.equals(entry.getKey().getUsername())) {
                    return entry.getKey();
                }
            }
            System.out.println("Doctor not found.");
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public Patient viewPatients(Map<Patient, String> patients) {
        try {
            System.out.println("Input username:");
            String username = scanner.nextLine();
            for (Map.Entry<Patient, String> entry : patients.entrySet()) {
                if (username.equals(entry.getKey().getUsername())) {
                    return entry.getKey();
                }
            }
            System.out.println("Patient not found.");
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}

