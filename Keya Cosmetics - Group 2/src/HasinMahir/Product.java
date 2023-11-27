/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.IOException;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
import javafx.scene.image.ImageView;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
<<<<<<< HEAD
public class Product implements Serializable,Reviewable {
    protected String name, category;
    protected ArrayList<Review> reviewList; 
    protected float price;
    protected int vatRate;

    @Override
    public void setReview(String sender) {
        Review review = new Review();
        review.setSender(sender);
        try {
            review.takeReview(this);
            this.reviewList.add(review);
        } catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public void getReview() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public enum Category{BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,SHAMPOO,DETERGENT}
=======
public class Product implements Serializable {
    String name;
    Category category;
    int price;
    ImageView image;
    public enum Category{LAUNDRY_SOAP,BODY_SOAP,TOOTHPASTE,DEODORANT,SKINCARE,PETROLEUM_JELLY}
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)

    public Product(){ 
    }

    public Product(String name, int price ,Category category) {
        this.name = name;
<<<<<<< HEAD
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
    public Product(String name, float price ,String category,int vatRate) {
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        this.category = category;
        this.reviewList = new ArrayList<Review>();
    }
    
    public OrderedProduct toProductOrder(int quantity){
        return new OrderedProduct(this.name,this.price,this.category,this.vatRate,quantity);
=======
        this.category = category;
        this.price = price;
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
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
