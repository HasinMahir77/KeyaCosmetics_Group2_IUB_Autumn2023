/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.ProductOrder;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import mainpkg.Main;
import mainpkg.MainpkgSwitcher;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        securityLabel.setTextFill(Color.BLUE);
        // Getting user data
        this.current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        
        //Initializing password field
        passwordTextField.setText(current.getPassword());
   
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
        applyButton.setDisable(false);
        changePasswordButton.setDisable(true);
        passwordTextField.setDisable(false);
        deleteAccountButton.setDisable(true);
        
        
        TextInputDialog tid = new TextInputDialog();
        TextField tf = tid.getEditor();
        tid.setHeaderText("Please enter your password to continue:");
        tid.showAndWait();
        try {
            if (tf.getText().equals(current.getPassword())){
                passwordTextField.setDisable(false);
                System.out.println("Password matched");
                applyButton.setDisable(false);
            }
            else{
                System.out.println("Password didn't match");
            }
        }
        catch(Exception e){e.printStackTrace(System.out);}
    }

    @FXML
    private void applyEdits(ActionEvent event) {
        
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
        MainpkgSwitcher logout = new MainpkgSwitcher();
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
    
}
