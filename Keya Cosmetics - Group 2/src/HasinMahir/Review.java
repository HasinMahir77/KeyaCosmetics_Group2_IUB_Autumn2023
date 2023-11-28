/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 *
 * @author hasin
 */
public class Review implements Serializable {
    private String sender,subject, review;
    private int rating;
    private static Stage stage;

    public Review() {
        this.sender = null;
        this.review = null;
        this.subject = null;
        this.rating = -1;
    }
    public Review(User sender) {
        this.sender = sender.getUsername();
        this.review = null;
        this.subject = null;
        this.rating = -1;
    }
    public Review(User sender,String subject) {
        this.sender = sender.getUsername();
        this.review = null;
        this.subject = null;
        this.rating = -1;
    }

    public String getSender() {
        return sender;
    }

    public String getReview() {
        return review;
    }
    public String getSubject() {
        return subject;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public void setReview(String review) {
        this.review = review;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRating() {
        return rating;
    }

    public static Stage getStage() {
        return stage;
    }
    
    
    public boolean takeReview(){
        try {
            //Set the userdata to takereview scene
            //this.subject = product.getName();
            //Setting up the new stage and passing data
            MainpkgSS ss = new MainpkgSS();
            stage = new Stage();
            stage.setUserData(this);
            //Scene popping
            Parent root = FXMLLoader.load(getClass().getResource("TakeReview.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Keya Cosmetics: Login");
            stage.showAndWait();
            
            //Popup closed
            Review review = (Review) stage.getUserData();
            if (review.getRating()==-1){//Taking review failed
                return false;
            }
            else{
                this.setRating(review.getRating());
                this.setReview(review.getReview());
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
    public boolean takeReview(User product) throws IOException{
        //Set the userdata to takereview scene
        this.subject = product.getUsername();
        //Setting up the new stage and passing data
        MainpkgSS ss = new MainpkgSS();
        stage = new Stage();
        stage.setUserData(this);
        //Scene popping 
        Parent root = FXMLLoader.load(getClass().getResource("TakeReview.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Review");
        Main.getMainStage().getScene().getRoot().setDisable(true);
        stage.showAndWait();
        
        //Popup closed
        Review review = (Review) stage.getUserData();
        if (review.getRating()==-1){//Taking review failed
            Main.getMainStage().getScene().getRoot().setDisable(false);
            return false;
        }
        else{
            this.setRating(review.getRating());
            this.setReview(review.getReview());
            Main.getMainStage().getScene().getRoot().setDisable(false);
            return true;
        }
    }
    
    
    
}
