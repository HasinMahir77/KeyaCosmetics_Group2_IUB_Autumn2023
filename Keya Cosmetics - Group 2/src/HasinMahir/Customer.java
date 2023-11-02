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
    
    public void addToCart(product selectedProduct){
        this.cart.productList.put(selectedProduct.name, selectedProduct.toOrderedProduct(1));   
    }
    public void addToCart(orderedProduct selectedProduct){
        this.cart.productList.put(selectedProduct.name, selectedProduct);   
    }
}
