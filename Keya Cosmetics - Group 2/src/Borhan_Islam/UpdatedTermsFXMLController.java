/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;
import NadimHR_Receptionist.Hr;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import static javax.swing.text.html.HTML.Tag.HR;


/**
 * FXML Controller class
 *
 * @author 88019
 */
public class UpdatedTermsFXMLController implements Initializable {
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
        policyTextArea.clear();        
        savepdffxid.setDisable(true);        // TODO
        policyTextArea.setEditable(false);       
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
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

