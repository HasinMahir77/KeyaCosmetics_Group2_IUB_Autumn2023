/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.User;
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
                firstNameTextField.getText().equals("")|| phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("")) {
            System.out.println("Textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.show();
            return;
        }
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
        if (employeeComboBox.getValue().equals("HR")){  //TO DO 
                employeeFile = new File("HRList.bin");
            }
        if (employeeComboBox.getValue().equals("Product Manager")){  //TO DO 
                employeeFile = new File("ProductManagerList.bin");
            }
        else {
                employeeFile = null;
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
        }catch(Exception e){System.out.println(e);}
        //Duplicate checking done. Main algorithm now.
        
        //HR SignUp
        
        
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
