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
    
    protected Hashtable<Product,Integer> productList = new Hashtable<Product,Integer>();

    public Hashtable<Product,Integer> getProductList() {
        return productList;
    }

    public void setProductList(Hashtable<Product,Integer> productList) {
        this.productList = productList;
    }
    public void addProduct(Product product, int quantity){
        productList.put(product, quantity);
        Customer c = (Customer)Main.getMainStage().getUserData();
        c.saveInstance();
    }
    
 

   
    
    
    
}
