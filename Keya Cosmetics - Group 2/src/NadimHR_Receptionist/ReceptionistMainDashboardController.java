/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class ReceptionistMainDashboardController implements Initializable {

    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void employeeattendenceOnclick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Employee attendance.fxml"));
         borderpane.setCenter(root);
    }

    @FXML
    private void OutsidersattendenceOnclick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Outsiders attendance.fxml"));
         borderpane.setCenter(root);
    }

    @FXML
    private void EmployeeovertimeOnclick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Employee attendance.fxml"));
         borderpane.setCenter(root);
    }

    @FXML
    private void createappointmentswithstaffsOnclick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Create appointment.fxml"));
         borderpane.setCenter(root);
    }

    @FXML
    private void vieewWorkPolOnClick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("WorkPlacePolicies.fxml"));
         borderpane.setCenter(root);
    }
    @FXML
    private void sendfeedOnClick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("SendFeedbackToHR.fxml"));
         borderpane.setCenter(root);
    }
}
