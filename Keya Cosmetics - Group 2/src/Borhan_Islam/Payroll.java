/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.User;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author 88019
 */
public class Payroll extends User implements Serializable{
    public String name;
    public String desig;
    public float salary;
    public float bonus;
    public String bonustype;
    public float deductions;
    public LocalDate paymentdate;

    public Payroll(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public Payroll(String name, String desig, float salary, float bonus, String bonustype, float deductions, LocalDate paymentdate) {
        this.name = name;
        this.desig = desig;
        this.salary = salary;
        this.bonus = bonus;
        this.bonustype = bonustype;
        this.deductions = deductions;
        this.paymentdate = paymentdate;
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

    @Override
    public String toString() {
        return "Payroll{" + "name=" + name + ", desig=" + desig + ", salary=" + salary + ", bonus=" + bonus + ", bonustype=" + bonustype + ", deductions=" + deductions + ", paymentdate=" + paymentdate + '}';
    }
   
}
