/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.Customer;
import HasinMahir.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerSignupGridController implements Initializable {

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
    private TextField phoneTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signup(ActionEvent event) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        File customerList;
        //Checking for empty fields
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                firstNameTextField.getText().equals("")|| phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("") ||addressTextArea.getText().equals("")) {
            System.out.println("Username/Password textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.showAndWait();
            return;
        }
        //Validating Address
        if (addressTextArea.getText().length()<=8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Address is too short");
            alert.showAndWait();
            return;
        }
        //Validating Address
        if (usernameTextField.getText().length()<=4){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username needs to be at least 4 characters long");
            alert.showAndWait();
            return;
        }
        //Validating the Phone number
        
        String phoneS = phoneTextField.getText();
        if (phoneS.length()!=11 && !phoneS.substring(0, 2).equals("01")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.showAndWait();
            return; 
        }
        //Checking if it's a number
        try{
            int phone = Integer.parseInt(phoneTextField.getText());
        } catch(Exception e){
            System.out.println("Phone num parsing to int failed");
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.show();
            return;
        }
        //Validating the password
        if (passwordTextField.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a password that is at least 8 "
                    + "characters long.");
            alert.showAndWait();
            return;
        }
        
         
        //Checking for duplicate
        try {
            customerList = new File("CustomerList.bin");
            fis = new FileInputStream(customerList);
            ois = new ObjectInputStream(fis);
            while (true) {
                Customer registeredCustomer = (Customer)ois.readObject();
                if (registeredCustomer.getUsername().equals(usernameTextField.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR,"Username already exists");
                    a.showAndWait();
                    return;
                }
            }
            
        } catch(Exception e) {
            System.out.println("File reading complete");
            System.out.println(e.toString());
        }
        //Duplicate checking done. Adding the user to database.
        try {
            Customer newUser = new Customer(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),
                    addressTextArea.getText(),phoneTextField.getText());
            customerList = new File("CustomerList.bin");
            
            fos = new FileOutputStream(customerList,true);
            oos = new ObjectOutputStreamA(fos);
            
            oos.writeObject(newUser);
            oos.close();
            System.out.println("Customer written");
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Account created successfully",ButtonType.OK);
            a.showAndWait();
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    private void switchToLoginScreen(ActionEvent event) throws IOException {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setTitle("Keya Cosmetics: Login");
        Parent root = FXMLLoader.load(getClass().getResource("LoginGrid.fxml"));
        BorderPane sceneBorderPane = LoginSignupSceneController.getSceneBorderPane();
        sceneBorderPane.setCenter(root);
    }


    
}
