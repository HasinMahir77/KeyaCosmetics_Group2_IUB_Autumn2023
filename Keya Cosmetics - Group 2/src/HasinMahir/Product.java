/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mainpkg.Main;
//import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Product implements Serializable,Reviewable {
    protected String name, category;
    protected ArrayList<Review> reviewList; 
    protected float price, vatRate;

    public void addReview(String sender) {
        Review review = new Review();
        review.setSender(sender);
        boolean success = false;
        review.setSubject(this.getName());
        success = review.takeReview();
        
        if (success){
            this.reviewList.add(review);
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Review saved");
            a.showAndWait();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR,"Failed to save review");
            a.showAndWait();
        }
    }

 
    public ArrayList<Review> getReviewList() {
        return this.reviewList;
    }
    public enum Category{BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,SHAMPOO,DETERGENT}

    public Product(){ 
    }
  
    public Product(String name, float price ,Category categoryEnum,int vatRate) {
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        this.reviewList = new ArrayList<Review>();
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
    public Product(String name, float price ,String category,float vatRate) {
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        this.category = category;
        this.reviewList = new ArrayList<Review>();
    }
    
    public OrderedProduct toProductOrder(int quantity){
        return new OrderedProduct(this.name,this.price,this.category,this.vatRate,quantity);
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

    public float getVatRate() {
        return vatRate;
    }

    public void setVatRate(float vatRate) {
        this.vatRate = vatRate;
    }
    @Override
    public String toString(){
        return "Product"+this.getName();
    }
    public ArrayList<Product> getProductList(){
        File productFile = new File("ProductList.bin");
        ArrayList<Product> productList = new ArrayList<Product>();
        
        try(FileInputStream fis = new FileInputStream(productFile);
                ObjectInputStream ois = new ObjectInputStream(fis) ){
            productList.add((Product)ois.readObject());
        }
        catch(Exception e){}
        
        return productList;
    }
    
}
