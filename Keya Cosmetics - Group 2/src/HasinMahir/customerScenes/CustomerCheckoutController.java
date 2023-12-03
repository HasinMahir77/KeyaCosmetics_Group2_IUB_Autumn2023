/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Cart;
import HasinMahir.Customer;
import HasinMahir.Order;
import HasinMahir.OrderedProduct;
import static HasinMahir.customerScenes.CustomerShopSceneController.current;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerCheckoutController implements Initializable {

    @FXML
    private TableView<OrderedProduct> cartTableView;
    @FXML
    private TableColumn<OrderedProduct, String> nameColumn;
    @FXML
    private TableColumn<OrderedProduct, Integer> unitColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> totalPriceColumn;
    @FXML
    private RadioButton bKashRadioButton;
    @FXML
    private RadioButton bankRadioButton;
    @FXML
    private RadioButton cashRadioButton;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label afterPurchaseLabel;
    @FXML
    private Button payButton;
    @FXML
    private Label totalLabel;
    Customer current;
    Cart cart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        current = (Customer) Main.getUserData();
        cart = current.getCart();
        
        Float balanceAP = current.getBalance()-cart.getPrice();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("totalPrice"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        
        System.out.println(current.getCart().getProductOrderList());
        this.cartTableView.getItems().addAll(current.getCart().getProductOrderList());
        
        this.balanceLabel.setText(this.balanceLabel.getText()+" "+current.getBalance());
        this.afterPurchaseLabel.setText(this.afterPurchaseLabel.getText()+" "+balanceAP);
        this.totalLabel.setText(this.totalLabel.getText()+" "+cart.getPrice());
    }    

    @FXML
    private void bKashRadioButtonOnAction(ActionEvent event) {
        this.bankRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void bankRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void cashRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.bankRadioButton.setSelected(false);
    }

    @FXML
    private void payButtonOnAction(ActionEvent event) {
        if (this.bKashRadioButton.isSelected() || this.cashRadioButton.isSelected() || this.bankRadioButton.isSelected()){
            if (current.getBalance()>=cart.getPrice()){
                Order order = new Order(current);
                order.setCart(current.getCart());
                current.placeOrder(order);
                current.saveInstance();
        
                current.getCart().getProductOrderList().clear();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Insufficient balance.").showAndWait();
                return;
            }
            
            
        }
    }
    
}
