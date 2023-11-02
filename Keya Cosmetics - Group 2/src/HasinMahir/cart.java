/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author hasin
 */
public class cart {
    
    protected Dictionary<String, orderedProduct> productList = new Hashtable<>();  
    
    /*
    
    
        public void removeProduct(String productName){
    
        for (orderedProduct i: this.productList){
        
            if (i.name == productName){
                productList.remove(i);
            }
        }
    }
*/

    public Dictionary<String, orderedProduct> getProductList() {
        return productList;
    }
    
    
    
}
