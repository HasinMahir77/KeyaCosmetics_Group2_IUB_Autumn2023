/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

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
    
    public enum Status{PENDING,OUT_FOR_DELIVERY,DELIVERED,INITIATED_RETURN,RETURNED,CANCELED};
    
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
        File oldCustomerList = new File("OrderList.bin");
        Order order;
        ArrayList<Order> bufferList = new ArrayList<Order>();
        //Collecting all the other users of same type except current user
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                order = (Order)ois.readObject();
                if ( !(order.getId().equals(this.getId())) ) {
                    bufferList.add(order);
                }
            }
        } catch(Exception e) {
            System.out.println("From order.saveInstance() : "+e.toString());
            System.out.println("ArrayList of orders made");
        } 
        // Arraylist of Orders made.
        
        //Rewriting the bin file with the updated customer object.
       
        try{
            FileOutputStream temp = new FileOutputStream(oldCustomerList);
            temp.close(); //Cleared the file
        }catch(Exception e){
            System.out.println(e);
        }
        
        //Writing files
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList);
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(this);
        } catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Only current order written. Other customers next");
        }
        try(FileOutputStream fos = new FileOutputStream(oldCustomerList,true);
        ObjectOutputStream oos = new ObjectOutputStreamA(fos);){
            for(Order c: bufferList){
                    oos.writeObject(c);
                }
        } catch(Exception e){
            System.out.println(e.toString());
        } 
        
        
    }
    
    public static ArrayList<Order> getOrderList(){
        File oldCustomerList = new File("OrderList.bin");
        Order order;
        ArrayList<Order> customerList = new ArrayList<Order>();
        //Collecting all the other users of same type
        try(FileInputStream fis = new FileInputStream(oldCustomerList);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            while(true){
                order = (Order)ois.readObject();
                customerList.add(order);
            }
        } catch(Exception e) {
            System.out.println("From customer.getCustomerList() : "+e.toString());
            System.out.println("ArrayList of customers made");
        } 
        // Arraylist of Orders made.
        return customerList;
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
