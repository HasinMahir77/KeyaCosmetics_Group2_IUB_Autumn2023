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
public class OrderedProduct extends Product implements Serializable {
    private int quantity;
    private float unitPrice, price, totalPrice, vat;
    

    //Easier constructor
    
    public OrderedProduct(String name, float price, String category, float vatRate, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.unitPrice = price;
        this.price = this.unitPrice*this.quantity;
        this.vat = this.price*this.vatRate/100;
        
        this.totalPrice = this.price+this.vat;
    }

    
    public OrderedProduct(Product product, int quantity) {
        this.quantity = quantity;
        this.name = product.getName();
        this.category = product.getCategory();
        this.vatRate = product.getVatRate();
        
        this.unitPrice=product.getPrice();
        this.price = this.unitPrice*this.quantity;
        this.vat = this.price*this.vatRate/100;
        
        this.totalPrice = this.price+this.vat;
         
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
        this.vat = (this.price*this.quantity)*(((float)this.vatRate)/100);
        this.totalPrice = (this.price*this.quantity);
        
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }
    
    @Override
    public String toString(){
        return "ProductOrder"+this.getName();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }


    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

    
    
        
    
    
    
}
