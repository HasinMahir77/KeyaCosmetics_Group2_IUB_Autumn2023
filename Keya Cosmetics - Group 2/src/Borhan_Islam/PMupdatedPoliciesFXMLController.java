/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import NadimHR_Receptionist.Hr;
import java.io.IOException;
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
 * @author 88019
 */
public class PMupdatedPoliciesFXMLController implements Initializable {

    @FXML
    private TextArea policyTextArea;
    @FXML
    private Button savepdffxid;
    @FXML
    private Button loadfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard();  
    }

    @FXML
    private void savepdfButton(ActionEvent event) {
    }

    @FXML
    private void loadButton(ActionEvent event) {
        savepdffxid.setDisable(false);        // TODO
        loadfxid.setDisable(true);        // TODO
        
        Hr hr= new Hr();
        String policyText= hr.loadPolicy();
        policyTextArea.setText(policyText);    
    }
    
}
