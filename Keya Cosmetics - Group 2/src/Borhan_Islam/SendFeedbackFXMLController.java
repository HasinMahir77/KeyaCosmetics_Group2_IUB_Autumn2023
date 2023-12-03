/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import NadimHR_Receptionist.FeedbackToHR;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class SendFeedbackFXMLController implements Initializable {

    @FXML
    private TextField nameText;
    @FXML
    private RadioButton concernRadio;
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private TextField emailText;
    @FXML
    private RadioButton suggestionRadio;
    @FXML
    private RadioButton praiseRadio;

    private ObservableList<FeedbackToHR> feedbackList = FXCollections.observableArrayList();

    private FeedbackToHR feedbackToHR  = new FeedbackToHR();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard();     
    } 

    @FXML
    private void sendButton(ActionEvent event) {
        String feedbackType = "";
                if (concernRadio.isSelected()) {
                    feedbackType = "Concern";
                } else if (suggestionRadio.isSelected()) {
                    feedbackType = "Suggestion";
                } else if (praiseRadio.isSelected()) {
                    feedbackType = "Praise";
                } else {
                    showErrorAlert("Please select a feedback type.");
                    return;
                }

                String name = nameText.getText().trim();
                String email = emailText.getText().trim();
                String feedback = feedbackTextArea.getText().trim();

                if (name.isEmpty() || email.isEmpty() || feedback.isEmpty()) {
                    showErrorAlert("Please fill in all fields.");
                    return;
                }

   
                feedbackToHR.submitFeedbackOnClick(feedbackType, name, email, feedback, feedbackList);

                clearFields();
                showInfoAlert("Feedback submitted successfully.");
                
    }
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void clearFields() {
        nameText.clear();
        emailText.clear();
        feedbackTextArea.clear();
        concernRadio.setSelected(false);
        suggestionRadio.setSelected(false);
        praiseRadio.setSelected(false);

    
    }
}
