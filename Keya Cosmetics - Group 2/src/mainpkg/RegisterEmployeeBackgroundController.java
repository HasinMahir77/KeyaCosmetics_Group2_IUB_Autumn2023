/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class RegisterEmployeeBackgroundController implements Initializable {

    @FXML
    private BorderPane sceneBorderPane;
    @FXML
    private ComboBox<?> employeeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToLoginScreen(ActionEvent event) {
        MainpkgSwitcher ss = new MainpkgSwitcher();
        
    }
    
}
