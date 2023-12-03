/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class AuditReportFXMLController implements Initializable {

    @FXML
    private TextArea detailedReportTextArea;
    @FXML
    private TextField titleTextField;
    @FXML
    private Button sendToHrfxid;
    @FXML
    private Button saveReportfxid;
    @FXML
    private Button savepdffxid;
    @FXML
    private DatePicker datefxid;
    @FXML
    private Button seeAllAuditsfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datefxid.setValue(LocalDate.now());
        sendToHrfxid.setDisable(true);
        savepdffxid.setDisable(true);
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard();          
    }

    @FXML
    private void sendToHrButton(ActionEvent event) {
        if (showConfirmationAlert("Are you sure?")) {
            showSuccessAlert("Report sent to HR!");      
        }
    }
    
    @FXML
    private void saveReportButton(ActionEvent event) {
        String title = titleTextField.getText();
        String detailedReport = detailedReportTextArea.getText();
        LocalDate date=datefxid.getValue();
        
            if (title == null || detailedReport == null || date == null ) {
                showErrorAlert("Please fill in all the required fields.");
                return;
            }   
            if (showConfirmationAlert("Are you sure you want to save this report?")) {

                AuditReport.saveAuditReportRecord(title, detailedReport, date);  
                showSuccessAlert("Report saved successfully.");           
                sendToHrfxid.setDisable(false);
                savepdffxid.setDisable(false);
            }           
                                  
    }

    @FXML
    private void savepdfButton(ActionEvent event) {
    
    }

    @FXML
    private void seeAllAuditsButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.seeAllAuditsButton(); 
    }
    public void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText(message);

        return alert.showAndWait().orElse(null).equals(ButtonType.OK);
    }

    public void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
