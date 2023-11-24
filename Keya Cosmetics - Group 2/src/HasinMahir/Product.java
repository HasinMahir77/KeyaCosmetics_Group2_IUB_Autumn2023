/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mainpkg.Main;
//import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Product implements Serializable {
    protected String name;
    protected String category;
    protected float price;
    protected int vatRate;
    public enum Category{BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,SHAMPOO,DETERGENT}

    public Product(){ 
    }
  
    public Product(String name, float price ,Category categoryEnum,int vatRate) {
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        if (categoryEnum.equals(Category.DETERGENT)){
            this.category = "Detergent";
        }
        else if (categoryEnum.equals(Category.BODY_SOAP)){
            this.category = "Body Soap";
        }
        else if (categoryEnum.equals(Category.TOOTHPASTE)){
            this.category = "Toothpaste";
        }
        else if (categoryEnum.equals(Category.DEODORANT)){
            this.category = "Deodorant";
        }
        else if (categoryEnum.equals(Category.SHAMPOO)){
            this.category = "Shampoo";
        }
        else if (categoryEnum.equals(Category.SKINCARE)){
            this.category = "Skincare";
        }
    }
    public Product(String name, float price ,String category,int vatRate) {
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        this.category = category;
    }
    
    public ProductOrder toProductOrder(int quantity){
        return new ProductOrder(this.name,this.price,this.category,this.vatRate,quantity);
    }

    
    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    } 

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }
    @Override
    public String toString(){
        return "Product"+this.getName();
    }
    
}
