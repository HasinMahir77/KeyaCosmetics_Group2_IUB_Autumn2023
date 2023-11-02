/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class Product {
    String name, amount;
    int id, price, quantity;

    public Product() {
        this.quantity=0;
    }

    public Product(String name,int id, String amount, int price, int quantity) {
        this.name = name;
        this.amount = amount;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }
    
    /* REMOVED. DO NOT TOUCH. REMOVED. DO NOT TOUCH. REMOVED. DO NOT TOUCH. 
    
    public orderedProduct toOrderedProduct(int quantity){
        
        orderedProduct item = new orderedProduct(name, id, amount, price, quantity);
        return item;
    }
    
      REMOVED. DO NOT TOUCH. REMOVED. DO NOT TOUCH. REMOVED. DO NOT TOUCH. REMOVED. DO NOT TOUCH.
    */
}
