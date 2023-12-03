/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.Product;
import HasinMahir.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mainpkg.MainpkgSS;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerAccountSceneController implements Initializable {

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private MenuItem ordersMenuItem;
    private ListView<String> categoryListView;    
    @FXML
    private Button cartButton;
    private Label quantityMinusLabel;
    private Label quantityPlusLabel;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem accountMenuItem;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private ImageView keyaIcon;
    @FXML
    private Label cartLabel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private Button shopButton;
    @FXML
    private Button applyButton;
    @FXML
    private Button editProfileButton;
    @FXML
    private Label profileLabel;
    @FXML
    private Label securityLabel;
    @FXML
    private Label balanceLabel;
    Customer current;

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        profileLabel.setTextFill(Color.BLUE);
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        addressTextArea.setText(current.getAddress());
        phoneTextField.setText(current.getPhone());
        
        this.balanceLabel.setText(this.balanceLabel.getText()+" "+current.getBalance());
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
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #79edad");
    }


    @FXML
    private void switchToAccountScene(ActionEvent event) {
    }

    @FXML
    private void editProfileButtonOnClick(ActionEvent event) {
        firstNameTextField.setDisable(false);
        lastNameTextField.setDisable(false);
        addressTextArea.setDisable(false);
        phoneTextField.setDisable(false);
        applyButton.setDisable(false);
        editProfileButton.setDisable(true);
    }

    @FXML
    private void applyEdits(ActionEvent event) {
        Customer current = (Customer)Main.getMainStage().getUserData();
        System.out.println(current);
        if (editProfileButton.isDisabled()){ //If Edit Profile button has been pressed
            //Checking for empty fields
            if (firstNameTextField.getText().equals("")|| phoneTextField.getText().equals("")
                || lastNameTextField.getText().equals("") ||addressTextArea.getText().equals("")) {
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
        //Validating address
        if (addressTextArea.getText().length()<=5){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a valid address");
            alert.show();
            return;
        }
        //Setting the new data
        try{
            current.setAddress(addressTextArea.getText());
        current.setFirstName(firstNameTextField.getText());
        current.setLastName(lastNameTextField.getText());
        current.setPhone(phoneTextField.getText());
        } catch(Exception e){System.out.println(e);}
        //Disabling the fields again
        firstNameTextField.setDisable(true);
        lastNameTextField.setDisable(true);
        addressTextArea.setDisable(true);
        phoneTextField.setDisable(true);
        applyButton.setDisable(true);
        //Enabling the buttons again
        editProfileButton.setDisable(false);
        current.saveInstance(); //Saving instance
        }
        
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
    private void switchToCartScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void switchToCartSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void switchToSecurityScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToSecurityScene();
    }

    private void switchToOrderScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToOrderScene();
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
    private void rechargeBalanceButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setUserData(current);
        stage.setTitle("Recharge");
        Parent root = FXMLLoader.load(getClass().getResource("RechargeScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        stage.showAndWait();
        current = (Customer)Main.getUserData();
        this.balanceLabel.setText("Balance: "+current.getBalance());
        
        
        
    }

 
    
}
