/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import Borhan_Islam.Accountant;
import HasinMahir.User;
import NadimHR_Receptionist.Hr;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class EmployeeSignupGridController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private ComboBox<String> employeeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
        employeeComboBox.getItems().addAll("HR","Product Manager",
                "Accountant","Receptionist");
        
        employeeComboBox.setValue("HR");
    }    

    @FXML
    private void signup(ActionEvent event) {
        String employeeType = employeeComboBox.getValue();
        File employeeFile;
        //Checking for empty fields
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                firstNameTextField.getText().equals("")
                || lastNameTextField.getText().equals("")) {
            System.out.println("Textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.show();
            return;
        }
        /*
        
        //Validating the Phone number 
        if (phoneTextField.getText().length()!=11){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.show();
            return;
        }
                     
        try{
            int phone = Integer.parseInt(phoneTextField.getText());
        } catch(Exception e){
            System.out.println("Phone num parsing to int failed");
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid phone number");
            alert.show();
            return;
        }
                              */
        
        // Assigning the correct User File

        
        if (employeeComboBox.getValue().equals("Product Manager")){  //TO DO 
                employeeFile = new File("ProductManagerList.bin");
            }
        else if(employeeComboBox.getValue().equals("Accountant")) {
                employeeFile = new File("AccountantList.bin");
            }
        else if(employeeComboBox.getValue().equals("Receptionist")) {
                employeeFile = new File("ReceptionistList.bin");
            }
        
        //-----------------Insert Code Above This
        else {
            employeeFile = new File("HRList.bin"); //Since it's the default
        }
        //Checking for duplicate
        try{
            FileInputStream fis = new FileInputStream(employeeFile);
            ObjectInputStream oos = new ObjectInputStream(fis);
            while(true){
                User employee = (User)oos.readObject();
                if (employee.getUsername().equals(usernameTextField.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR,"Username already exists");
                    a.show();
                    return;
                   }
                }
        }catch(EOFException e){
            System.out.println("Duplicate checking complete");
        }
        catch(Exception e){
            System.out.println(e.toString()+" from "+ "HRList.bin");
        }
            
           
        //Duplicate checking done, correct File initiated. Main algorithm now.
        
        //Main SignUp
        
        if (employeeComboBox.getValue().equals("Product Manager")){  
           //TO DO 
                
            }
        
        else if(employeeComboBox.getValue().equals("Accountant")) {
                //TO DO
            try(FileOutputStream fos = new FileOutputStream(employeeFile,true);
                        ObjectOutputStreamA oos = new ObjectOutputStreamA(fos)){
                    Accountant newAccountant = new Accountant(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText());
                    oos.writeObject(newAccountant);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}            
        }
        else if(employeeComboBox.getValue().equals("Receptionist")) {
                //TO DO
            }
        
        //-----------------Insert Code Above This
        else if (employeeComboBox.getValue().equals("HR")) {
            
          //Since HR is the default
            try(FileOutputStream fos = new FileOutputStream(employeeFile,true);
                        ObjectOutputStreamA oos = new ObjectOutputStreamA(fos)){
                    Hr newHr = new Hr(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText());
                    oos.writeObject(newHr);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}
            
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
