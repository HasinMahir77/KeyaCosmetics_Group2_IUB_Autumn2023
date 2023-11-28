/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;


import java.io.IOException;
import java.net.URL;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import Borhan_Islam.ProductManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class PmProfileFXMLController implements Initializable {

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
        ProductManager current = (ProductManager) Main.getMainStage().getUserData();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        usernameTextField.setText(current.getUsername());
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        phoneNumberTextField.setText(current.getPhone());
        dobTextField.setText(current.getDob().format(dateFormatter));
        dojTextField.setText(current.getDoj().format(dateFormatter));
    }

    @FXML
    private void switchToPmDashboardButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboardButton();           
    }
        
}
