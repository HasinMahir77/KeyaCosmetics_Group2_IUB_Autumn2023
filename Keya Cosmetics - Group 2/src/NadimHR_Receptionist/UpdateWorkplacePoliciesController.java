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

public class UpdateWorkplacePoliciesController implements Initializable {

    @FXML
    private TextArea PolicyTextArea;
    private Hr HR;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                HR = new Hr(); // Use the class-level variable
        String policyText = HR.loadPolicy();
        PolicyTextArea.setText(policyText);
        // TODO
    }    

    @FXML
    private void SaveAsPDFonClick(ActionEvent event) {


    }

    @FXML
    private void LoadOnClick(ActionEvent event) {
                String policyText = HR.loadPolicy();
        PolicyTextArea.setText(policyText);

    }

    @FXML
    private void updateOnClick(ActionEvent event) {
        String policyText = PolicyTextArea.getText();
        HR.savePolicy(policyText);
    }
    
}
