/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

/**
 *
 * @author hasin
 */
public class Review {
    private String sender,subject, review;

    public Review() {
        this.sender = null;
        this.review = null;
        this.subject = null;
    }
    public Review(User sender) {
        this.sender = sender.getUsername();
        this.review = null;
        this.subject = null;
    }
    public Review(User sender,String subject) {
        this.sender = sender.getUsername();
        this.review = null;
        this.subject = null;
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


    public void setReview(String review) {
        this.review = review;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void takeReview(User user){
        
    }
    
    
    
}
