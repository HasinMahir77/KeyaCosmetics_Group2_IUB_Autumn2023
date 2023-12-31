/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.stage.Stage;

/**
 *
 * @author hasin
 */
public abstract class User implements Serializable {
    protected String firstName, lastName, username, password,phone,nid;
    protected boolean del;
    protected float balance;
    protected LocalDate doj;
    protected LocalDate dob;

    public User() {
        this.del = false;
        this.balance = 0;
        this.doj = java.time.LocalDate.now();
        this.dob = this.doj;
        
    }

    public User(String firstName, String lastName, String username, String password, String phone) {
        this.firstName = firstName.substring(0, 1).toUpperCase()+firstName.substring(1);
        this.lastName = lastName.substring(0, 1).toUpperCase()+lastName.substring(1);
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.del = false;
        this.balance = 0;
        this.doj = java.time.LocalDate.now();
        this.dob = this.doj;

    }
    
    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName.substring(0, 1).toUpperCase()+firstName.substring(1);
        this.lastName = lastName.substring(0, 1).toUpperCase()+lastName.substring(1);
        this.username = username;
        this.password = password;
        this.del = false;
        this.balance = 0;
        this.doj = java.time.LocalDate.now();
        this.dob = this.doj;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public float getBalance() {
        return balance;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String newPassword){
        this.password=newPassword;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public boolean isDel() {
        return del;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.doj = dob;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
    public String getFullName(){
        return this.firstName+ " " + this.lastName;
    }
    
    public String toString(){
        return "Name: "+this.getFullName()+", Username: "+this.username;
    }
    
    
}
