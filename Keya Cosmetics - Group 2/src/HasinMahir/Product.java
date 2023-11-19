/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import javafx.scene.image.ImageView;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Product implements Serializable {
    String name;
    Category category;
    int price;
    ImageView image;
    public enum Category{LAUNDRY_SOAP,BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,PETROLEUM_JELLY}

    public Product(){ 
    }

    public Product(String name, int price ,Category category) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public ImageView getImage() {
        return image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
    
    
    public void addToCart(int quantity){
        Customer c = (Customer)Main.getMainStage().getUserData();
        c.addToCart(this,quantity);
        //c.saveInstance();
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }
    
}
