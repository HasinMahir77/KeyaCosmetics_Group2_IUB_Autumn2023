/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class product {
    String name, amount;
    int id, price;

    public product() {
    }

    public product(String name,int id, String amount, int price) {
        this.name = name;
        this.amount = amount;
        this.id = id;
        this.price = price;
    }
    
    
    public orderedProduct toOrderedProduct(int quantity){
        
        orderedProduct item = new orderedProduct(name, id, amount, price, quantity);
        return item;
    }
    
    
}
