/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class ViewOutsiderAttendController implements Initializable {

    @FXML
    private TableView<NonEmployeeAttendance> t1;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> namecol;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> reasonCol;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> employeeTypeCol;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> timeCol;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> DateCol;
    @FXML
    private TableColumn<NonEmployeeAttendance, String> ContactCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        employeeTypeCol.setCellValueFactory(new PropertyValueFactory<>("profession"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("checkInTime"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        ContactCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }    

    @FXML
    private void SaveAsPDFonCLick(ActionEvent event) {
    }

    @FXML
    private void LosadInfoOnClk(ActionEvent event) {        
        ArrayList<NonEmployeeAttendance> nonEmployeeAttendance = Receptionist.readVisaApplicationsFromFile("OutsidersAttendance_.bin");
        ObservableList<NonEmployeeAttendance> NonEmployeeAttendanceList = FXCollections.observableArrayList(nonEmployeeAttendance);
        t1.setItems(NonEmployeeAttendanceList);
        
    }

    @FXML
    private void FormatBinFile(ActionEvent event) {
    }
    
}
