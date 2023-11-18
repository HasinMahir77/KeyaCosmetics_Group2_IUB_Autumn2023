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
public class Customer extends User implements Serializable {
    private Cart cart;
    private ArrayList<Order> orderHistory;
    private String address;

    public Customer() {
        this.del = false;
    }

    public Customer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
        this.del = false;
    }
    public Customer(String firstName, String lastName, String username, String password, String address) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
        this.address = address;
        this.del = false;
    }

    
    
    public void addToCart(Product selectedProduct){
        this.cart.productList.add(selectedProduct);   
    }

    @Override
    public String toString() {
        return ("Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
        
    public void saveInstance(){
        File oldCustomerList = new File("customerList.bin");
        Customer customer;
        ArrayList<Customer> bufferList = new ArrayList<Customer>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                customer = (Customer)ois.readObject();
                if (!(customer.getUsername().equals(this.getUsername()))) {
                    bufferList.add(customer);
                }
            }
        } catch(Exception e) {
            System.out.println("From customer.saveInstance() : "+e.toString());
            System.out.println("ArrayList of customers made");
        } 
        // Arraylist of Customers made.
        
        //Rewriting the bin file with the updated customer object.
        oldCustomerList.delete();
        
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            oos.writeObject(this);
            while(true){
                for (Customer c : bufferList){
                    oos.writeObject(c);
                }
            }
            
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("If EOF, writing is complete.");
        }
        
    }
    public void deleteAccount(){
        File oldCustomerList = new File("customerList.bin");
        Customer customer;
        ArrayList<Customer> bufferList = new ArrayList<Customer>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                customer = (Customer)ois.readObject();
                if (!(customer.getUsername().equals(this.getUsername()))) {
                    bufferList.add(customer);
                }
            }
        } catch(Exception e) {
            System.out.println("From customer.saveInstance() : "+e.toString());
            System.out.println("ArrayList of customers made");
        } 
        // Arraylist of Customers made.
        
        //Rewriting the bin file with the updated customer object.
        oldCustomerList.delete();
        
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            oos.writeObject(this);
            while(true){
                for (Customer c : bufferList){
                    oos.writeObject(c);
                }
            }
            
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("If EOF, writing is complete.");
        }
    }
    
    
}
