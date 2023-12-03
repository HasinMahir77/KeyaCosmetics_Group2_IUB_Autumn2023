/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

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
public class ProductDetails implements Serializable{
    public String name;
    public String category;
    public Float price;
    public Float vat;
    public String details;


    public ProductDetails(String name, String category, Float price, Float vat,String details) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.vat = vat;
        this.details=details;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }
    
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }    

    @Override
    public String toString() {
        return "ProductDetails{" + "name=" + name + ", category=" + category + ", price=" + price + ", vat=" + vat + ", details=" + details + '}';
    }


    private static final String New_PRODUCT_FILE_PATH = "productDetails.bin";
    
    public static void saveProductDetailsRecord(String name, String category, Float price, Float vat, String details) {
        ProductDetails productDetails = new ProductDetails(name, category, price, vat, details);
        List<ProductDetails> existingProducts = loadProductDetailsRecords();
        existingProducts.add(productDetails);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(New_PRODUCT_FILE_PATH))) {
            for (ProductDetails products : existingProducts) {
                oos.writeObject(products);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<ProductDetails> loadProductDetailsRecords() {
        List<ProductDetails> productDetails = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(New_PRODUCT_FILE_PATH))) {
            while (true) {
                try {
                    ProductDetails products = (ProductDetails) ois.readObject();
                    productDetails.add(products);
                } catch (EOFException e) {
                    break; // Exit loop when EOF is reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productDetails;
    } 
    
}
