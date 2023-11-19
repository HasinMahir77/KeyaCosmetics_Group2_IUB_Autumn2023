/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Product implements Serializable {
    String name, amount, category;
    int price;

    public Product(){ 
    }

    public Product(String name,String category, String amount, int price) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.price = price;
    }
    public void addToCart(int quantity){
        Customer c = (Customer)Main.getMainStage().getUserData();
        c.addToCart(this,quantity);
        //c.saveInstance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
