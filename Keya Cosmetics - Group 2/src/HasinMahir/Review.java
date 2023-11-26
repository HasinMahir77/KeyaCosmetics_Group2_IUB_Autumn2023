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
    String sender, receiver,subject, review;

    public Review() {
        this.sender = null;
        this.receiver = null;
        this.review = null;
        this.subject = null;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
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

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setReview(String review) {
        this.review = review;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    
}
