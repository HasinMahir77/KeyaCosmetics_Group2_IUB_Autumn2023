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
    
    private float amount;
    private boolean done;

    public DeliveryPayment( float amount) {
        this.amount = amount;
        this.done = false;
    }
    


    public float getAmount() {
        return amount;
    }


    public boolean isDone() {
        return done;
    }


    public void setAmount(float amount) {
        this.amount = amount;
    }


    public void setDone() {
        this.done = true;
    }
    
    @Override
    public String toString(){
        return "Payment: "+Float.toString(this.amount)+" BDT";
    }

    
     
    
    
}
