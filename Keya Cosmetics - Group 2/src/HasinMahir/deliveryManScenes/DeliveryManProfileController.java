/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */

public class DeliveryManProfileController implements Initializable {

    @FXML
    private ImageView keyaIcon;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TextField nidTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private Button editButton;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private Button applyButton;
    private TextField usernameTextField;
    private PasswordField passwordTextField;
    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem logoutMenuItem;

    /**
     * Initializes the controller class.
     */
    DMSS ss = new DMSS();
    DeliveryMan current;
    @FXML
    private Button profileButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button tasksButton;
    @FXML
    private Tab securityTab;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData();
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        nidTextField.setText(current.getNid());
        phoneTextField.setText(current.getPhone());
        dobDatePicker.setValue(current.getDob());
        dojDatePicker.setValue(current.getDoj());
 
    }    

    @FXML
    private void lightenGreyButton(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color:  #eef0f5");
    }

    @FXML
    private void darkenGreyButton(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #d0d0db");
    }


    @FXML
    private void paymentsButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToPayments();
    }


    @FXML
    private void logout(ActionEvent event) throws IOException {
        MainpkgSS ss = new MainpkgSS();
        ss.switchtoLoginScene();
    }

    @FXML
    private void applyButtonOnAction(ActionEvent event) {
        //Checking for empty fields
        if (firstNameTextField.getText().equals("") || phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("") || dobDatePicker.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill in all of the fields");
            alert.show();
            return;
        }
        //DOB VL
        if (LocalDate.now().getYear()-dobDatePicker.getValue().getYear()<18){
            Alert a = new Alert(Alert.AlertType.ERROR,"You must be at least 18 years old to register");
            a.show();
            return;
        }
        //Phone VL
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
        current.setFirstName(this.firstNameTextField.getText());
        current.setLastName(this.lastNameTextField.getText());
        current.setPhone(this.phoneTextField.getText());
        current.setNid(this.nidTextField.getText());
        current.setDob(this.dobDatePicker.getValue());
        this.firstNameTextField.setDisable(true);
        this.lastNameTextField.setDisable(true);
        this.phoneTextField.setDisable(true);
        this.nidTextField.setDisable(true);
        this.dobDatePicker.setDisable(true);
        current.saveInstance();
    }


    private void switchToProfileScene(ActionEvent event) throws IOException {
        ss.switchToProfile();
    }

    @FXML
    private void lightenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #79edad");
    }
    
    private void switchToDashboard(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToDashboard();
    }

    @FXML
    private void tasksButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToTasks();
    }

    @FXML
    private void dashboardButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToDashboard();
    }

    @FXML
    private void securityTabOnClick(Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeliveryManProfile_Security.fxml"));
        securityTab.setContent(root);
    }

    @FXML
    private void editButtonOnAction(ActionEvent event) {
        this.firstNameTextField.setDisable(false);
        this.lastNameTextField.setDisable(false);
        this.phoneTextField.setDisable(false);
        this.nidTextField.setDisable(false);
        this.dobDatePicker.setDisable(false);
    }
    
    
}
