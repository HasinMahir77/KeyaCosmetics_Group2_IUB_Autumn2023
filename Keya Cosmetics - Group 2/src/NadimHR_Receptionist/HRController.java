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

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class HRController implements Initializable {

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
    private void addemployeedetailsOnCLick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddEmployeeDetails.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void addTerminationDataOnCLick(ActionEvent event) {
    }

    @FXML
    private void employeeDetailsChartsOnClick(ActionEvent event) {
    }
    
}
