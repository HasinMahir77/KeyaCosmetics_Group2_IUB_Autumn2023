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
import mainpkg.ObjectOutputStreamA;

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
    
    public Order(String customer, Cart cart) {
        this.cart = cart; 
        this.customerUserName = customer;
        this.status = Order.Status.PENDING;
    }
    
    public void generateId(){
        
        int id;
        File idFile = new File("OrderID.bin");
        if (idFile.exists()){
            //Reading file
            try(FileInputStream fis = new FileInputStream(idFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)){
                id = (Integer)ois.readInt();
            }
            catch(Exception e){
                System.out.println(e.toString() + " from Order class");id=0;}
            
            //Deleting file
            idFile.delete();
            
            //Rewriting file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(id+1);
            }
            catch(Exception e){System.out.println(e.toString() + " from Order class");}
        }
        else{ //File doesn't exist. This is the first order.
            id=0;
            //Writing file
            try(FileOutputStream fos = new FileOutputStream(idFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeInt(1);
            }
            catch(Exception e){id=0;System.out.println(e.toString() + " from Order class");}
        }
        this.id = id;
        
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
    
    public void saveInstance(){
        File oldCustomerList = new File("OrderList.bin");
        Order order;
        ArrayList<Order> bufferList = new ArrayList<Order>();
        //Collecting all the other users of same type except current user
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                order = (Order)ois.readObject();
                if ( !(order.getId()==this.getId()) ) {
                    bufferList.add(order);
                }
            }
        } catch(Exception e) {
            System.out.println("From order.saveInstance() : "+e.toString());
            System.out.println("ArrayList of orders made");
        } 
        // Arraylist of Orders made.
        
        //Rewriting the bin file with the updated customer object.
       
        try{
            FileOutputStream temp = new FileOutputStream(oldCustomerList);
            temp.close(); //Cleared the file
        }catch(Exception e){
            System.out.println(e);
        }
        
        //Writing files
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Only current order written. Other customers next");
        }
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for(Order c: bufferList){
                    oos.writeObject(c);
                }
        } catch(Exception e){
            System.out.println(e.toString());
        } 
        
        
    }
    
    public static ArrayList<Order> getOrderList(){
        File oldCustomerList = new File("OrderList.bin");
        Order order;
        ArrayList<Order> customerList = new ArrayList<Order>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                order = (Order)ois.readObject();
                customerList.add(order);
            }
        } catch(Exception e) {
            System.out.println("From customer.getCustomerList() : "+e.toString());
            System.out.println("ArrayList of customers made");
        } 
        // Arraylist of Orders made.
        return customerList;
    }

}
