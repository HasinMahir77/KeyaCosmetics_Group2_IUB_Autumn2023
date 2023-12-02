/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import static Borhan_Islam.Payroll.savePayrollRecord;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class PayrollFXMLController implements Initializable {

    @FXML
    private TextField employeeText;
    @FXML
    private TextField basicSalaryText;
    @FXML
    private TextField bonusText;
    @FXML
    private ComboBox<String> bonusTypeCombo;
    @FXML
    private TextField deductionsText;
    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private Button saveRecordsFXID;
    @FXML
    private Button seePayrollFXID;
    @FXML
    private Button calculateFXID;
    @FXML
    private Label calculationLabel;
    @FXML
    private ComboBox<String> desigCombo;
    @FXML
    private Label successfulLabel;

    /**
     * Initializes the controller class.
     */
    Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveRecordsFXID.setDisable(true);        
        seePayrollFXID.setDisable(false);        
        calculateFXID.setDisable(false);  
        String[] bonustype = {"Festival", "New Year"};        
        String[] desigs = {"HR","Product Manager", "Production Manager","Accountant","Deliveryman","Affiliate Marketer","Receptionist"};    
        bonusTypeCombo.getItems().addAll(bonustype);
        desigCombo.getItems().addAll(desigs);
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
    }

    @FXML
    private void calculateButton(ActionEvent event) {
        if (!validateInputFields()) {
                    return;
                }                
        try {
            float basicSalary = Float.parseFloat(basicSalaryText.getText());
            float bonus = Float.parseFloat(bonusText.getText());
            float deductions = Float.parseFloat(deductionsText.getText());

            float calculated = basicSalary + bonus - deductions;
            calculationLabel.setText(Float.toString(calculated));

            saveRecordsFXID.setDisable(false);
            calculateFXID.setDisable(true);
        } catch (NumberFormatException e) {
            showErrorAlert("Invalid input in Basic Salary, Bonus, or Deductions.");
        }
    }

    @FXML
    private void saveRecordsButton(ActionEvent event) {                       
        String name = employeeText.getText();
        String desig =  desigCombo.getValue();
        Float salary= Float.valueOf(basicSalaryText.getText());
        Float bonus = Float.valueOf(bonusText.getText());
        String bonustype= bonusTypeCombo.getValue();
        Float deductions=Float.valueOf(deductionsText.getText());
        LocalDate paymentdate= paymentDatePicker.getValue();
        Float netsalary = Float.valueOf(calculationLabel.getText());
                    
        if (name == null || desig == null || salary == null || bonus == null || bonustype == null
                || deductions == null || paymentdate == null || netsalary == null) {
            showErrorAlert("Please fill in all the required fields.");
            return;
        }
        Payroll payroll = new Payroll();
//        payroll.setName(name);
//        payroll.setDesig(desig);
//        payroll.setSalary(salary);
//        payroll.setBonus(bonus);
//        payroll.setBonustype(bonustype);
//        payroll.setDeductions(deductions);
//        payroll.setPaymentdate(paymentdate);
//        payroll.setNetsalary(netsalary);
            if (showConfirmationAlert("Are you sure you want to add this record?")) {

                Payroll.savePayrollRecord(name, desig, salary, bonus, bonustype, deductions, paymentdate, netsalary);
                payroll.display();                
                
                saveRecordsFXID.setDisable(true);               
                calculateFXID.setDisable(false);   
                showSuccessAlert("Record added successfully.");
            }         


    }    

    @FXML
    private void seePayrollButton(ActionEvent event) throws IOException {
        stage = new Stage();
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("SeePayrollRecordsFXML.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        stage.setScene(scene2);
        stage.setTitle("Keya Cosmetics: Payroll List");
        stage.show();
           
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
    private boolean validateInputFields() {
        try {
            int basicsalary = Integer.parseInt(basicSalaryText.getText());
            int deduction = Integer.parseInt(deductionsText.getText());

            if (basicsalary <= 20000 || basicsalary >= 500000) {
                showErrorAlert("Basic salary must be between 20,000 and 5,00,000.");
                return false;
            }

            if (deduction < 0 || deduction > 15000) {
                showErrorAlert("Deductions must be between 0 and 15,000.");
                return false;
            }
            
            return true;
        } catch (NumberFormatException e) {
            showErrorAlert("Invalid input in Basic Salary or Deductions.");
            return false;
        }
    }
}