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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class RecruitmentAndSelectionController implements Initializable {

    @FXML
    private TextField nameTextFeild;
    @FXML
    private TextField ContactInfo;
    @FXML
    private ComboBox<String> PositonComboBox;
    @FXML
    private DatePicker assignedDate;
    @FXML
    private ComboBox<String> assingedbyhrComboBox;
    @FXML
    private ComboBox<String> contactinformationCombox;
    @FXML
    private TextField aaplicantIDTextfeild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AssignedEmployeeOnClick(ActionEvent event) {
    }
    
}
