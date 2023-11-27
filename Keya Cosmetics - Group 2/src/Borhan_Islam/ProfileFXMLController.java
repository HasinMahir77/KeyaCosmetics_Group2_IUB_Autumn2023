/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import Borhan_Islam.Accountant;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.util.StringConverter;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ProfileFXMLController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField dobTextField;
    @FXML
    private TextField dojTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Accountant current = (Accountant) Main.getMainStage().getUserData();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        usernameTextField.setText(current.getUsername());
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        phoneNumberTextField.setText(current.getPhone());
        dobTextField.setText(current.getDob().format(dateFormatter));
        dojTextField.setText(current.getDoj().format(dateFormatter));
    }

    @FXML
    private void switchToDashboardButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToDashboardButton();           
    }
        
}
