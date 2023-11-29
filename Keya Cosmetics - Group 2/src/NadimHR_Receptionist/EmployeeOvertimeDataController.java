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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeOvertimeDataController implements Initializable {

    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private ComboBox<String> NameComboBox;
    @FXML
    private TextField timeTextField;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private Button LoadInformationButton;
    @FXML
    private TableView<Applicant> TableView;
    @FXML
    private TableColumn<Applicant, String> PositionColumn;
    @FXML
    private TableColumn<Applicant, String> NameColumn;
    @FXML
    private TableColumn<Applicant, Integer> HoursColumn;
    @FXML
    private TableColumn<Applicant, LocalDate> DateColumn;
    @FXML
    private Button SendButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInformationOnClick(ActionEvent event) {
    }

    @FXML
    private void sendInformationOnClick(ActionEvent event) {
    }
    
}
