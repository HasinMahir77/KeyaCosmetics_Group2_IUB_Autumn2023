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
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hasin
 */
public class Order implements Serializable {
    public enum Status{PENDING,ACCEPTED,DELIVERED};
    
    Status status;
    String customerUserName,deliveryManUserName;
    Cart cart;
    int id;
    
    public Order(int id, String customer, String deliveryman) {
        File idFile = new File("OrderID.bin");
        if (idFile.exists()){
            //Reading file
            try(FileInputStream fis = new FileInputStream(idFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)){
                this.id = (Integer)ois.readInt();
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
            
            //Deleting file
            idFile.delete();
            
            //Rewriting file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(id+1);
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
        }
        else{
            this.id=0;
            //Writing file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(1);
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
        }
        this.id = id;
        cart = new Cart(); 
        this.customerUserName = customer;
        this.deliveryManUserName = deliveryman;
        this.status = Order.Status.PENDING;
    }
    
    public Order(int id) {
        File idFile = new File("OrderID.bin");
        if (idFile.exists()){
            //Reading file
            try(FileInputStream fis = new FileInputStream(idFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)){
                this.id = (Integer)ois.readInt();
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
            
            //Deleting file
            idFile.delete();
            
            //Rewriting file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(id+1);
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
        }
        else{
            this.id=0;
            //Writing file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(1);
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
        }
        this.id = id;
        cart = new Cart();
        this.status = Order.Status.PENDING;
    }

    public Status getStatus() {
        return status;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public String getDeliveryManUserName() {
        return deliveryManUserName;
    }

    public Cart getCart() {
        return cart;
    }

    public int getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public void setDeliveryManUserName(String deliveryManUserName) {
        this.deliveryManUserName = deliveryManUserName;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
