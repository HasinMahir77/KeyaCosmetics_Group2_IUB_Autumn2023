/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import HasinMahir.Order.Status;
import HasinMahir.Product.Category;
import java.io.Serializable;

/**
 *
 * @author hasin
 */
public class Task implements Serializable {
    public enum Type{DELIVERY,DEPOSIT};
    
    private Type type;
    private Order order;
    private String id;

    public Task(Order order) {
        this.order = order;
        this.id = order.getId();
        if (order.getStatus()==Status.OUT_FOR_DELIVERY || order.getStatus()==Status.RETURNED){
            this.type = Type.DELIVERY;
        }
    }
    
    
}
