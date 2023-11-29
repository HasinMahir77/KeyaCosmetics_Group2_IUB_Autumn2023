/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class AccProfileFXMLController implements Initializable {

    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private Button editButtonFXID;
    @FXML
    private Button applyButtonFXID;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private DatePicker dojDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Accountant current = (Accountant)Main.getMainStage().getUserData();
        UsernameTextField.setText(current.getUsername());
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        phoneTextField.setText(current.getPhone());
        dobDatePicker.setValue(current.getDob());
        dojDatePicker.setValue(current.getDoj());
        
    }     

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard();  
    }

    @FXML
    private void editButton(ActionEvent event) {
        
        firstNameTextField.setDisable(false);
        lastNameTextField.setDisable(false);
        phoneTextField.setDisable(false);
        dobDatePicker.setDisable(false);
        dojDatePicker.setDisable(false);
        applyButtonFXID.setDisable(false);
        editButtonFXID.setDisable(true);

    } 

    @FXML
    private void applyButton(ActionEvent event) {
        Accountant current = (Accountant)Main.getMainStage().getUserData();
        System.out.println(current);
        if (editButtonFXID.isDisabled()){ //If Edit Profile button has been pressed
            //Checking for empty fields
            if (firstNameTextField.getText().equals("")|| phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("") ||dobDatePicker.getValue().equals("")
                || dojDatePicker.getValue().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.show();
            return;
        }
            //Validating the Phone number 
        if (phoneTextField.getText().length()!=11){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.show();
            return;
        }
        try{
            int phone = Integer.parseInt(phoneTextField.getText());
        } catch(Exception e){
            System.out.println("Phone num parsing to int failed");
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.show();
            return;
        }
        //Setting the new data
        try{
        current.setFirstName(firstNameTextField.getText());
        current.setLastName(lastNameTextField.getText());
        current.setPhone(phoneTextField.getText());
        current.setDob(dobDatePicker.getValue());
        current.setDoj(dojDatePicker.getValue());
        } catch(Exception e){System.out.println(e);}
        //Disabling the fields again
        firstNameTextField.setDisable(true);
        lastNameTextField.setDisable(true);
        phoneTextField.setDisable(true);
        dobDatePicker.setDisable(false);
        dojDatePicker.setDisable(false);        
        applyButtonFXID.setDisable(true);
        //Enabling the buttons again
        editButtonFXID.setDisable(false);

        current.saveInstance();

        }
    }
}