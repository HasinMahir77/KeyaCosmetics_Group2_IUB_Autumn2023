package Borhan_Islam;

import HasinMahir.Deleteable;
import HasinMahir.Reviewable;
import HasinMahir.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import mainpkg.ObjectOutputStreamA;


public class Accountant extends User implements Serializable, Deleteable, Reviewable {

    public Accountant() {

    }
    
    public Accountant(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
        this.del=false;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        this.dob = dob;
    }

    
    public String toString() {
        return ("Accountant "+"Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }

    
        
    public void saveInstance(){
        File oldAccountantList = new File("AccountantList.bin");
        Accountant accountant;
        ArrayList<Accountant> bufferList = new ArrayList<Accountant>();
        //Collecting all the other users of same type except current user
        try(FileInputStream fis = new FileInputStream(oldAccountantList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                accountant = (Accountant)ois.readObject();
                if (!(accountant.getUsername().equals(this.getUsername()))) {
                    bufferList.add(accountant);
                }
            }
        } catch(Exception e) {
            System.out.println("From accountant.saveInstance() : "+e.toString());
            System.out.println("ArrayList of accountants made");
        } 
        // Arraylist of Accountants made.
        
        //Rewriting the bin file with the updated accountant object.
       
        try{
            FileOutputStream temp = new FileOutputStream(oldAccountantList);
            ObjectOutputStream temp2 = new ObjectOutputStream(temp);
            temp2.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        try(FileOutputStream fos = new FileOutputStream(oldAccountantList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
            System.out.println("Current accountant written. Other accountants next");
        } catch(Exception e){
            System.out.println(e.toString());
        }
        try(FileOutputStream fos = new FileOutputStream(oldAccountantList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for(Accountant c: bufferList){
                    oos.writeObject(c);
                }
        } catch(Exception e){
            System.out.println(e.toString());
        } 
        
        
    }
    
    public static ArrayList<Accountant> getAccountantList(){
        File oldAccountantList = new File("AccountantList.bin");
        Accountant accountant;
        ArrayList<Accountant> accountantList = new ArrayList<Accountant>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldAccountantList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                accountant = (Accountant)ois.readObject();
                accountantList.add(accountant);
            }
        } catch(Exception e) {
            System.out.println("From accountant.getAccountantList() : "+e.toString());
            System.out.println("ArrayList of accountants made");
        } 
        // Arraylist of Accountants made.
        return accountantList;
    }
    
    public void delete(){
        if (this.isDel()){
            System.out.println("Acoount is already deleted");
        }
        else{
            this.del = true;
            this.username+=".deleted";
        }
    }
    public void recover(){
        if (this.isDel()){
            this.del = false;
            this.username=".deleted";
        }
        else{
            this.del = true;
            this.username = this.username.substring(0,this.username.length()-8);
        }
    }

    @Override
    public void addReview(String sender) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
    
    
}
