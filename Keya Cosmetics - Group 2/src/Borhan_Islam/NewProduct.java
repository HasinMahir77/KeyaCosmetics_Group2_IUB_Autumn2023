/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.User;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 88019
 */
public class NewProduct extends User implements Serializable{
    private String productName;
    private String category;
    private Float cost;
    private Float priceExcl;
    private Float vat;
    private Float priceIncl;
    private String description;

    public NewProduct(String productName, String category, Float cost, Float priceExcl, Float vat, Float priceIncl, String description) {
        this.productName = productName;
        this.category = category;
        this.cost = cost;
        this.priceExcl = priceExcl;
        this.vat = vat;
        this.priceIncl = priceIncl;
        this.description = description;
    }

    public NewProduct(){
        
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPriceExcl() {
        return priceExcl;
    }

    public void setPriceExcl(Float priceExcl) {
        this.priceExcl = priceExcl;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getPriceIncl() {
        return priceIncl;
    }

    public void setPriceIncl(Float priceIncl) {
        this.priceIncl = priceIncl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NewProduct{" + "productName=" + productName + ", category=" +
                category + ", cost=" + cost + ", priceExcl=" + priceExcl + ","
                + " vat=" + vat + ", priceIncl=" + priceIncl + ", description="
                + description + '}';
    }
    
    public void display(){
        System.out.println("NewProduct{" + "productName=" + productName + ", category=" + 
                category + ", cost=" + cost + ", priceExcl=" + priceExcl +
                ", vat=" + vat + ", priceIncl=" + priceIncl + ", description=" +
                description + '}');
    }
    
    private static final String NEW_PRODCUT_FILE_PATH = "NewProductIdea.bin";
    
    public static void saveNewProductRecord(String productName, String category, Float cost, Float priceExcl, Float vat, Float priceIncl, String description) {
        NewProduct newProductRecord = new NewProduct(productName, category, cost, priceExcl, vat, priceIncl, description);
        List<NewProduct> existingRecords = loadNewProductRecords();
        existingRecords.add(newProductRecord);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NEW_PRODCUT_FILE_PATH))) {
            for (NewProduct newproduct : existingRecords) {
                oos.writeObject(newproduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<NewProduct> loadNewProductRecords() {
        List<NewProduct> newProductRecords = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NEW_PRODCUT_FILE_PATH))) {
            while (true) {
                try {
                    NewProduct newproduct = (NewProduct) ois.readObject();
                    newProductRecords.add(newproduct);
                } catch (EOFException e) {
                    break; // Exit loop when EOF is reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newProductRecords;
    }   


}
