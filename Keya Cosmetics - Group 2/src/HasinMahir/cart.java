/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class cart {
    
    
    
    
    
    
        public void removeProduct(String productName){
    
        for (product i: this.productList){
        
            if (i.name == productName){
                productList.remove(i);
            }
        }
    }
    
}
