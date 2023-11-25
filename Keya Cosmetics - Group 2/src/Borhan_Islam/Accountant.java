package Borhan_Islam;

import HasinMahir.Deleteable;
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


public class Accountant extends User implements Serializable, Deleteable{ 
    public Accountant() {
        this.del = false;
    }
    public Accountant(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.del = false;
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

    @Override
    public String toString() {
        return ("Accountant "+"Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
     
    public void saveInstance(){
        File oldAccountantList = new File("AccountantList.bin");
        Accountant accountant;
        ArrayList<Accountant> bufferList = new ArrayList<Accountant>();
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
            System.out.println("ArrayList of accountant made");
        } 

        try{
            FileOutputStream temp = new FileOutputStream(oldAccountantList);
            temp.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        try(FileOutputStream fos = new FileOutputStream(oldAccountantList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Only current accountant written. Other accountants next");
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
        // Arraylist of Customers made.
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
 
}

