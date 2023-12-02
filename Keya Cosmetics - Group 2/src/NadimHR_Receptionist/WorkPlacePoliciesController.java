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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class WorkPlacePoliciesController implements Initializable {

    @FXML
    private TextArea termslabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                Hr HR = new Hr();
        String policyText = HR.loadPolicy();
        termslabel.setText(policyText);
        termslabel.setEditable(false);
    }    

    @FXML
    private void saveAsPDF(ActionEvent event) {
    }
    
}
