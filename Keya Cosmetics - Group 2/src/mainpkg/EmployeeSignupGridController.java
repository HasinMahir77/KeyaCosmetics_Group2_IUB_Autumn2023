/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import Amit_AffiliateMarketer.AffiliateMarketer;
import Amit_ProductionManager.ProductionManager;
import Borhan_Islam.Accountant;
import Borhan_Islam.ProductManager;
import HasinMahir.Customer;
import HasinMahir.DeliveryMan;
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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    @FXML
    private DatePicker dobDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
        employeeComboBox.getItems().addAll("HR","Delivery Man","Product Manager",
                "Accountant","Receptionist","Affiliate Marketer","Production Manager");
        
        employeeComboBox.setValue("HR");
    }    

    @FXML
    private void signup(ActionEvent event) throws IOException {
        String employeeType = employeeComboBox.getValue();
        File employeeFile;
        //Checking for empty fields
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                firstNameTextField.getText().equals("") || phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("")) {
            System.out.println("Textfield is empty");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.show();
            return;
        }
        //Validating username
        if (usernameTextField.getText().length()<=4){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username needs to be at least 4 characters long");
            alert.showAndWait();
            return;
        }
        //Validating the password
        if (passwordTextField.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a password that is at least 8 "
                    + "characters long.");
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
        //Validating DOB
        
        if (dobDatePicker.getValue()==null){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter your date of birth.");
            a.show();
            return;
        }
        else if (LocalDate.now().getYear()-dobDatePicker.getValue().getYear()<18){
            Alert a = new Alert(Alert.AlertType.ERROR,"You must be at least 18 years old to register");
            a.show();
            return;
        }
        
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
        else if(employeeComboBox.getValue().equals("Delivery Man")) {
                employeeFile = new File("DeliveryManList.bin");
            }
        else if(employeeComboBox.getValue().equals("Affiliate Marketer")) {
                employeeFile = new File("AffiliateMarketerList.bin");
            }
        else if(employeeComboBox.getValue().equals("Production Manager")) {
                employeeFile = new File("ProductionManagerList.bin");
            }
        
        //-----------------Insert Code Above This
        else {
            employeeFile = new File("HRList.bin"); //Since it's the default
        }
        //Checking for duplicate
        try(FileInputStream fis = new FileInputStream(employeeFile);
            ObjectInputStream oos = new ObjectInputStream(fis);){
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
            System.out.println(e.toString()+" from "+ employeeFile.getName());
        }
            
           
        //Duplicate checking done, correct File initiated. Main algorithm now.
        
        //---------------------Main SignUp
        
        if (employeeComboBox.getValue().equals("Product Manager")){  
           //TO DO 
           try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    ProductManager newpm = new ProductManager(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),phoneTextField.getText());
                    newpm.setDob(dobDatePicker.getValue());
                    oos.writeObject(newpm);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}
                
            }
        
        else if(employeeComboBox.getValue().equals("Accountant")) {
                //TO DO
            try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    Accountant newAccountant = new Accountant(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),phoneTextField.getText());
                    newAccountant.setDob(dobDatePicker.getValue());
                    oos.writeObject(newAccountant);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}            
        }
        
        //Affiliate Marketer
        else if(employeeComboBox.getValue().equals("Affiliate Marketer")) {
                //TO DO
            try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    AffiliateMarketer newAM = new AffiliateMarketer(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),phoneTextField.getText());
                    newAM.setDob(dobDatePicker.getValue());
                    oos.writeObject(newAM);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}            
        }
        else if(employeeComboBox.getValue().equals("Product Manager")) {
                //TO DO
            try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    ProductManager pm = new ProductManager(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),phoneTextField.getText());
                    pm.setDob(dobDatePicker.getValue());
                    oos.writeObject(pm);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);} 
        }
        else if(employeeComboBox.getValue().equals("Production Manager")) {
                //TO DO
            try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    ProductionManager pm = new ProductionManager(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(),phoneTextField.getText());
                    pm.setDob(dobDatePicker.getValue());
                    oos.writeObject(pm);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);} 
        }
        //DeliveryMan
        else if(employeeComboBox.getValue().equals("Delivery Man")) {
                //TO DO
            DeliveryMan dm = new DeliveryMan(this.firstNameTextField.getText(),this.lastNameTextField.getText(),
                this.usernameTextField.getText(),this.passwordTextField.getText(),
                this.phoneTextField.getText());
        dm.setDoj(LocalDate.now());
        dm.setDob(dobDatePicker.getValue());
        
        if (employeeFile.exists()){ //User(s) exist
            try(FileOutputStream fos = new FileOutputStream(employeeFile,true);
                ObjectOutputStreamA oos = new ObjectOutputStreamA(fos)){
                oos.writeObject(dm);
                System.out.println("User written");
            }
            catch(Exception e){System.out.println(e.toString()+" at signup");}
        }
        else{ //No file. First data
            try(FileOutputStream fos = new FileOutputStream(employeeFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(dm);
                    System.out.println("User written");
            }
            catch(Exception e){System.out.println(e.toString()+" at signup");}
        }
        if (new File("DeliveryManList.bin").exists()){
            for (DeliveryMan d: DeliveryMan.getDeliveryManList()){
                System.out.println(d);
            }
        }
        }//End 
        
        else if(employeeComboBox.getValue().equals("Receptionist")) {
                //TO DO
            }
        
        //-----------------Insert Code Above This
        else if (employeeComboBox.getValue().equals("HR")) {
            
          //Since HR is the default
            try{
                FileOutputStream fos;
                ObjectOutputStream oos;
                if (employeeFile.exists()){
                        fos = new FileOutputStream(employeeFile,true);
                        oos = new ObjectOutputStreamA(fos);
                }
                else {
                        fos = new FileOutputStream(employeeFile);
                        oos = new ObjectOutputStream(fos);
                }
                    Hr newHr = new Hr(firstNameTextField.getText(),lastNameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText());
                    newHr.setDob(dobDatePicker.getValue());
                    oos.writeObject(newHr);
                    
                }
                catch(Exception e){
                    e.printStackTrace(System.out);}
            
        }
        System.out.println("Employee written");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Account created successfully",
                    ButtonType.OK,ButtonType.CLOSE);
            a.showAndWait();
            if (a.getResult()==ButtonType.OK){
                this.switchToLoginScreen(event);
            }
            else{
                this.usernameTextField.clear();
                this.firstNameTextField.clear();
                this.passwordTextField.clear();
                this.phoneTextField.clear();
                this.usernameTextField.clear();
                this.lastNameTextField.clear();
                this.dobDatePicker.getEditor().clear();
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
