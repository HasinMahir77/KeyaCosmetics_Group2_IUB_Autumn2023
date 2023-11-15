/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.data;

import HasinMahir.Customer;
import HasinMahir.Customer;
import HasinMahir.CustomerServiceExecutive;
import HasinMahir.CustomerServiceExecutive;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author hasin
 * Stores username and user as key-value pairs
 */
public class UserList {
    
    //HasinMahir's Users
    private static Dictionary<String,Customer> customerList = new Hashtable<>(); 
    private static Dictionary<String,CustomerServiceExecutive> customerServiceExecutiveList = new Hashtable<>();
    
    //Borhan's Users
    
    
    
    
    //Nadim's Users
    
    
    //Amit's Users
    
    
    
    
    //HasinMahir's Methods
    
    public static void addUser(Customer newCustomer){
        customerList.put(newCustomer.getUsername(), newCustomer);
    }
    public static void addUser(CustomerServiceExecutive newCustomerServiceExecutive){
        customerServiceExecutiveList.put(newCustomerServiceExecutive.getUsername(), newCustomerServiceExecutive);
    }
    
    public static void removeUser(Customer targetCustomer){
        customerList.remove(targetCustomer.getUsername());
    }
    public static void removeUser(CustomerServiceExecutive targetCustomerServiceExecutive){
        customerServiceExecutiveList.remove(targetCustomerServiceExecutive.getUsername());
        
    }
        public static Dictionary<String, Customer> getCustomerList() {
        return customerList;
    }

    public static Dictionary<String, CustomerServiceExecutive> getCustomerServiceExecutiveList() {
        return customerServiceExecutiveList;
    }
    public static Customer getUser(String username){
        return customerList.get(username);
    }
    public static String getPassword(String username){
        return customerList.get(username).getPassword();
    }
    
    //Borhan's Methods
    
   
    
    //Nadim's Methods
    

    
    
    //Amit's Methods


   
    
    
    
}
