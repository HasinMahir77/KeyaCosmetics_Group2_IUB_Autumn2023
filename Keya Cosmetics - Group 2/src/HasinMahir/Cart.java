/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class Cart implements Serializable {
    
<<<<<<< HEAD
<<<<<<< HEAD
    protected ArrayList<OrderedProduct> productOrderList;
    
    public Cart(){
        this.productOrderList = new ArrayList<OrderedProduct>();
       
        
    }

    public ArrayList<OrderedProduct> getProductOrderList() {
        return productOrderList;
=======
    protected Hashtable<Product,Integer> productList = new Hashtable<Product,Integer>();

    public Hashtable<Product,Integer> getProductList() {
        return productList;
=======
    protected Hashtable<Product,Integer> productList = new Hashtable<Product,Integer>();

    public Hashtable<Product,Integer> getProductList() {
        return productList;
    }

    public void setProductList(Hashtable<Product,Integer> productList) {
        this.productList = productList;
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
    }
    public void addProduct(Product product, int quantity){
        productList.put(product, quantity);
        Customer c = (Customer)Main.getMainStage().getUserData();
       // c.saveInstance();
    }
    
 

<<<<<<< HEAD
    public void setProductList(Hashtable<Product,Integer> productList) {
        this.productList = productList;
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
    }
    public void addProduct(Product product, int quantity){
        productList.put(product, quantity);
        Customer c = (Customer)Main.getMainStage().getUserData();
       // c.saveInstance();
    }
    
 

<<<<<<< HEAD
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
    
    public void remove(OrderedProduct product){
        //Checking if the product exists in cart
        OrderedProduct target=null;
        boolean exists = false;
        int newQuantity = 1; //Arbitrary value to check if item needs removal
        
        for(OrderedProduct p: this.productOrderList){
            if (product.getName().equals(p.getName())){
                exists = true;
                target = p;
                newQuantity = target.getQuantity()-product.getQuantity();
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
=======
   
    
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
=======
   
    
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
    
    
}
