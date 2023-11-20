/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.Customer;
import HasinMahir.customerScenes.CustomerSceneSwitcher;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class LoginSignupSceneController implements Initializable {
    CustomerSceneSwitcher customerSceneSwitcher = new CustomerSceneSwitcher();
    

    @FXML
    private BorderPane sceneBorderPane;
    private static BorderPane currentBorderPane;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent loginGrid;
        currentBorderPane = sceneBorderPane;
        //Setting the LoginGrid as the center
        try {
            loginGrid = FXMLLoader.load(getClass().getResource("LoginGrid.fxml"));
            sceneBorderPane.setCenter(loginGrid);
        } catch (IOException ex) {
            System.out.println(ex.toString());;
        }  
        
    
    }    

    public static BorderPane getSceneBorderPane() {
        return currentBorderPane;
    }

    @FXML
    private void registerEmployeeButtonAction(ActionEvent event) {
        
        
    }


    
}
