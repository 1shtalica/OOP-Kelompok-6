package user;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adria
 */
public class PatientMcu {
    private String date;
    private String disease;
    private String result_mcu;
    
    public PatientMcu(String date, String disease, String result_mcu) {
        this.date = date;
        this.disease = disease;
        this.result_mcu = result_mcu;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getDisease() {
        return this.disease;
    }
    
    public String getResult() {
        return this.result_mcu;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setDisease(String disease) {
        this.disease = disease;
    }
    
    public void setResult(String result) {
        this.result_mcu = result;
    }
}
