/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.Product;
<<<<<<< HEAD
import HasinMahir.OrderedProduct;
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
import HasinMahir.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.paint.Color;
import mainpkg.LogoutSceneSwitcher;
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
    private Label searchLabel;
    @FXML
    private TableColumn<Product, String> nameColumn;
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
<<<<<<< HEAD
    private TableView<OrderedProduct> cartTableView;
    @FXML
    private TableColumn<OrderedProduct, String> nameColumn;
    @FXML
    private TableColumn<OrderedProduct, Integer> quantityColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> unitPriceColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> totalPriceColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> vatColumn;
=======
    private TableView<?> cartTable;
    @FXML
    private TableColumn<?, ?> quantityColumn;
    @FXML
    private TableColumn<?, ?> unitPriceColumn;
    @FXML
    private TableColumn<?, ?> totalPriceColumn;
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
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
<<<<<<< HEAD
    
    OrderedProduct selectedProduct;
    @FXML
    private Label securityLabel;
    @FXML
    private Button orderButton;
    @FXML
    private Label grandTotalLabel;
    
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
<<<<<<< HEAD
        //Setting quantity text field 
        
        quantityTextField.setText("1");
        
        //Initializing and updating TableView
        
        OrderedProduct selectedProduct = cartTableView.getSelectionModel().getSelectedItem();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("price"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("totalPrice"));
        vatColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("vat"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        
       
        this.updateCartTable();
        this.updateGrandTotal();
        
        //---
=======
        cartLabel.setTextFill(Color.BLUE);
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
        
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
        LogoutSceneSwitcher logout = new LogoutSceneSwitcher();
        logout.switchScene();
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
        
<<<<<<< HEAD
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
    }

    @FXML
    private void updateSelectedProduct(MouseEvent event) {
        if(!cartTableView.getSelectionModel().isEmpty()){
            this.selectedProduct = cartTableView.getSelectionModel().getSelectedItem();
        } 
    }
    

    @FXML
    private void orderButtonOnClick(ActionEvent event) {
        //PLACEHOLDER CODE. CLEARS CART.
        Order order = new Order(current);
        order.saveInstance();
        
    }
    public void updateGrandTotal(){
        ArrayList<OrderedProduct> products = current.getCart().getProductOrderList();
        Float grandTotal = new Float(0);
        
        for(OrderedProduct p: products){
            grandTotal = grandTotal+p.getTotalPrice()+p.getVat();
        }
        grandTotalLabel.setText(grandTotal.toString()+" BDT");
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
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
    
}
