package Borhan_Islam;

import HasinMahir.Deleteable;
import HasinMahir.Reviewable;
import HasinMahir.User;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import mainpkg.ObjectOutputStreamA;


public class Accountant extends User implements Serializable, Deleteable {

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
        Accountant target = null;
        System.out.println("Save instance called");
        File userFile = new File("AccountantList.bin");
        ArrayList<Accountant> accountantList = Accountant.getCustomerList();
        //Removing current user
        for(Accountant c: accountantList){
            if (c.getUsername().equals(this.getUsername())){
                target = c;
            }
        }
        accountantList.remove(target);
        //Clearing file
        try{
            new FileInputStream(userFile).close();
        } catch(Exception e){System.out.println(e.toString()+"From Accountant.saveInstance()");}
        
        //Writing current user
        try(FileOutputStream fos = new FileOutputStream(userFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(this);
        }
        catch(Exception e){System.out.println(e.toString()+" From customer saveinstancs");}
        //Writing other users
        try(FileOutputStream fos = new FileOutputStream(userFile,true);
                ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
            for (Accountant c: accountantList){
                oos.writeObject(c);
            }
        }
        catch(Exception e){System.out.println(e.toString()+" From customer saveinstancs");}
    }
    
    public static ArrayList<Accountant> getCustomerList(){
        if (new File("AccountantList.bin").exists()){
            
        ArrayList<Accountant> accountantList = new ArrayList<Accountant>();
        //Reading file
        try(FileInputStream fis = new FileInputStream("AccountantList.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);){
            while(true){
                accountantList.add((Accountant)ois.readObject());}
        }
        catch(EOFException e){System.out.println("AccountantList.bin file reading complete");}
        catch(Exception e){e.printStackTrace(System.out);}
        // Arraylist of Customers made.
        return accountantList;
        }
        else {
            System.out.println("CustomerFile not found. getCustomerList() called.");
            return null;
        }
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
