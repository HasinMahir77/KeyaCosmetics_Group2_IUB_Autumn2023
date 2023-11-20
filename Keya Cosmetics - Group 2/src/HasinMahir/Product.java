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
    String name;
    String category;
    int price;
    public enum Category{LAUNDRY_SOAP,BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,PETROLEUM_JELLY}

    public Product(){ 
    }

    public Product(String name, int price ,Category categoryEnum) {
        this.name = name;
        this.price = price;
        if (categoryEnum.equals(Category.LAUNDRY_SOAP)){
            this.category = "Laundry Soap";
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
        else if (categoryEnum.equals(Category.TOOTHPASTE)){
            this.category = "Toothpaste";
        }
        else if (categoryEnum.equals(Category.PETROLEUM_JELLY)){
            this.category = "Petroleum Jelly";
        }
    }

    public void addToCart(int quantity){
        Customer c = (Customer)Main.getUserData();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    } 
}
