/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mainpkg.ObjectOutputStreamA;

/**
 *
 * @author hasin
 */
public class DeliveryMan extends User {
    Cart cart;
    
    
    
    public DeliveryMan(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
        this.del = false;
    }
    
    public DeliveryMan(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
        this.cart = new Cart();
        this.phone = phone;
        this.del = false;
    }
    
    
    
    public void saveInstance(){
        File oldCustomerList = new File("DeliveryManList.bin");
        DeliveryMan deliveryMan;
        ArrayList<DeliveryMan> bufferList = new ArrayList<DeliveryMan>();
        //Collecting all the other users of same type except current user
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                deliveryMan = (DeliveryMan)ois.readObject();
                if (!(deliveryMan.getUsername().equals(this.getUsername()))) {
                    bufferList.add(deliveryMan);
                }
            }
        } catch(Exception e) {
            System.out.println("From DeliveryMan.saveInstance() : "+e.toString());
            System.out.println("ArrayList of delivery men made");
        } 
        // Arraylist of Customers made.
        
        //Rewriting the bin file with the updated customer object.
       
        try{
            FileOutputStream temp = new FileOutputStream(oldCustomerList);
            temp.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Only current delivery man written. Other customers next");
        }
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for(DeliveryMan c: bufferList){
                    oos.writeObject(c);
                }
        } catch(Exception e){
            System.out.println(e.toString());
        }   
    }
    
    public static ArrayList<DeliveryMan> getDeliveryManList(){
        File oldCustomerList = new File("DeliveryManList.bin");
        DeliveryMan deliveryMan;
        ArrayList<DeliveryMan> customerList = new ArrayList<DeliveryMan>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                deliveryMan = (DeliveryMan)ois.readObject();
                customerList.add(deliveryMan);
            }
        } catch(Exception e) {
            System.out.println("From customer.getCustomerList() : "+e.toString());
            System.out.println("ArrayList of customers made");
        } 
        // Arraylist of Customers made.
        return customerList;
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
