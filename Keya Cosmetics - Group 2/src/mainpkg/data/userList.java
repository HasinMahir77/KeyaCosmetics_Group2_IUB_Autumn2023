/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.data;

import HasinMahir.customer;
import HasinMahir.customer;
import HasinMahir.customerServiceExecutive;
import HasinMahir.customerServiceExecutive;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author hasin
 * Stores username and user as key-value pairs
 */
public class userList {
    static int nextid = 0;
    
    //HasinMahir's Users
    private static Dictionary<String,customer> customerList = new Hashtable<>(); 
    private static Dictionary<String,customerServiceExecutive> customerServiceExecutiveList = new Hashtable<>();
    
    //Borhan's Users
    
    
    //Nadim's Users
    
    
    //Amit's Users
    
    
    //Methods
    
    public static void addUser(customer newCustomer){
        customerList.put(newCustomer.getUsername(), newCustomer);
    }
    public static void addUser(customerServiceExecutive newCustomerServiceExecutive){
        customerServiceExecutiveList.put(newCustomerServiceExecutive.getUsername(), newCustomerServiceExecutive);
    }
    
}
