/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class customer extends user {
    cart cart;

    public customer() {
    }

    public customer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.cart = new cart();
    }

    
    
    public void addToCart(product selectedProduct){
        this.cart.productList.add(selectedProduct);   
    }
    
}
