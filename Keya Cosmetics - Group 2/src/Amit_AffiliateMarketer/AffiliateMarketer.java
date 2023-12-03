package Amit_AffiliateMarketer;

import HasinMahir.Product;
import HasinMahir.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AffiliateMarketer extends User implements Serializable {

    public AffiliateMarketer() {
    }

    public AffiliateMarketer(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
    }

    public AffiliateMarketer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    
    public static void AddNewReview(ProductReview pr) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("ProductReview.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(pr);

        } catch (IOException ex) {
            Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<ProductReview> GetProductReview(ProductReview pr) {
        ObjectInputStream ois = null;
        ObservableList <ProductReview> list = FXCollections.observableArrayList();
        try {
             ProductReview c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (ProductReview) ois.readObject();
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
    
    public static String generateCouponCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder couponCode = new StringBuilder();
        for (int i = 0; i < 5; i ++) {
            int index = random.nextInt(characters.length());
            couponCode.append(characters.charAt(index));
        }
        return couponCode.toString();
    }
    
    public static void AddNewCouponCode(CouponCode c) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("CouponCode.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void AddNewInfluencer(Influencer inf) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Influencer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(inf);

        } catch (IOException ex) {
            Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<Influencer> GetInfluencerList() {
        ObjectInputStream ois = null;
        ObservableList <Influencer> list = FXCollections.observableArrayList();
        try {
             Influencer c;
             ois = new ObjectInputStream(new FileInputStream("Influencer.bin"));
             
            while(true){
                c = (Influencer) ois.readObject();
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
    
    public static void AddNewCampaign(Campaign cmp) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Campaign.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(cmp);

        } catch (IOException ex) {
            Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AffiliateMarketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ObservableList<Campaign> GetCampaignList() {
        ObjectInputStream ois = null;
        ObservableList <Campaign> list = FXCollections.observableArrayList();
        try {
             Campaign c;
             ois = new ObjectInputStream(new FileInputStream("Campaign.bin"));
             
            while(true){
                c = (Campaign) ois.readObject();
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
    
}
