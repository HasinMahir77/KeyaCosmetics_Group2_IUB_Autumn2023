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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ExpenseControlSysFXMLController implements Initializable {

    @FXML
    private ComboBox<String> categoryCombo;
    @FXML
    private TextField expNameText;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea refTextArea;
    @FXML
    private TextField expAmountText;
    @FXML
    private ComboBox<String> payMethodCombo;
    @FXML
    private Button processfxid;
    @FXML
    private Button processfxid1;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] category = {"Utilities","Rent","Salaries","Shipping Costs",
        "Taxes and Licenses", "Marketing and Advertising","Insurance"};
        String[] paymentMethod = {"Mobile Banking","Bank Transfer"};
        categoryCombo.getItems().addAll(category);
        payMethodCombo.getItems().addAll(paymentMethod);
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
    }

    @FXML
    private void checkoutButton(ActionEvent event) throws IOException {
        String name=expNameText.getText();
        String category=categoryCombo.getValue();
        Float amount=Float.valueOf(expAmountText.getText());
        LocalDate date= datePicker.getValue();
        String paymentMethod= payMethodCombo.getValue();
        String reference=refTextArea.getText();  
        if (name == null || category == null || amount == null || date == null || paymentMethod == null || reference == null) {
            showErrorAlert("Please fill in all the required fields.");
            return;
        } 
        if (showConfirmationAlert("Are you sure you want to proceed?")) {
            Expense.saveExpenseRecord(name, category, amount, date, paymentMethod, reference);

//            stage = new Stage();
//            Parent scene2Parent = FXMLLoader.load(getClass().getResource("ExpenseBillFXML.fxml"));
//            Scene scene2 = new Scene(scene2Parent);
//            stage.setScene(scene2);
//            stage.setTitle("Keya Cosmetics: Bill");
//            stage.show();                 
        }
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
