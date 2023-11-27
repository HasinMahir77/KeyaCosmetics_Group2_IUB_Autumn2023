/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.OrderedProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 *
 * @author hasin
 */
public class CustomerSecuritySceneController implements Initializable {

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem accountMenuItem;
    @FXML
    private MenuItem ordersMenuItem;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button cartButton;
    @FXML
    private ImageView keyaIcon;
    @FXML
    private Button shopButton;
    @FXML
    private Label profileLabel;
    @FXML
    private Label securityLabel;
    @FXML
    private Label allLabel;
    @FXML
    private Label ongoingLabel;
    @FXML
    private Label returnedLabel;
    @FXML
    private Label cartLabel;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Button applyButton;
    @FXML
    private Button deleteAccountButton;
    
    Customer current;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button changeUsernameButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        securityLabel.setTextFill(Color.BLUE);
        // Getting user data
        this.current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        
        //Initializing password field
        passwordTextField.setText(current.getPassword());
        usernameTextField.setText(current.getUsername());
   
    }   


    @FXML
    private void switchToShopScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToShopScene();
    }

    @FXML
    private void blueLabelOnHover(MouseEvent event){
        Label label = (Label) event.getSource();
        label.setTextFill(Color.BLUE);
        //#5e95e9
    }
    @FXML
    private void returnLabelColor(MouseEvent event){
        Label label = (Label) event.getSource();
        label.setTextFill(Color.BLACK);
        //#5e95e9
    }

    @FXML
    private void switchToAccountScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }
    private void switchToCartScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void changePasswordButtonOnClick(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Please enter your password to continue");
        PasswordField pf = new PasswordField();
        a.setGraphic(pf);
        a.setHeaderText("Current password:");
        a.setTitle("Change password");
     
        Optional<ButtonType> bt = a.showAndWait();
        
        if (bt.get().equals(ButtonType.OK)){
            if (pf.getText().equals(current.getPassword())){
                System.out.println("Password matched");
                applyButton.setDisable(false);
                passwordTextField.setDisable(false);
                deleteAccountButton.setDisable(true);
                changePasswordButton.setDisable(true);
                usernameTextField.setDisable(true);
            }
            else{
                Alert b = new Alert(Alert.AlertType.ERROR,"Incorrect password");
                b.show();
            }
        }
        else{
            return;
        }
    }

    @FXML
    private void applyEdits(ActionEvent event) {
        if (!passwordTextField.disableProperty().get()){ //If changing password
            //Validating the password
        if (passwordTextField.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a password that is at least 8 "
                    + "characters long.");
            alert.show();
        }
        else{
            current.setPassword(passwordTextField.getText());
        }
        passwordTextField.setDisable(true);
        applyButton.setDisable(true);
        changePasswordButton.setDisable(false);
        deleteAccountButton.setDisable(false);
        applyButton.setDisable(true);
        passwordTextField.setText(current.getPassword());
        }
        
        else { //Change username is pressed
            
            //Duplicate checking
            
            ArrayList<Customer> clist = Customer.getCustomerList();
            boolean duplicate = false;
            for (Customer c: clist){
                if (c.getUsername().equals(usernameTextField.getText())){
                    duplicate = true;
                }
            }
            //Validating the username length
        if (usernameTextField.getText().length()<5){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a username that is at least 5 "
                    + "characters long.");
            alert.show();
        }
        
        else if (duplicate){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username already exists. Try another.");
            alert.show();
        }
        else{ 
            current.setUsername(usernameTextField.getText());
        }    
        }
        
            usernameTextField.setDisable(true);
            applyButton.setDisable(true);
            changePasswordButton.setDisable(false);
            deleteAccountButton.setDisable(false);
            usernameTextField.setText(current.getUsername());
        current.saveInstance();
    }
    @FXML
    private void darkenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #79edad");
    }

    @FXML
    private void lightenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #affad3");  
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        MainpkgSS logout = new MainpkgSS();
        logout.switchtoLoginScene();
    }

    @FXML
    private void lightenUserMenuBar(MouseEvent event) {
        //userMenuBar.setStyle("-fx-background-color: #affad3");
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #58db95");
    }

    @FXML
    private void switchToAccountSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }


    @FXML
    private void switchToCartScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void switchToOrderScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToOrderScene();
    }

    @FXML
    private void switchToOrderSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToOrderScene();
    }

    @FXML
    private void deleteAccountButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.WARNING, "Are you sure about deleting your account?");
        a.getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> bt = a.showAndWait();
        
        if (bt.equals(ButtonType.CLOSE)){
            return;
        }
        else{
            ((Customer)Main.getUserData()).delete();
        }
    }

    @FXML
    private void changeUsername(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Please enter your password to continue");
        TextField pf = new TextField();
        a.setGraphic(pf);
        a.setHeaderText("Password:");
        a.setTitle("Change username");
     
        Optional<ButtonType> bt = a.showAndWait();
        
        if (bt.get().equals(ButtonType.OK)){
            if (pf.getText().equals(current.getPassword())){
                System.out.println("Password matched");
                applyButton.setDisable(false);
                usernameTextField.setDisable(false);
                deleteAccountButton.setDisable(true);
                changePasswordButton.setDisable(true);
            }
            else{
                Alert b = new Alert(Alert.AlertType.ERROR,"Incorrect password");
                b.show();
            }
        }
        else{
        }
    }
    
}
