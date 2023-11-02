/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.Customer;
import HasinMahir.customerScenes.CustomerSceneSwitcher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.data.UserList;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class LoginSceneController implements Initializable {
    CustomerSceneSwitcher sceneSwitcher1 = new CustomerSceneSwitcher();
    

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
        Customer newcustomer = new Customer("Hasin", "Mahir", "Mahir","mahir1212");
        UserList.addUser(newcustomer);
    }    

    @FXML
    private void loginOnClick(ActionEvent event) throws IOException {
        
        
        sceneSwitcher1.switchScene("customerDashboard.fxml");
        
    }
    
}
