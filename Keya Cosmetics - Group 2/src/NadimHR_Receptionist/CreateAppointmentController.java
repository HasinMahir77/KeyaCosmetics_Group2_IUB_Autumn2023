/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class CreateAppointmentController implements Initializable {

    @FXML
    private Button createButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> CreateappointmentomboBox;
    @FXML
    private TextField ReasoneTextField;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        CreateappointmentomboBox.getItems().addAll("HR","Accountant","Product manager"," Production manager", "Affillait marketer");
        // TODO
    }    

    @FXML
    private void createButton(ActionEvent event) {
       /** String name = nameTextField.getText();     
        int phoneNumber = Integer.parseInt(numberTextField.getText());
        LocalDate date = datePicker.getValue();
        String appoinmentWith = appoinmentWithComboBox.getValue();
        String purpose = purposeTextField.getText();
        
 
        if (appoinmentWith == "Lawyer") {
            Appointment newAppointment = new Appointment(name, phoneNumber, date, appoinmentWith, purpose);
            boolean addStatus = Receptionist.addNewAppointment(newAppointment, "Lawyer Appointment.bin");

            if (addStatus) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("New Apointment Added Successfully!");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Oops, something went wrong");
                a.showAndWait();
            }
            } else{
                Appointment newAppointment = new Appointment(name, phoneNumber, date, appoinmentWith, purpose);
                boolean addStatus = Receptionist.addNewAppointment(newAppointment, "Consultant Appointment.bin");

                if (addStatus) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("New Apointment Added Successfully!");
                a.showAndWait();
                } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Oops, something went wrong");
                a.showAndWait();
                }
        }**/
    }

    @FXML
    private void applyButton(ActionEvent event) {
    }
    
}
