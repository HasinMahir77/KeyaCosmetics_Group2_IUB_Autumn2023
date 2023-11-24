/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hasin
 */
public class Order implements Serializable {
    
    String customerUserName,deliveryManUserName,status;
    Cart cart;
    int id;
    
    
    

    public Order(int id) {
        this.id = id;
        cart = new Cart();
    }
    

}
