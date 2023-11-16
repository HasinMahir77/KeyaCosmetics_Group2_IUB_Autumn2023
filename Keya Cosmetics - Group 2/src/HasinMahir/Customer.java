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
public class Customer extends User implements Serializable {
    private Cart cart;
    private ArrayList<Order> orderHistory;
    private String address;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
    }
    public Customer(String firstName, String lastName, String username, String password, String address) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
        this.address = address;
    }

    
    
    public void addToCart(Product selectedProduct){
        this.cart.productList.add(selectedProduct);   
    }

    @Override
    public String toString() {
        return ("Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
    
}
