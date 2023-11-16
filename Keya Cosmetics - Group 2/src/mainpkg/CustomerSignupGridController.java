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
    private GridPane signupGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signup(ActionEvent event) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        File customerList;
        
        //Checking for duplicate
        try {
            customerList = new File("customerList.bin");
            fis = new FileInputStream(customerList);
            ois = new ObjectInputStream(fis);
            while (true) {
                Customer registeredCustomer = (Customer)ois.readObject();
                if (registeredCustomer.getUsername().equals(usernameTextField.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR,"Username already exists");
                    a.show();
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
                usernameTextField.getText(), passwordTextField.getText());
            customerList = new File("customerList.bin");
            if (customerList.exists()){
                 fos = new FileOutputStream(customerList,true);
                 oos = new ObjectOutputStreamA(fos);
            } else {
                fos = new FileOutputStream(customerList);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newUser);
            oos.flush();
            oos.close();
            System.out.println("User written");
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    private void switchToLoginScreen(ActionEvent event) throws IOException {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("LoginGrid.fxml"));
        BorderPane sceneBorderPane = (BorderPane) mainStage.getUserData();
        sceneBorderPane.setCenter(root);
    }


    
}
