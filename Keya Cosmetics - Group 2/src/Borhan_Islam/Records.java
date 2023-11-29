/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Cart;
import HasinMahir.Customer;
import HasinMahir.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.ActionEvent;

/**
 *
 * @author 88019
 */
public class Records extends User implements Serializable {
    public enum Status{PENDING,OUT_FOR_DELIVERY,DELIVERED,RETURNED,CANCELED};
    
    Status status;
    String customerUserName,deliveryManUserName,id;
    Cart cart;
    float price;
    LocalDate date;
    LocalTime time;
    
//    public Records(Status status, String customerUserName, float price,
//            LocalTime time, LocalDate date, String id) {
    public Records(Status status, String customerUserName, float price,
            LocalTime time, LocalDate date, String id){  
        this.customerUserName = customerUserName;
        this.status = status;
        this.price = price;
        this.time = time;
        this.date = date;
        this.id = id;

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
    public void setDeliveryManUserName(String deliveryManUserName) {
        this.deliveryManUserName = deliveryManUserName;
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


    public void setId(String id) {
        this.id = id;
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


    public void setPrice(float price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
  
    
}

