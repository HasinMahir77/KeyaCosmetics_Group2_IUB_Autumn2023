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
public class Overtime implements Serializable{
        private String designation;
    private String name;
    private float hour;
    private LocalDate date;

    public Overtime(String designation, String name, float hour, LocalDate date) {
        this.designation = designation;
        this.name = name;
        this.hour = hour;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Overtime{" + "designation=" + designation + ", name=" + name + ", hour=" + hour + ", date=" + date + '}';
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    
}
