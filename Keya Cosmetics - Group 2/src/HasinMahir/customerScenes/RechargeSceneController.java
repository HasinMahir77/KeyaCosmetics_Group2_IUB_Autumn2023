/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class RechargeSceneController implements Initializable {

    @FXML
    private RadioButton bKashRadioButton;
    @FXML
    private RadioButton bankRadioButton;
    @FXML
    private RadioButton cashRadioButton;
    Customer current;
    @FXML
    private TextField rechargeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (Customer) Main.getUserData();
    }    

    @FXML
    private void bKashRadioButtonOnAction(ActionEvent event) {
        this.bankRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void bankRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void cashRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.bankRadioButton.setSelected(false);
    }

    @FXML
    private void rechargeButtonOnClick(ActionEvent event) {
        Float rec;
        try{
            rec = Float.parseFloat(this.rechargeTextField.getText());
        }
        catch(Exception e){
            new Alert(Alert.AlertType.ERROR,"Please enter a valid amount").showAndWait();
            return;
        }
        current.setBalance(current.getBalance()+rec);
        current.saveInstance();
        Main.setUserData(current);
        
    }
    
}
