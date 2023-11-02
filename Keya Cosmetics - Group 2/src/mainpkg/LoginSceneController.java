/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import mainpkg.data.userList;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        customer newcustomer = new customer("Hasin", "Mahir", "Mahir","mahir1212");
        userList.addUser(newcustomer);
    }    

    @FXML
    private void loginOnClick(ActionEvent event) {
    }
    
}
