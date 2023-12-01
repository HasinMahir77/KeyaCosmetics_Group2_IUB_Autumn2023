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

    public DeliveryPayment(Type type, String id, float amount) {
        this.type = type;
        this.amount = amount;
        this.id = id;
    }
    public DeliveryPayment(DeliveryMan dm, DeliveryPayment payment) {
        this.type = Type.WITHDRAW;
        this.amount = payment.getAmount();
        this.id = payment.getId();
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

    
     
    
    
}
