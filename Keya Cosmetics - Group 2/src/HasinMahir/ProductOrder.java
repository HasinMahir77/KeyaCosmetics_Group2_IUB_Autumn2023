/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;

/**
 *
 * @author hasin
 */
public class ProductOrder extends Product implements Serializable {
    private int quantity;
    private float totalPrice, vat;

    public ProductOrder(Product product, int quantity) {
        this.quantity = quantity;
        
        this.vat = this.price*this.quantity*(this.vatRate/100);
        this.totalPrice = (this.price*this.quantity)+vat;
         
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public float getVat() {
        return vat;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.vat = this.price*this.quantity*(this.vatRate/100);
        this.totalPrice = (this.price*this.quantity)+vat;
        
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }
    
    
        
    
    
    
}
