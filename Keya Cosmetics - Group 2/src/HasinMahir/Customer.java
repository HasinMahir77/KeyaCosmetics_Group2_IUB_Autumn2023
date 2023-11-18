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
    private String address, phoneNum;

    public Customer() {
        this.del = false;
    }

    public Customer(String firstName, String lastName, String username, String password, String address, String phoneNum) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
        this.address = address;
        this.phoneNum = phoneNum;
        this.del = false;
    }

    
    
    public void addToCart(Product selectedProduct, int quantity){
        this.cart.productList.put(selectedProduct,quantity);   
    }

    @Override
    public String toString() {
        return ("Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Cart getCart() {
        return cart;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public String getAddress() {
        return address;
    }
    /*
        
    public void saveInstance(){
        File oldCustomerList = new File("customerList.bin");
        Customer customer;
        ArrayList<Customer> bufferList = new ArrayList<Customer>();
        //Collecting all the other users of same type except current user
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
            System.out.println("Only current customer written. Other customers next");
        }
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            while(true){
                for(Customer c: bufferList){
                    oos.writeObject(c);
                }
            }
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("If EOF, all users have been");
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
            this.setDel(true); // Account made inaccessible through login.
            oos.writeObject(this); //Updated current user added to bin file.
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
*/
    public static ArrayList<Customer> getCustomerList(){
        File oldCustomerList = new File("customerList.bin");
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
    public static void setCustomerList(ArrayList<Customer> newCustomerList){
        //Rewriting the bin file with the updated customer object.
        File customerList = new File("customerList.bin");
        
        customerList.delete();
        
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

    
    
    
}
