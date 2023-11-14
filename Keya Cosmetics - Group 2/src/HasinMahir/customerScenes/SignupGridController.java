/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mainpkg.data.UserList;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class SignupGridController implements Initializable {

    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private GridPane signupGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
    @FXML
    private void signup(ActionEvent event) {
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                firstNameTextField.getText().equals("")|| lastNameTextField.getText().equals("")
                || addressTextArea.getText().equals("")) {
            System.out.println("Empty Text Area/Field");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all details");
            alert.show(); 
            return;
        } 
        if (passwordTextField.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Password should at least contain 8 characters");
            alert.show(); 
            return;
        }
        System.out.println("Validation Passed");
        
        Customer newCustomer = new Customer();
        Customer newcustomer = new Customer(firstNameTextField.getText(), passwordTextField.getText(),
                usernameTextField.getText(),passwordTextField.getText(), addressTextArea.getText());
        
        System.out.println("customer created");
        
        File customerList = new File("customerList.bin");
        
        System.out.println("File initialized");
        
        FileOutputStream fos;
        ObjectOutputStream oos;
        // If first instance
        if (customerList.exists()){
            fos = new FileOutputStream(customerList,true);
            oos = new ObjectOutputStreamA(fos);
        } else {
            fos = new FileOutputStream(customerList);
            oos = new ObjectOutputStream(fos);
        }
        
        
            oos.writeObject(newCustomer);
            oos.close();
            System.out.println("Obj Written");
    }
*/
    @FXML
    private void switchToLoginScreen(ActionEvent event) throws IOException {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene loginScene = new Scene(root);
        mainStage.setScene(loginScene);
    }

    @FXML
    private void signup(ActionEvent event) {
    }
    
}
