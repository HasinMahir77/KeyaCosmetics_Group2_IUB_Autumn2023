/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class OutsidersAttendanceController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> reasonComboBox;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private ComboBox<String> employeeComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField checkInTextField;
    @FXML
    private TextArea TextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                reasonComboBox.getItems().addAll("Inspection", "Supply","Cleaning", "Others");
        employeeComboBox.getItems().addAll("Inspector", "Supplier","Cleaner", "Others");
        datePicker.setValue(LocalDate.now());
        String checkInTime = ClockUtil.getCurrentTimeString();
        checkInTextField.setText(checkInTime);
    }    

    @FXML
    private void submitToHrOnClick(ActionEvent event){
        String name = nameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String profession = employeeComboBox.getValue();
        String reason = reasonComboBox.getValue();
        LocalDate date = datePicker.getValue();
        String checkInTime = checkInTextField.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = date.format(dateFormatter);
        
        if (date.isAfter(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Date cannot be in the future.");
            alert.showAndWait();
            return;
        }else if (date.isBefore(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Date cannot be in the past.");
            alert.showAndWait();
            return;
        }
        
        String fileName = "OutsidersAttendance_.bin";
        
        NonEmployeeAttendance items = new NonEmployeeAttendance(name, phoneNumber, profession, reason, date, checkInTime);
        boolean addStatus = Receptionist.addNewOutsiderAttendance(items, fileName);
        if (addStatus) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Attendance Added Successfully!");
                a.showAndWait();
        } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Oops, something went wrong");
                a.showAndWait();
        }
    }

    @FXML
    private void loadInformationButtonOnClick(ActionEvent event) {
                String name = nameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String profession = employeeComboBox.getValue();
        String reason = reasonComboBox.getValue();
        LocalDate date = datePicker.getValue();
        String checkInTime = checkInTextField.getText();
        NonEmployeeAttendance items = new NonEmployeeAttendance(name, phoneNumber, profession, reason, date, checkInTime);
        String displayText = items.generateDisplayText();
        TextArea.clear();
        TextArea.appendText(displayText);
    
    }
    
}
