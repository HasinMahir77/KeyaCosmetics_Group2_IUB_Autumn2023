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
import mainpkg.Main;
import mainpkg.ObjectOutputStreamA;

/**
 *
 * @author hasin
 */
public class Customer extends User implements Serializable, Deleteable, Reviewable {
    private Cart cart;
    private ArrayList<String> orderIdList;
    private String address;
    private float balance;

    public Customer() {
        this.del = false;
        this.balance=0;
    }

    public Customer(String firstName, String lastName, String username, String password, String address, String phone) {
        super(firstName, lastName, username, password, phone);
        this.cart = new Cart();
        this.orderIdList = new ArrayList<String>();
        this.address = address;
        this.phone = phone;
        this.del = false;
        this.balance=0;
    }

    
    
    public void addToCart(Product selectedProduct, int quantity){
        this.cart.add(selectedProduct,quantity);   
    }

    @Override
    public String toString() {
        return ("Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }

    public ArrayList<String> getOrderIdList() {
        return orderIdList;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    public void setAddress(String address) {
        this.address = address;
    }

 
    public Cart getCart() {
        return cart;
    }


    public String getAddress() {
        return address;
    }
    
        
    public void saveInstance(){
        File customerFile = new File("CustomerList.bin");
        //Preparing arraylist with updated data
        ArrayList<Customer> customerList = Customer.getCustomerList();
        //Removing current customer
        for (Customer c: customerList){
            if (c.getUsername().equals(this.username)){
                customerList.remove(c);
            }
        }
        //Adding updated current customer
        customerList.add(this);
        
        //Clearing file
        try{
            new FileOutputStream(customerFile).close();
        }
        catch(Exception e){}
        
        //Writing file
        try(FileOutputStream fos = new FileOutputStream(customerFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Customer c: customerList){
                oos.writeObject(c);
            }
        }
        catch(Exception e){}
    }
    
    public static ArrayList<Customer> getCustomerList(){
        File oldCustomerList = new File("CustomerList.bin");
        Customer customer;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                customer = (Customer)ois.readObject();
                customerList.add(customer);
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
    /* Broken and probably redundant.
    public static void setCustomerList(ArrayList<Customer> newCustomerList){
        //Rewriting the bin file with the updated customer object.
        File customerList = new File("customerList.bin");
        //Clearing the existing file
        try{
            FileOutputStream fos = new FileOutputStream(customerList);
            fos.close();
        }catch(Exception e){}
        
        try(FileOutputStream fos = new FileOutputStream(customerList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(newCustomerList.get(0)); //Added first customer
        } catch(Exception e){
            System.out.println(e.toString());
        }
        //Writing the rest of the customers.
        try(FileOutputStream fos = new FileOutputStream(customerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for (Customer customer: newCustomerList){
                oos.writeObject(customer);
            }   
        } catch(Exception e){
            System.out.println(e.toString());
        }
        }
*/

    @Override
    public void addReview(String sender) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
    
    
}
