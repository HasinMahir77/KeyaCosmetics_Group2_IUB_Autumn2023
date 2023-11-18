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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import mainpkg.LogoutSceneSwitcher;
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
    private Button cartButton1;
    @FXML
    private Label voucherLabel;
    @FXML
    private Label allLabel;
    @FXML
    private Label ongoingLabel;
    @FXML
    private Label returnedLabel;
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
    private PasswordField passwordTextField;
    @FXML
    private Button changePasswordButton;

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
        addressTextArea.setText(current.getAddress());
        phoneTextField.setText(current.getPhoneNum());
        passwordTextField.setText("********");
    }    

    private void darkenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #58db95");
    }

    private void lightenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #affad3");  
    }

    private void quantityMinusLabelLightenOnHover(MouseEvent event) {
        quantityMinusLabel.setStyle("-fx-background-color: #ffffff");
    }

    private void quantityMinusLabelDarkenOnHover(MouseEvent event) {
        quantityMinusLabel.setStyle("-fx-background-color: #c9c7c7");
    }

    private void quantityPlusLabelLightenOnHover(MouseEvent event) {
        quantityPlusLabel.setStyle("-fx-background-color: #ffffff");
    }

    private void quantityPlusLabelDarkenOnHover(MouseEvent event) {
        quantityPlusLabel.setStyle("-fx-background-color: #c9c7c7");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        LogoutSceneSwitcher logout = new LogoutSceneSwitcher();
        logout.switchScene();
    }


    @FXML
    private void lightenReturnButtonOnHover(MouseEvent event) {
        this.lightenGreenButtonOnHover(event);
        
    }

    @FXML
    private void darkenReturnButtonOnHover(MouseEvent event) {
        this.darkenGreenButtonOnHover(event);
    }

    @FXML
    private void lightenCartButtonOnHover(MouseEvent event) {
        this.lightenGreenButtonOnHover(event);
    }

    @FXML
    private void darkenCartButtonOnHover(MouseEvent event) {
         this.darkenGreenButtonOnHover(event);
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
        changePasswordButton.setDisable(true); 
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
        current.setPhoneNum(phoneTextField.getText());
        } catch(Exception e){System.out.println(e);}
        //Disabling the fields again
        firstNameTextField.setDisable(true);
        lastNameTextField.setDisable(true);
        addressTextArea.setDisable(true);
        phoneTextField.setDisable(true);
        applyButton.setDisable(true);
        //Enabling the buttons again
        editProfileButton.setDisable(false);
        changePasswordButton.setDisable(false);
        }
        else{ //Change password button has been pressed
            //Validating the password
        if (passwordTextField.getText().length()<=8){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter a password that is at least 8 "
                    + "characters long.");
            alert.show();
            return;
        }
        current.setPassword(passwordTextField.getText());
       // current.saveInstance();
        //Enabling the buttons again
        editProfileButton.setDisable(false);
        changePasswordButton.setDisable(false);
        //Disabling the password field again
        passwordTextField.setDisable(true);
        }
    }

    @FXML
    private void changePasswordButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void lightenShopButtonOnHover(MouseEvent event) {
        shopButton.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenShopButtonOnHover(MouseEvent event) {
        shopButton.setStyle("-fx-background-color: #58db95");
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
    private void lightenLabelHover(MouseEvent event) {
    }
    
}
