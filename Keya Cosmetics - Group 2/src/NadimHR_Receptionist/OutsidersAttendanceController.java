/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ComboBox<?> reasonComboBox;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private ComboBox<?> employeeComboBox;
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
    }    

    @FXML
    private void submitToHrOnClick(ActionEvent event) {
    }

    @FXML
    private void loadInformationButtonOnClick(ActionEvent event) {
    }
    
}
