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
public class DeliveryTask implements Serializable {
    public enum Type{DELIVERY,DEPOSIT};
    
    private Type type;
    private Order order;
    private String id;
    private boolean done;

    public DeliveryTask(Order order) {
        this.done = false;
        this.order = order;
        this.id = order.getId();
        if (order.getStatus()==Status.OUT_FOR_DELIVERY || order.getStatus()==Status.INITIATED_RETURN){
            this.type = Type.DELIVERY;
        }
        else if (order.getStatus().equals(Status.DELIVERED)){
            this.type = Type.DEPOSIT;
        }
    }

    public Type getType() {
        return type;
    }

    public Order getOrder() {
        return order;
    }

    public String getId() {
        return id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
