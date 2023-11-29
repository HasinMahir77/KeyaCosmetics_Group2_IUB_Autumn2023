/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
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
    private ComboBox<?> desigCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveRecordsFXID.setDisable(true);        
        seePayrollFXID.setDisable(true);        
        calculateFXID.setDisable(false);        
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
    
    }

    @FXML
    private void seePayrollButton(ActionEvent event) {
    }
}
