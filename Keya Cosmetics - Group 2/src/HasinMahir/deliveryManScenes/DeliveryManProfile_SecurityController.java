/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManProfile_SecurityController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Button resignButton;
    @FXML
    private Button applyButton;

    /**
     * Initializes the controller class.
     */
    DeliveryMan current;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData();
        this.usernameTextField.setText(current.getUsername());
        this.passwordTextField.setText(current.getPassword());
    }    


    @FXML
    private void changePasswordButtonOnClick(ActionEvent event) {
        this.changePasswordButton.setDisable(false);
    }

    @FXML
    private void resignButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void applyButtonOnClick(ActionEvent event) {
        //Validating the password
        if (passwordTextField.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a password that is at least 8 "
                    + "characters long.");
            alert.showAndWait();
        }
        else {
            current.setPassword(this.passwordTextField.getText());
            current.saveInstance();
            this.passwordTextField.setDisable(true);
        }
    }
    
}
