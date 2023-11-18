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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    private Label searchLabel;
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
        phoneTextField.setText(current.getPassword());
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

    private void lightenSearchLabel(MouseEvent event) {
        searchLabel.setStyle("-fx-background-color: #affad3");
        
        
    }

    private void darkenSearchLabel(MouseEvent event) {
        searchLabel.setStyle("-fx-background-color: #58db95");
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
        
    }

    @FXML
    private void applyEdits(ActionEvent event) {
        Customer current = (Customer)Main.getMainStage().getScene().getUserData();
        
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
    
}
