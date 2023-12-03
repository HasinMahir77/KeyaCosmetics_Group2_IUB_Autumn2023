/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nadimul
 */
public class FeedbackToHR implements Serializable {
    
    
    private String feedbackType;
    private String name;
    private String email;
    private String feedback;

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public FeedbackToHR() {
    }

     private final String feedbackFileName = "UserFeedback.bin";

    private static class SerializableFeedbackList implements Serializable {
        private List<FeedbackToHR> feedbackList;

        public SerializableFeedbackList(List<FeedbackToHR> feedbackList) {
            this.feedbackList = feedbackList;
        }

        public List<FeedbackToHR> getFeedbackList() {
            return feedbackList;
        }
    }

    @Override
    public String toString() {
        return "FeedbackToHR{" + "feedbackType=" + feedbackType + ", name=" + name + ", email=" + email + ", feedback=" + feedback + ", feedbackFileName=" + feedbackFileName + '}';
    }

    public FeedbackToHR(String feedbackType, String name, String email, String feedback) {
        this.feedbackType = feedbackType;
        this.name = name;
        this.email = email;
        this.feedback = feedback;
    }

    public void submitFeedbackOnClick(String feedbackType, String name, String email, String feedback, ObservableList<FeedbackToHR> feedbackList) {
        FeedbackToHR empFeedback = new FeedbackToHR(feedbackType, name, email, feedback);
        feedbackList.add(empFeedback);

        saveFeedbackToFile(feedbackList);
    }

    private void saveFeedbackToFile(ObservableList<FeedbackToHR> feedbackList) {
        SerializableFeedbackList serializableFeedbackList = new SerializableFeedbackList(new ArrayList<>(feedbackList));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(feedbackFileName))) {
            oos.writeObject(serializableFeedbackList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final long serialVersionUID = -3387450580070637973L; // Keep this consistent

    public static ObservableList<FeedbackToHR> loadFeedbackFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserFeedback.bin"))) {
            SerializableFeedbackList serializableFeedbackList = (SerializableFeedbackList) ois.readObject();
            List<FeedbackToHR> feedbackList = serializableFeedbackList.getFeedbackList();
            return FXCollections.observableArrayList(feedbackList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
    
}
