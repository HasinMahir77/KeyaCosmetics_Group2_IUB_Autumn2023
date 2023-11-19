/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class ExpenseAndReimbursementController implements Initializable {

    @FXML
    private TextField employeeNameField;
    @FXML
    private TextField expenseAmountField;
    @FXML
    private RadioButton bankTransferRadioButton;
    @FXML
    private RadioButton checkRadioButton;
    @FXML
    private ComboBox<String> ExpenseDescriptionComboBox;
    @FXML
    private RadioButton mobileBankingRadioButton;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private DatePicker reimbursementDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        designationComboBox.getItems().addAll("Receptionist", "HR");
        

        designationComboBox.setOnAction(event -> {
             String selectedDesignation = designationComboBox.getValue();
             if (selectedDesignation != null) {
                 switch (selectedDesignation) {
                     case "Receptionist":
                         ExpenseDescriptionComboBox.getItems().setAll(
                             "Office Supplies", "Client Services", "Telephone Expenses");
                         break;
                     case "HR":
                         ExpenseDescriptionComboBox.getItems().setAll(
                             "Printing and Copying", "Document Management Tools", "Shipping Costs");
                         break;
                     default:
                         ExpenseDescriptionComboBox.getItems().clear();
                         break;
                 }
             }
         });

         ToggleGroup paymentMethodToggleGroup = new ToggleGroup();
         bankTransferRadioButton.setToggleGroup(paymentMethodToggleGroup);
         checkRadioButton.setToggleGroup(paymentMethodToggleGroup);
         mobileBankingRadioButton.setToggleGroup(paymentMethodToggleGroup);
     
    }   

    @FXML
    private void downLoadReceiptAsPDF(ActionEvent event) {
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        String employeeName = employeeNameField.getText();
        String expenseAmountText = expenseAmountField.getText();
        LocalDate reimbursementDateValue = reimbursementDate.getValue();
        String designation = designationComboBox.getValue();
        String paymentMethod = getSelectedPaymentMethod();
        String expenseDistribution = ExpenseDescriptionComboBox.getValue();

        if (employeeName.isEmpty() || expenseAmountText.isEmpty() || reimbursementDateValue == null ||
                designation == null || paymentMethod.isEmpty() || expenseDistribution == null) {
            showAlert("Validation Error", "Please fill in all fields and select a payment method.", Alert.AlertType.ERROR);
            return;
        }

        Float expenseAmount;
        try {
            expenseAmount = Float.parseFloat(expenseAmountText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Invalid expense amount format.", Alert.AlertType.ERROR);
            return;
        }

        ReimbursementRequestRecord reimbursement = new ReimbursementRequestRecord(employeeName, expenseAmount, reimbursementDateValue,
                designation, paymentMethod, expenseDistribution);

        ArrayList<ReimbursementRequestRecord> existingReimbursements = Hr.loadReimbursements("Reimbursement.bin");
        existingReimbursements.add(reimbursement);

        ObservableList<ReimbursementRequestRecord> observableReimbursements = FXCollections.observableArrayList(existingReimbursements);

        boolean success = Hr.writeReimbursements(observableReimbursements, "Reimbursement.bin");

        if (success) {
            showAlert("Success", "Reimbursement submitted successfully.", Alert.AlertType.INFORMATION);
            clearFields();
        } else {
            showAlert("Error", "Failed to submit reimbursement.", Alert.AlertType.ERROR);
        }
    }

    private String getSelectedPaymentMethod() {
        if (bankTransferRadioButton.isSelected()) {
            return "Bank Transfer";
        } else if (checkRadioButton.isSelected()) {
            return "Check";
        } else if (mobileBankingRadioButton.isSelected()) {
            return "Mobile Banking";
        }
        return null;
    
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        employeeNameField.clear();
        expenseAmountField.clear();
        bankTransferRadioButton.setSelected(false);
        checkRadioButton.setSelected(false);
        mobileBankingRadioButton.setSelected(false);
        ExpenseDescriptionComboBox.getSelectionModel().clearSelection();
        reimbursementDate.setValue(null);
        designationComboBox.getSelectionModel().clearSelection();
    }

    
    
    
}
