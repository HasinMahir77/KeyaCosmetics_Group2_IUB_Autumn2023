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


public class ProductManager extends User implements Serializable, Deleteable{ 
    public ProductManager() {
        this.del = false;
    }
    public ProductManager(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
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
        return ("Product Manager "+"Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
     
    public void saveInstance(){
        File oldProductManagerList = new File("ProductManagerList.bin");
        ProductManager product_manager;
        ArrayList<ProductManager> bufferList = new ArrayList<ProductManager>();
        try(FileInputStream fis = new FileInputStream(oldProductManagerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                product_manager = (ProductManager)ois.readObject();
                if (!(product_manager.getUsername().equals(this.getUsername()))) {
                    bufferList.add(product_manager);
                }
            }
        } catch(Exception e) {
            System.out.println("From product_manager.saveInstance() : "+e.toString());
            System.out.println("ArrayList of product_manager made");
        } 

        try{
            FileOutputStream temp = new FileOutputStream(oldProductManagerList);
            temp.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        try(FileOutputStream fos = new FileOutputStream(oldProductManagerList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Only current product manager written. Other product managers next");
        }
        try(FileOutputStream fos = new FileOutputStream(oldProductManagerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for(ProductManager c: bufferList){
                    oos.writeObject(c);
                }
        } catch(Exception e){
            System.out.println(e.toString());
        } 
        
        
    }
    
    public static ArrayList<ProductManager> getProductManagerList(){
        File oldProductManagerList = new File("ProductManagerList.bin");
        ProductManager product_manager;
        ArrayList<ProductManager> product_managerList = new ArrayList<ProductManager>();
        try(FileInputStream fis = new FileInputStream(oldProductManagerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                product_manager = (ProductManager)ois.readObject();
                product_managerList.add(product_manager);
            }
        } catch(Exception e) {
            System.out.println("From product manager.getProductManagerList() : "+e.toString());
            System.out.println("ArrayList of product managers made");
        } 
        return product_managerList;
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

