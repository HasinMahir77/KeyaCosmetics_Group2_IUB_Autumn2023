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
import mainpkg.data.UserList;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class LoginSignupSceneController implements Initializable {
    CustomerSceneSwitcher customerSceneSwitcher = new CustomerSceneSwitcher();
    

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private BorderPane sceneBorderPane;

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
    private void login() throws IOException{
        //If any Text Field is empty
        
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            System.out.println("Username/Password textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter both a username and password");
            alert.show();
            return;
        }
            
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("customerList.bin");
            ois = new ObjectInputStream(fis);
            Customer oldCustomer = (Customer)ois.readObject();
            String username = oldCustomer.getUsername();
            String password = oldCustomer.getPassword();
            
            if(username.equals(usernameTextField.getText()) && 
                    password.equals(passwordTextField.getText())){
                customerSceneSwitcher.switchScene("customerDashboard.fxml","Dashboard");
            }
            
            
        } catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username-Password"
                    + " Combination Failed");
            alert.show();  
        }
        /*
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            System.out.println("Username/Password textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter both a username and password");
            alert.show();   
        } 
        else if (UserList.getUser(usernameTextField.getText())==null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"User not found");
            alert.show();
            System.out.println("User not found");
        }
        else if (UserList.getPassword(usernameTextField.getText()).equals(passwordTextField.getText())){
            System.out.println("Authentication Complete");
            sceneSwitcher1.switchScene("customerDashboard.fxml","Dashboard");
        }
        else{
            System.out.println("Authentication Failed");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username-Password"
                    + " Combination Failed");
            alert.show();  
        }  
        */
        
    }

    private void actionOnKeyPressed(KeyEvent event) throws IOException {
        if (event.getCode()==KeyCode.ENTER) {
            this.login();
        }
                    
    }


    @FXML
    private void switchToSignupScreen(ActionEvent event) throws IOException {
        /*
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SignupScene.fxml"));
        Scene signupScene = new Scene(root);
        mainStage.setScene(signupScene);
        */
        GridPane root = FXMLLoader.load(getClass().getResource("CustomerSignupGrid.fxml"));
        sceneBorderPane.setCenter(root);
    }
    
}
