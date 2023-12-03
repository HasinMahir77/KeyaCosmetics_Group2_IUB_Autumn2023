/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.User;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javafx.stage.Stage;

public class Payroll extends User implements Serializable{


    public String name;
    public String desig;
    public float salary;
    public float bonus;
    public String bonustype;
    public float deductions;
    public LocalDate paymentdate;
    public float netsalary;
    private static Stage stage;
    
    public Payroll(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }
    
    public Payroll(){
        
    }

    public Payroll(String name, String desig, float salary, float bonus, String bonustype, float deductions, LocalDate paymentdate, float netsalary) {
        this.name = name;
        this.desig = desig;
        this.salary = salary;
        this.bonus = bonus;
        this.bonustype = bonustype;
        this.deductions = deductions;
        this.paymentdate = paymentdate;
        this.netsalary = netsalary;
    }

    public float getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(float netsalary) {
        this.netsalary = netsalary;
    }

    public Payroll(float netsalary) {
        this.netsalary = netsalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getBonustype() {
        return bonustype;
    }

    public void setBonustype(String bonustype) {
        this.bonustype = bonustype;
    }

    public float getDeductions() {
        return deductions;
    }

    public void setDeductions(float deductions) {
        this.deductions = deductions;
    }

    public LocalDate getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(LocalDate paymentdate) {
        this.paymentdate = paymentdate;
    }
    public static Stage getStage() {
        return stage;
    }

   
    @Override
    public String toString() {
        return "Payroll{" + "name=" + name + ", desig=" + desig + ", salary=" + salary + ", bonus=" + bonus +
                ", bonustype=" + bonustype + ", deductions=" + deductions + ", paymentdate=" + paymentdate + ", netsalary=" + netsalary +'}';
    }
    public void display(){
        System.out.println("Payroll{" + "name=" + name + ", desig=" + desig + ", salary=" + salary + ", bonus=" + bonus +
                ", bonustype=" + bonustype + ", deductions=" + deductions + ", paymentdate=" + paymentdate + ", netsalary=" + netsalary +'}');
    }
//Payroll Processing
    private static final String PAYROLL_FILE_PATH = "payroll.bin";
    
    public static void savePayrollRecord(String name, String desig, float salary, float bonus, String bonustype, float deductions, LocalDate paymentdate, float netsalary) {
        Payroll payrollRecord = new Payroll(name, desig, salary, bonus, bonustype, deductions, paymentdate, netsalary);
        List<Payroll> existingRecords = loadPayrollRecords();
        existingRecords.add(payrollRecord);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PAYROLL_FILE_PATH))) {
            for (Payroll record : existingRecords) {
                oos.writeObject(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Payroll> loadPayrollRecords() {
        List<Payroll> payrollRecords = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PAYROLL_FILE_PATH))) {
            while (true) {
                try {
                    Payroll record = (Payroll) ois.readObject();
                    payrollRecords.add(record);
                } catch (EOFException e) {
                    break; 
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return payrollRecords;
    }   

}