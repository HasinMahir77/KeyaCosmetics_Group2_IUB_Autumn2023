/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

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


/**
 * FXML Controller class
 *
 * @author 88019
 */
public class UpdatedTermsFXMLController implements Initializable {
    @FXML
    private TextArea policyTextArea;
    @FXML
    private Button saveFXID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveFXID.setDisable(true);        // TODO
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
    private void saveButton(ActionEvent event) {
        saveFXID.setDisable(true);     
        policyTextArea.setEditable(false);       

        
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("policy.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);            
            dos = new DataOutputStream(fos);        
            dos.writeUTF(policyTextArea.getText());


        } catch (IOException ex) {
            Logger.getLogger(UpdatedTermsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(UpdatedTermsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }    


    @FXML
    private void editButton(ActionEvent event) {
        policyTextArea.setEditable(true);
        saveFXID.setDisable(false);         
    
    }
    
}

