/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import mainpkg.ObjectOutputStreamA;

/**
 *
 * @author hasin
 */
public class Order implements Serializable,Reviewable {
    
    private static Stage stage;
    
    public enum Status{PENDING,OUT_FOR_DELIVERY,DELIVERED,INITIATED_RETURN,OUT_FOR_RETURN,RETURNED,CANCELED};
    
    private Review review;
    private Status status;
    private String customerName,customerUserName,deliveryManUserName,deliveryManName,id,address;
    private Cart cart;
    private float price;
    private  LocalDate date;
    private LocalTime time;
    
    public Order(Customer customer) {
        this.customerUserName = customer.getUsername();
        this.customerName = customer.getFirstName()+" "+customer.getLastName();
        this.address = customer.getAddress();
        this.deliveryManName = null;
        this.deliveryManUserName = null;
        this.status = Order.Status.PENDING;
        this.cart = customer.getCart();
        this.price = cart.getPrice();
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.id = "OID"+this.time.toString()+this.date.toString();
        this.review = null;
        customer.getOrderIdList().add(this.id);
    }
    

    @Override
    public void addReview(String sender) {
        Review r = new Review();
        r.setSender(sender);
        r.setSubject(this.getId());
        boolean success = r.takeReview();
        if (success){
            this.review = r;
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Review saved");
            a.showAndWait();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR,"Failed to save review");
            a.showAndWait();
        }
    }
    
    public Status getStatus() {
        return status;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public String getDeliveryManUserName() {
        return deliveryManUserName;
    }

    public String getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public void setDeliveryManUserName(String deliveryManUserName) {
        this.deliveryManUserName = deliveryManUserName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public float getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    public static Stage getStage() {
        return Order.stage;
    }
    
    
    public void saveInstance(){
        Order target = null;
        System.out.println("Save instance called");
        File userFile = new File("OrderList.bin");
        ArrayList<Order> orderList = Order.getOrderList();
        //Removing current user
        for(Order c: orderList){
            if (c.getId().equals(this.getId())){
                target = c;
            }
        }
        orderList.remove(target);
        //Clearing file
        try{
            new FileInputStream(userFile).close();
        } catch(Exception e){System.out.println(e.toString()+"From order.saveInstance()");}
        
        //Writing current user
        try(FileOutputStream fos = new FileOutputStream(userFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(this);
        }
        catch(Exception e){System.out.println(e.toString()+" From order saveinstance");}
        //Writing other users
        try(FileOutputStream fos = new FileOutputStream(userFile,true);
                ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
            for (Order c: orderList){
                oos.writeObject(c);
            }
        }
        catch(Exception e){System.out.println(e.toString()+" From order.saveinstance()");} 
        
        
    }
    
    public static ArrayList<Order> getOrderList(){
        if (new File("OrderList.bin").exists()){
            
        ArrayList<Order> orderList = new ArrayList<Order>();
        //Reading file
        try(FileInputStream fis = new FileInputStream("OrderList.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);){
            while(true){
                orderList.add((Order)ois.readObject());}
        }
        catch(EOFException e){System.out.println("OrderList.bin file reading complete");}
        catch(Exception e){e.printStackTrace(System.out);}
        // Arraylist of Customers made.
        return orderList;
        }
        else {
            System.out.println("OrderFile not found. getOrderList() called.");
            return new ArrayList<Order>();
        }
    }
    
    public void viewCart() throws IOException{
        Order.stage = new Stage();
        Order.stage.setUserData(this);
        Parent root = FXMLLoader.load(getClass().getResource("ViewCart.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Order details");
        
        
        stage.show();
          
    }
    public void viewDetails() throws IOException{
        Order.stage = new Stage();
        Order.stage.setUserData(this);
        Parent root = FXMLLoader.load(getClass().getResource("ViewOrderDetail.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Order details");
        
        
        stage.show();
          
    }

    public Review getReview() {
        return review;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryManName() {
        return deliveryManName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }
    public static Order getOrder(String id){
        ArrayList<Order> orderList = Order.getOrderList();
        
        for (Order order: orderList){
            if (order.getId().equals(id)){
                return order;
            }
        }
        return null; //Order not found(Shouldn't happen without incorrect id)
    }
    public void setDeliveryMan(DeliveryMan dm){
        this.deliveryManName = dm.getFullName();
        this.deliveryManUserName = dm.getUsername();
    }
    

}
