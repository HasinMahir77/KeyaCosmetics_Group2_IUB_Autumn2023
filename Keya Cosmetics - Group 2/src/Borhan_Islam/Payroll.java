/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.User;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.MainpkgSS;

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
    public float netsalary;
    private static Stage stage;

    
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
    public boolean seePayroll(Payroll payroll) throws IOException{
        this.name = payroll.getName();
        this.desig = payroll.getDesig();
        this.salary = payroll.getSalary();
        this.bonus = payroll.getBonus();
        this.bonustype = payroll.getBonustype();
        this.deductions = payroll.getDeductions();
        this.paymentdate =    payroll.getPaymentdate();   
        //Setting up the new stage and passing data
        MainpkgSS ss = new MainpkgSS();
        stage = new Stage();
        stage.setUserData(this);
        //Scene popping 
        Parent root = FXMLLoader.load(getClass().getResource("SeePayrollRecordsFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Keya Cosmetics: Login");
        stage.showAndWait();   
        return true;
    }
}
