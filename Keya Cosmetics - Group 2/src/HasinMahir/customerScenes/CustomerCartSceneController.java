/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Cart;
import HasinMahir.Customer;
import HasinMahir.Product;
import HasinMahir.ProductOrder;
import HasinMahir.User;
import static HasinMahir.customerScenes.CustomerShopSceneController.current;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import mainpkg.MainpkgSwitcher;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerCartSceneController implements Initializable {

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private MenuItem ordersMenuItem;   
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
    private Button shopButton;
    @FXML
    private Button cartButton1;
    @FXML
    private Label profileLabel;
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
    private TableView<ProductOrder> cartTableView;
    @FXML
    private TableColumn<ProductOrder, String> nameColumn;
    @FXML
    private TableColumn<ProductOrder, Integer> quantityColumn;
    @FXML
    private TableColumn<ProductOrder, Float> unitPriceColumn;
    @FXML
    private TableColumn<ProductOrder, Float> totalPriceColumn;
    @FXML
    private TableColumn<ProductOrder, Float> vatColumn;
    @FXML
    private Button minusButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button cartButton;
    

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Getting user data
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        
        //Initializing and updating TableView
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ProductOrder, String>("name"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<ProductOrder, Float>("price"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<ProductOrder, Float>("totalPrice"));
        vatColumn.setCellValueFactory(new PropertyValueFactory<ProductOrder, Float>("vat"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<ProductOrder, Integer>("quantity"));
        
        ObservableList<Product> productArray = FXCollections.observableArrayList();
        
        Product p = new Product("Soap",20,Product.Category.BODY_SOAP,20);
        ProductOrder po = new ProductOrder(p,2);
        cartTableView.getItems().add(po);
        
        //---
        
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
    private void switchToAccountScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
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
    private void switchToAccountSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }

    @FXML
    private void minusButtonOnClick(ActionEvent event) {
        int q;
        try{
            q = Integer.parseInt(quantityTextField.getText())-1;
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
            return;
        }
        if (q<=1){
            quantityTextField.setText(Integer.toString(1));
        }
        else {
            quantityTextField.setText(Integer.toString(q));
        }
        
    }

    @FXML
    private void plusButtonOnClick(ActionEvent event) {
        int q;
        try{
            q = Integer.parseInt(quantityTextField.getText())+1;
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
            return;
        }
        if (q<=1){
            quantityTextField.setText(Integer.toString(1));
        }
        else {
            quantityTextField.setText(Integer.toString(q));
        }
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        Product p = cartTableView.getSelectionModel().getSelectedItem();
        //Duplicate Checking implemented in Cart class
        current.getCart().add(p,Integer.parseInt(quantityTextField.getText()));
    }

    @FXML
    private void removeButtonOnClick(ActionEvent event) {
        Product p = cartTableView.getSelectionModel().getSelectedItem();
        //Duplicate Checking implemented in Cart class
        current.getCart().remove(p,Integer.parseInt(quantityTextField.getText()));
        
    }
    private void updateCartTable(){
        ArrayList<ProductOrder> productOrderList = current.getCart().getProductOrderList();
        Cart cart = current.getCart();
        //cartTableView.getItems().clear();
        for(ProductOrder po: productOrderList){
            
            System.out.println(po);
            cartTableView.getItems().add(po);
        }
    }

        
    
}
