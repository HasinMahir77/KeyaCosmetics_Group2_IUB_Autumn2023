/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
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
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button changeUsernameButton;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Button resignButton;
    @FXML
    private Button applyButton1;
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
        usernameTextField.setText(current.getUsername());
        passwordTextField.setText(current.getPassword());
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
    }

    @FXML
    private void changeUsername(ActionEvent event) {
    }

    @FXML
    private void changePasswordButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void deleteAccountButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void applyEdits(ActionEvent event) {
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
    
    
}
