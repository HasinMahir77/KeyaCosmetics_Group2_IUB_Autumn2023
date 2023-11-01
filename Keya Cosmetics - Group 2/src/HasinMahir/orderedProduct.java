/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class orderedProduct extends product {
    int quantity;

    public orderedProduct() {
    }

    public orderedProduct(String name, int id, String amount, int price, int quantity) {
        super(name, id, amount, price);
        this.quantity = quantity;
    }
    
}
