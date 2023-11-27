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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class IncomeFXMLController implements Initializable {

    @FXML
    private TextField employeeNameTextField;
    @FXML
    private ComboBox<String> desigsCombo;
    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private ComboBox<String> bonusTypeCombo;
    @FXML
    private TextField basicSalaryTextField;
    @FXML
    private TextField deductionsTextField;
    @FXML
    private TextField bonusTextField;
    @FXML
    private ComboBox<Integer> overtimeHoursCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        overtimeHoursCombo.getItems().addAll(12, 24 ,48, 72, 96, 112);
        desigsCombo.getItems().addAll("HR", "Accountant", "Receptionist", "Delivery Man", 
                                  "Affiliate Marketer","Product Manager","Production Manager");      
        paymentDatePicker.setValue(LocalDate.now());
        bonusTypeCombo.getItems().addAll( "Festival Bonus", "New Year Bonus");

    }    

    @FXML
    private void calculateSalaryAmountButton(ActionEvent event) {
    }

    @FXML
    private void saveRecordsButton(ActionEvent event) {
    }

    @FXML
    private void employeeListMenuButton(ActionEvent event) {
    }

    @FXML
    private void switchToDashboardButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToDashboardButton();          
    }

}
