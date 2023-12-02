/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import HasinMahir.DeliveryPayment.Type;
import HasinMahir.Order.Status;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.ObjectOutputStreamA;

/**
 *
 * @author hasin
 */
public class DeliveryMan extends User {
    
    ArrayList<DeliveryPayment> paymentDepositList;
    ArrayList<DeliveryPayment> paymentWithdrawList;
    
    
    public DeliveryMan(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
        this.phone = phone;
        this.del = false;
        this.doj = LocalDate.now();
        this.nid = "";
        this.paymentDepositList =  new ArrayList<DeliveryPayment>();
        this.paymentWithdrawList =  new ArrayList<DeliveryPayment>();
    }
    
    public void saveInstance(){
        DeliveryMan target = null;
        System.out.println("DM Save instance called");
        File userFile = new File("DeliveryManList.bin");
        ArrayList<DeliveryMan> deliveryManList = DeliveryMan.getDeliveryManList();
        //Removing current user
        for(DeliveryMan c: deliveryManList){
            if (c.getUsername().equals(this.getUsername())){
                target = c;
            }
        }
        deliveryManList.remove(target);
        //Clearing file
        try{
            new FileInputStream(userFile).close();
        } catch(Exception e){System.out.println(e.toString()+"From DM.saveInstance()");}
        
        //Writing current user
        try(FileOutputStream fos = new FileOutputStream(userFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(this);
        }
        catch(Exception e){System.out.println(e.toString()+" From DM saveinstance");}
        //Writing other users
        try(FileOutputStream fos = new FileOutputStream(userFile,true);
                ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
            for (DeliveryMan dm: deliveryManList){
                oos.writeObject(dm);
            }
        }
        catch(Exception e){System.out.println(e.toString()+" From DM saveinstance");}
    }
    
    public static ArrayList<DeliveryMan> getDeliveryManList(){
        if (new File("DeliveryManList.bin").exists()){
            
        ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
        //Reading file
        try(FileInputStream fis = new FileInputStream("DeliveryManList.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);){
            while(true){
                deliveryManList.add((DeliveryMan)ois.readObject());}
        }
        catch(EOFException e){System.out.println("DeliveryList.bin file reading complete");}
        catch(Exception e){e.printStackTrace(System.out);}
        // Arraylist of DM made.
        return deliveryManList;
        }
        else {
            System.out.println("DM file not found. getDMList() called.");
            return null;
        }
    }
    
    public void delete(){
        if (this.isDel()){
            System.out.println("Acoount is already deleted");
        }
        else{
            this.del = true;
            this.username+=".deleted";
        }
    }
    public void recover(){
        if (this.isDel()){
            this.del = false;
            this.username=".deleted";
        }
        else{
            this.del = true;
            this.username = this.username.substring(0,this.username.length()-8);
        }
    }
    public void acceptOrder(Order order){
        if (order.getStatus()==Status.PENDING){
            
            order.setDeliveryMan(this);
            order.setStatus(Status.OUT_FOR_DELIVERY);
            
            order.saveInstance();
        }
        else if (order.getStatus()==Status.INITIATED_RETURN){
            order.setDeliveryMan(this);
            order.setStatus(Status.OUT_FOR_RETURN);
            
            order.saveInstance();
        }
    }
    public void deliverOrder(Order order){
        if (order.getStatus().equals(Status.OUT_FOR_DELIVERY)){
            
            order.setStatus(Status.DELIVERED);
            this.paymentDepositList.add(new DeliveryPayment(Type.DEPOSIT,order.getId(),order.getPrice()));
            order.saveInstance();
            this.saveInstance();
        }
        else if(order.getStatus()==Status.OUT_FOR_RETURN){
            order.setStatus(Status.RETURNED);
            this.paymentWithdrawList.add(new DeliveryPayment(Type.WITHDRAW,order.getId(),100));
            order.saveInstance();
            this.saveInstance();
        }
    }
    public void depositPayment(DeliveryPayment payment){
        for (DeliveryPayment p: this.paymentDepositList){
            if (p.getId().equals(payment.getId()) && !p.isDone()){
                p.setDone();
                this.balance -= p.getAmount();
            }
        }
    }
    public void withdrawPayment(DeliveryPayment payment){
        for (DeliveryPayment p: this.paymentWithdrawList){
            if (p.getId().equals(payment.getId()) && !p.isDone()){
                p.setDone();
                this.balance += p.getAmount();
            }
        }
    }
    
    public ArrayList<DeliveryPayment> getPaymentDepositList(){
        return this.paymentDepositList;
    }
    public ArrayList<DeliveryPayment> getPaymentWithdrawList(){
        return this.paymentWithdrawList;
    }
}
