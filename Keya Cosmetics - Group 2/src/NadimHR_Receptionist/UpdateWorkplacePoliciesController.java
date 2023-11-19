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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class UpdateWorkplacePoliciesController implements Initializable {

    @FXML
    private TextArea viewAndUpdateWorkPlacePoliciesTextArea;
private Hr HR;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                HR = new Hr();
        String policyText = HR.loadPolicy();
        viewAndUpdateWorkPlacePoliciesTextArea.setText(policyText);
    }    

    @FXML
    private void UpdateButtonOnClick(ActionEvent event) {
                String policyText = viewAndUpdateWorkPlacePoliciesTextArea.getText();
        HR.savePolicy(policyText);
        
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        String policyText = HR.loadPolicy();
        viewAndUpdateWorkPlacePoliciesTextArea.setText(policyText);
    }

    @FXML
    private void saveasPDFonCLick(ActionEvent event) {
    }

    
}
