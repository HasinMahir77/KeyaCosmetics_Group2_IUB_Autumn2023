/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ExpenseBillFXMLController implements Initializable {

    @FXML
    private Label timeLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label paymentLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label referenceLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Button processfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        timeLabel.setText(formattedTime);
        nameLabel.setText(Expense.loadLatestExpenseRecord().getName());
        categoryLabel.setText(Expense.loadLatestExpenseRecord().getCategory());
        paymentLabel.setText(Expense.loadLatestExpenseRecord().getPaymentMethod());
        referenceLabel.setText(Expense.loadLatestExpenseRecord().getReference());
        amountLabel.setText(Expense.loadLatestExpenseRecord().getAmount().toString());
        dateLabel.setText(Expense.loadLatestExpenseRecord().getDate().toString());
    }    

    @FXML
    private void processButton(ActionEvent event) throws IOException {
//        showSuccessAlert("Processed!");    

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
