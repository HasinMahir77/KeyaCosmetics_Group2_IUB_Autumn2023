/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveRecordsFXID.setDisable(true);        
        seePayrollFXID.setDisable(true);        
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
        float calculated = Float.parseFloat(basicSalaryText.getText())+ Float.parseFloat(bonusText.getText())- 
                Float.parseFloat(deductionsText.getText());
        calculationLabel.setText(Float.toString(calculated));
        saveRecordsFXID.setDisable(false);        
        seePayrollFXID.setDisable(false);        
        calculateFXID.setDisable(true);           
    }


    @FXML
    private void saveRecordsButton(ActionEvent event) {             
        Payroll payroll = new Payroll(
                    employeeText.getText(),
                    desigCombo.getValue(),
                    Float.parseFloat(basicSalaryText.getText()),
                    Float.parseFloat(bonusText.getText()),
                    bonusTypeCombo.getValue(),
                    Float.parseFloat(deductionsText.getText()),
                    paymentDatePicker.getValue());
        employeeText.setText(null);    desigCombo.setValue(null);  basicSalaryText.setText(null);  bonusText.setText(null);
        bonusTypeCombo.setValue(null); deductionsText.setText(null); paymentDatePicker.setValue(null); 
        payroll.display();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("payroll.bin", true)
            );
            oos.writeObject(payroll);
            successfulLabel.setText("Saved Successfully!");         
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void seePayrollButton(ActionEvent event) {
 //       Payroll p = new Payroll();
 //       p.setSender(current.getUsername());
 //       p.seePayroll(p);//This opens the review popup       
    }
}
