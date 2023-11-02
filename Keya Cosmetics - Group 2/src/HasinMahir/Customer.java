/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.util.ArrayList;

/**
 *
 * @author hasin
 */
public class Customer extends User {
    Cart cart;
    ArrayList<Order> orderHistory;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.cart = new Cart();
    }

    
    
    public void addToCart(Product selectedProduct){
        this.cart.productList.add(selectedProduct);   
    }
    
}
