/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import Amit_AffiliateMarketer.AmitSS;
import Borhan_Islam.Accountant;
import Borhan_Islam.BorhanSS;
import HasinMahir.Customer;
import HasinMahir.DeliveryMan;
import HasinMahir.User;
import HasinMahir.customerScenes.CustomerSceneSwitcher;
import HasinMahir.deliveryManScenes.DMSS;
import NadimHR_Receptionist.HRSceneSwitcher;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
public class LoginGridController implements Initializable {

    @FXML
    private GridPane signupGridPane;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    private CustomerSceneSwitcher customerSceneSwitcher = new CustomerSceneSwitcher();
    @FXML
    private ComboBox<String> userComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userComboBox.setValue("Customer");
        // Insert users here
        userComboBox.getItems().addAll("Customer","Delivery Man","Affiliate Marketer",
                "Product Manager","HR","Receptionist","Accountant");
        
        
        //DEFAULT: CUSTOMER
       usernameTextField.setText("Customer");
       passwordTextField.setText("Customer");
    }    

    @FXML
    private void login(ActionEvent event) {
        this.login();
    }
    private void login() {
        //FileInputStream fis;
        //ObjectInputStream ois;
        File userList;
        //Store all the userList file names here
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //If any Text Field is empty
        
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            System.out.println("Username/Password textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter both a username and password.");
            alert.showAndWait();
            return;
          }
        //Validating combo box selection
        if (userComboBox.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please select a user type.");
            alert.showAndWait();
            return;
          }
        
        //Selecting correct file for login below this
        
        //--------------Customer
        if (userComboBox.getValue().equals("Customer")) {
            try{
                File userFile = new File("CustomerList.bin");
                System.out.println(userFile.getName()+".bin "+" opened");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    User user = (User)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
                        ss.switchScene("CustomerShopScene.fxml", "Keya: Shop");
                    }
                } // Loop's scope ends
            }
            catch(EOFException e){
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                Alert a = new Alert(Alert.AlertType.ERROR,"Login failed. \nLook at the error in the console");
                a.showAndWait();
            }
          }
        //---------------HR
        else if (userComboBox.getValue().equals("HR")) {
            try{
                File userFile = new File("HRList.bin");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    User user = (User)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        System.out.println("Userdata set for HR");
                        HRSceneSwitcher ss = new HRSceneSwitcher();
                        ss.switchScene("HR mainDashboard.fxml", "Keya: Dashboard");
                    }
                } // Loop's scope ends
            }
            catch(EOFException e){
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                Alert a = new Alert(Alert.AlertType.ERROR,"Login failed. \nLook at the error in the console");
                a.showAndWait();
                
            }
          }
        //---------------Accountant
        else if (userComboBox.getValue().equals("Accountant")) {
            try{
                File userFile = new File("AccountantList.bin");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    Accountant user = (Accountant)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        System.out.println("Username-password matched.");
                        System.out.println("Userdata set for Accountant");
                        BorhanSS ss = new BorhanSS();
                        ss.switchScene("AccountantDashboardFXML.fxml", "Keya: Dashboard");
                    }
                } // Loop's scope ends
            }
            
            catch(EOFException e){
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                Alert a = new Alert(Alert.AlertType.ERROR,"Login failed. \nLook at the error in the console");
                a.showAndWait();
                
            }
          }
        //---------------Affiliate Marketer
        else if (userComboBox.getValue().equals("Affiliate Marketer")) {
            try{
                File userFile = new File("AffiliateMarketerList.bin");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    User user = (User)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        System.out.println("Username-password matched.");
                        System.out.println("Userdata set for Accountant");
                        AmitSS ss = new AmitSS();
                        ss.switchScene("AffiliateMarketerHomepageFXML.fxml", "Keya: Home");
                    }
                } // Loop's scope ends
            }
            
            catch(EOFException e){
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                Alert a = new Alert(Alert.AlertType.ERROR,"Login failed. \nLook at the error in the console");
                a.showAndWait();
                
            }
          }
        else if (userComboBox.getValue().equals("Delivery Man")) {
            try{
                File userFile = new File("DeliveryManList.bin");
                System.out.println(userFile.getName()+".bin "+" opened");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    DeliveryMan user = (DeliveryMan)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        DMSS dmss = new DMSS();
                        dmss.switchToDashboard();
                    }
                } // Loop's scope ends
            }
            catch(EOFException e){
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                System.out.println(e.toString()+" at "+ userComboBox.getValue());
                Alert a = new Alert(Alert.AlertType.ERROR,"Login failed. \nLook at the error in the console");
                a.showAndWait();
            }
          }
        
        // Login done. 
        
        
        }
 
        
        

    @FXML
    private void switchToSignupScreen(ActionEvent event) throws IOException {
        // Getting the BorderPane saved in the Stage to change the center
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setTitle("Keya Cosmetics: Sign up");
        BorderPane sceneBorderPane =(BorderPane) LoginSignupSceneController.getSceneBorderPane();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerSignupGrid.fxml"));
        sceneBorderPane.setCenter(root);
    }
    
    private void actionOnKeyPressed(KeyEvent event) throws IOException {
        if (event.getCode()==KeyCode.ENTER) {
        }                
    }

    @FXML
    private void usernameTextFieldOnKeyPressed(KeyEvent event) {
        if (event.getCode()==KeyCode.ENTER) {
            this.login();
        }
    }

    @FXML
    private void passwordTextFieldOnKeyPressed(KeyEvent event) {
        if (event.getCode()==KeyCode.ENTER) {
            this.login();
        }
    }

    @FXML
    private void registerEmployeeButtonAction(ActionEvent event) throws IOException {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setTitle("Keya Cosmetics: Register Employee");
        BorderPane sceneBorderPane =(BorderPane) LoginSignupSceneController.getSceneBorderPane();
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeSignupGrid.fxml"));
        sceneBorderPane.setCenter(root);
    }

    @FXML
    private void switchToObjectWriter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductWriter.fxml"));
        Stage mainStage = Main.getMainStage();
        mainStage.setTitle("Writer");
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
}
