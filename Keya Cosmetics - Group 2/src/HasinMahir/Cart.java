/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Cart implements Serializable {
    protected float price;
    protected ArrayList<OrderedProduct> productOrderList;
    
    public Cart(){
        this.productOrderList = new ArrayList<OrderedProduct>();
       
        
    }

    public ArrayList<OrderedProduct> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(ArrayList<OrderedProduct> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public float getPrice() {
        float price = 0;
        for (OrderedProduct po: this.productOrderList){
            price+=po.getTotalPrice();
        }
        this.price=price;
        return price;
    }
    
    public void add(Product product, int quantity){
        //Converting to OrderedProduct
        OrderedProduct productOder = product.toProductOrder(quantity);
        
        //Checking for duplicate
        
        for(OrderedProduct p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                p.setQuantity(p.getQuantity()+quantity);
                return;
            }  
        }
        
        this.productOrderList.add(productOder);
    }
    public void add(OrderedProduct product,int quantity){
        //Converting to OrderedProduct
        OrderedProduct productOder = product.toProductOrder(quantity);
        
        //Checking for duplicate
        
        for(OrderedProduct p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                p.setQuantity(p.getQuantity()+quantity);
                return;
            }  
        }
        
        this.productOrderList.add(productOder);
    }
    
    public void remove(Product product, int quantity){
        //Checking if the product exists in cart
        OrderedProduct target=null;
        boolean exists = false;
        int newQuantity = 1; //Arbitrary value to check if item needs removal
        
        for(OrderedProduct p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                exists = true;
                target = p;
                newQuantity = target.getQuantity()-quantity;
            }  
        }
        if (!exists){
            System.out.println("Doesn't exist in cart");
        }
        else if(newQuantity<=0){
            this.productOrderList.remove(target);
        }
        else{
            target.setQuantity(newQuantity);
        }
        
    }
    
    public void remove(OrderedProduct product, int quantity){
        //Checking if the product exists in cart
        OrderedProduct target=null;
        boolean exists = false;
        int newQuantity = 1; //Arbitrary value to check if item needs removal
        
        for(OrderedProduct p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                exists = true;
                target = p;
                newQuantity = target.getQuantity()-quantity;
            }  
        }
        if (!exists){
            System.out.println("Doesn't exist in cart");
        }
        else if(newQuantity<=0){
            this.productOrderList.remove(target);
        }
        else{
            target.setQuantity(newQuantity);
        }
    }
    
    
    
}
