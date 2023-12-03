/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Cart;
import HasinMahir.Customer;
import HasinMahir.Order;
import HasinMahir.Product;
import HasinMahir.OrderedProduct;
import HasinMahir.User;
import static HasinMahir.customerScenes.CustomerShopSceneController.current;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import mainpkg.MainpkgSS;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerCartSceneController implements Initializable {
    private static Stage checkoutStage;

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
    private Label profileLabel;
    @FXML
    private Label cartLabel;
    @FXML
    private TableView<OrderedProduct> cartTableView;
    @FXML
    private TableColumn<OrderedProduct, String> nameColumn;
    @FXML
    private TableColumn<OrderedProduct, Integer> quantityColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> unitPriceColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> vatColumn;
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
    
    OrderedProduct selectedProduct;
    @FXML
    private Label securityLabel;
    @FXML
    private Button orderButton;
    @FXML
    private Label grandTotalLabel;
    @FXML
    private TableColumn<OrderedProduct, Float> PriceColumn;
    

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (new File("OrderList.bin").exists()){
            for (Order o: Order.getOrderList()){System.out.println(o);}
        }
        cartTableView.setPlaceholder(new Label("No products in cart."));
        cartLabel.setTextFill(Color.BLUE);
        // Getting user data
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        //Setting quantity text field 
        
        quantityTextField.setText("1");
        
        //Initializing and updating TableView
        
        OrderedProduct selectedProduct = cartTableView.getSelectionModel().getSelectedItem();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("unitPrice"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("Price"));
        vatColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("vat"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        
       
        this.updateCartTable();
        
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
        if (this.cartTableView.getItems().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please add products to cart first.").show();
        }
        try{
            OrderedProduct po = this.selectedProduct;
            int quantity = Integer.parseInt(quantityTextField.getText());
            //Duplicate Checking implemented in Cart class
            current.getCart().add(po,quantity);
            this.updateCartTable();
            this.updateGrandTotal();
        }
        catch(NumberFormatException e){
            quantityTextField.setText("1");
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
        }
        catch(NullPointerException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select a product.");
            a.showAndWait();
        }
    }

    @FXML
    private void removeButtonOnClick(ActionEvent event) {
        try{
            Product p = this.selectedProduct;
            //Duplicate Checking implemented in Cart class
            current.getCart().remove(p,Integer.parseInt(quantityTextField.getText()));
            this.updateCartTable();
            this.updateGrandTotal();
        }
        catch(NumberFormatException e){
            quantityTextField.setText("1");
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
        }
        catch(NullPointerException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select a product.");
            a.showAndWait();
        }
        
    }
    private void updateCartTable(){
        Cart cart = current.getCart();
        cartTableView.getItems().clear();
        cartTableView.getItems().addAll(current.getCart().getProductOrderList());
        current.saveInstance();
        
        //Updating total
        ArrayList<OrderedProduct> products = current.getCart().getProductOrderList();
        Float grandTotal = new Float(0);
        
        for(OrderedProduct p: products){
            grandTotal = grandTotal+p.getTotalPrice();
        }
        grandTotalLabel.setText(grandTotal.toString()+" BDT");
    }

    @FXML
    private void updateSelectedProduct(MouseEvent event) {
        if(!cartTableView.getSelectionModel().isEmpty()){
            this.selectedProduct = cartTableView.getSelectionModel().getSelectedItem();
        } 
    }
    

    @FXML
    private void orderButtonOnClick(ActionEvent event) throws IOException {
 
        Parent root = FXMLLoader.load(getClass().getResource("CustomerCheckout.fxml"));
        Scene scene = new Scene(root);
        checkoutStage.setScene(scene);
        checkoutStage.show();
        /*
        current.placeOrder(order);
        current.saveInstance();
        
        current.getCart().getProductOrderList().clear();
        this.updateCartTable();
        
        //
        for (Order o: Order.getOrderList()){System.out.println(o);}*/
        
    }
    public void updateGrandTotal(){
        
    }

    @FXML
    private void switchToSecurityScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToSecurityScene();
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
    public static Stage getCheckoutStage(){
        return checkoutStage;
    }
    
}
