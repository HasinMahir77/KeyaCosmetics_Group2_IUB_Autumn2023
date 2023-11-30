/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;

/**
 *
 * @author hasin
 */
public class DeliveryPayment implements Serializable {
    public enum Type{WITHDRAW,DEPOSIT};
    
    private Type type;
    private float amount;
    private String id;
    private boolean done;

    public DeliveryPayment(DeliveryMan dm, Order order) {
        this.type = Type.DEPOSIT;
        this.amount = order.getPrice();
        this.id = order.getId();
    }

    public Type getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDone() {
        this.done = true;
    }
    public static DeliveryPayment generateDeposit(DeliveryMan dm, Order order){
        return new DeliveryPayment(dm,order);
    }
    
     
    
    
}
