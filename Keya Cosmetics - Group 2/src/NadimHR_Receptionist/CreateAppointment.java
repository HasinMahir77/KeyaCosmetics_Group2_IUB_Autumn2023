/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Nadimul
 */

public class CreateAppointment implements Serializable{
    private String name;
    private Integer phoneNumber;
    private LocalDate date;
    private String Createappointment;
    private String Reasone;

    public CreateAppointment(String name, Integer phoneNumber, LocalDate date, String Createappointment, String Reasone) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.Createappointment = Createappointment;
        this.Reasone = Reasone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCreateappointment() {
        return Createappointment;
    }

    public void setCreateappointment(String Createappointment) {
        this.Createappointment = Createappointment;
    }

    public String getReasone() {
        return Reasone;
    }

    public void setReasone(String Reasone) {
        this.Reasone = Reasone;
    }

    @Override
    public String toString() {
        return "CreateAppointment{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", date=" + date + ", Createappointment=" + Createappointment + ", Reasone=" + Reasone + '}';
    }
    
}
