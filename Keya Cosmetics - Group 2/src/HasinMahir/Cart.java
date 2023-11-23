/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Cart implements Serializable {
    
    protected ArrayList<ProductOrder> productOrderList;
    int price; 
    
    public Cart(){
        this.productOrderList = new ArrayList<ProductOrder>();
        
    }

    public ArrayList<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(ArrayList<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public int getPrice() {
        return price;
    }
    
    public void add(Product product, int quantity){
        //Converting to ProductOrder
        ProductOrder productOder = product.toProductOrder(quantity);
        
        //Checking for duplicate
        /*
        for(ProductOrder p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                p.setQuantity(p.getQuantity()+quantity);
                return;
            }  
        */
        this.productOrderList.add(productOder);
    }
    public void add(ProductOrder product){
        
        //Checking for duplicate
        for(ProductOrder p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                p.setQuantity(p.getQuantity()+product.getQuantity());
                return;
            }  
        }
        this.productOrderList.add(product);
    }
    
    public void remove(Product product, int quantity){
        //Checking for duplicate and quantity
        for(ProductOrder p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                int pq = p.getQuantity()-quantity;
                if (pq<=0){
                    this.productOrderList.remove(p);
                }
                else{
                    p.setQuantity(pq);
                }
            }  
        }   
    }
    
    public void remove(ProductOrder product){
        //Checking for duplicate
        for(ProductOrder p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                int pq = p.getQuantity()-product.getQuantity();
                if (pq<=0){
                    this.productOrderList.remove(p);
                }
                else{
                    p.setQuantity(pq);
                }
            }  
        }
    }
    
    
}
