/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

<<<<<<< HEAD
import Amit_AffiliateMarketer.AmitSS;
import Borhan_Islam.Accountant;
import Borhan_Islam.BorhanSS;
import Borhan_Islam.ProductManager;
import Borhan_Islam.ProductManagerSS;
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
import HasinMahir.Customer;
import HasinMahir.User;
import HasinMahir.customerScenes.CustomerSceneSwitcher;
import NadimHR_Receptionist.HRSceneSwitcher;
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
import javafx.scene.control.Alert;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
        userComboBox.setValue("Customer");
        // Insert users here
        userComboBox.getItems().addAll("Customer","Delivery Man","Affiliate Marketer",
                "Product Manager","HR","Receptionist","Accountant", "Product Manager");
        
        
        //DEFAULT: CUSTOMER
       usernameTextField.setText("Customer");
       passwordTextField.setText("Customer");
=======
        // TODO
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
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
        ArrayList<String> userListFiles = new ArrayList<String>();
        userListFiles.add("CustomerList.bin");
        userListFiles.add("CustomerServiceExecutiveList.bin");
        userListFiles.add("HRList.bin");
        userListFiles.add("ReceptionistList.bin");
        
        //If any Text Field is empty
        
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            System.out.println("Username/Password textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter both a username and password");
            alert.show();
            return;
        }
        //Main login algorithm
        for(String userListFile: userListFiles){
            userList = new File(userListFile);
            try(FileInputStream fis = new FileInputStream(userList);
                    ObjectInputStream ois = new ObjectInputStream(fis)){
                User current = (User) ois.readObject();
                if(current.getUsername().equals(usernameTextField.getText()) && 
                        current.getPassword().equals(passwordTextField.getText()) &&
                        !current.isDel()){
                    //Login
                    if (userListFile.equals("CustomerList.bin")){
                        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
                        ss.switchToShopScene();
                        return;
                    }
                    if (userListFile.equals("CustomerServiceExecutiveList.bin")){
                        // TO DO
                        return;
                    }
                    if (userListFile.equals("HRList.bin")){
                        HRSceneSwitcher ss = new HRSceneSwitcher();
                        ss.switchScene("HR mainDashboard.fxml", "Dashboard");
                        return;
                    }
<<<<<<< HEAD
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
        //---------------Product Manager
        else if (userComboBox.getValue().equals("Product Manager")) {
            try{
                File userFile = new File("ProductManagerList.bin");
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                while(true){
                    ProductManager user = (ProductManager)oos.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Main.getMainStage().setUserData(user);
                        System.out.println("Username-password matched.");
                        System.out.println("Userdata set for Product Manager");
                        ProductManagerSS ss = new ProductManagerSS();
                        ss.switchScene("ProductManagerDashboardFXML.fxml", "Dashboard");
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
=======
                    if (userListFile.equals("ReceptionistList.bin")){
                        // TO DO
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
                    }
                    
                }
            }catch(Exception e){System.out.println(e);}
        }
 
        Alert alert = new Alert(Alert.AlertType.ERROR,"Username-password combination failed.");
        alert.show();
        
    }
   
        

    @FXML
    private void switchToSignupScreen(ActionEvent event) throws IOException {
        // Getting the BorderPane saved in the Stage to change the center
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setTitle("Sign up");
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
}
