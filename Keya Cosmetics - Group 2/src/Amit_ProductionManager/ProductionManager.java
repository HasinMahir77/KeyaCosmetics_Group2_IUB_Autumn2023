/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amit_ProductionManager;

import Amit_AffiliateMarketer.AffiliateMarketer;
import Amit_AffiliateMarketer.AppendableObjectOutputStream;
import Amit_AffiliateMarketer.Campaign;
import HasinMahir.Product;
import HasinMahir.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class ProductionManager extends User {

    public ProductionManager(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
    }
    
    
    public static ObservableList<Product> GetProductList() {
        ObjectInputStream ois = null;
        ObservableList <Product> list = FXCollections.observableArrayList();
        try {
             Product c;
             ois = new ObjectInputStream(new FileInputStream("ProductList.bin"));
             
            while(true){
                c = (Product) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void addImprovement(ProductionImprovement pi) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("ProductionImprovement.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(pi);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<Vendors> GetVendorList() {
        ObjectInputStream ois = null;
        ObservableList <Vendors> list = FXCollections.observableArrayList();
        try {
             Vendors c;
             ois = new ObjectInputStream(new FileInputStream("Vendors.bin"));
             
            while(true){
                c = (Vendors) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void addVendors(Vendors v) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Vendors.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(v);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<Machine> GetMachineList() {
        ObjectInputStream ois = null;
        ObservableList <Machine> list = FXCollections.observableArrayList();
        try {
             Machine c;
             ois = new ObjectInputStream(new FileInputStream("Machine.bin"));
             
            while(true){
                c = (Machine) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void addMachine(Machine v) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Machine.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(v);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<String> GetTimeLine() {
        ObjectInputStream ois = null;
        ObservableList <String> list = FXCollections.observableArrayList();
        try {
             String c;
             ois = new ObjectInputStream(new FileInputStream("TimeLine.bin"));
             
            while(true){
                c = (String) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void addTimeLine (String v) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("TimeLine.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(v);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<RepairSchedule> GetRepairScheduleList() {
        ObjectInputStream ois = null;
        ObservableList <RepairSchedule> list = FXCollections.observableArrayList();
        try {
             RepairSchedule c;
             ois = new ObjectInputStream(new FileInputStream("RepairSchedule.bin"));
             
            while(true){
                c = (RepairSchedule) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void addRepairSchedule (RepairSchedule v) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("RepairSchedule.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(v);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
