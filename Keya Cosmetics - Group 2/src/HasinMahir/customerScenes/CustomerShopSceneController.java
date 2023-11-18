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
public class CustomerShopSceneController implements Initializable {

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private MenuItem ordersMenuItem;
    @FXML
    private ListView<String> categoryListView;    
    @FXML
    private Button cartButton;
    private Label quantityMinusLabel;
    private Label quantityPlusLabel;
    @FXML
    private TextField quantityTextField;
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
    private ListView<String> filtersListView;
    @FXML
    private TextField searchTextField;
    private Label searchLabel;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TableColumn<Product, Integer> priceColumn;
    @FXML
    private TableColumn<Product, String> stockColumn;
    @FXML
    private Button cartButton11;
    @FXML
    private Button addToCart;
    @FXML
    private Button removeFromCart;

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        categoryListView.getItems().addAll("Soap","Lotion",
                "Shampoo","Cream","Serum");
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
    private void search(ActionEvent event) {
    }

    @FXML
    private void switchToAccountScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }
        
    
}
