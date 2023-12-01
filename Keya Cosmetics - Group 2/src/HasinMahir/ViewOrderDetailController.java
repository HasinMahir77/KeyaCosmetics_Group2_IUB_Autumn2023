/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class ViewOrderDetailController implements Initializable {

    @FXML
    private Label orderIdLabel;
    @FXML
    private Label orderTimeLabel;
    @FXML
    private Label orderDateLabel;
    @FXML
    private Label deliveryManLabel;
    @FXML
    private Label customerNameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private TableView<OrderedProduct> cartTableView;
    @FXML
    private TableColumn<OrderedProduct, String> nameColumn;
    @FXML
    private TableColumn<OrderedProduct, Integer> unitColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> totalPriceColumn;
    @FXML
    private Label priceLabel;
    @FXML
    private Label statusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Order current = (Order)Order.getStage().getUserData();
        
        this.orderIdLabel.setText("Order ID: "+ current.getId());
        this.priceLabel.setText("Total: " + Float.toString(current.getPrice()) + " BDT");
        this.statusLabel.setText("Status: " + current.getStatus().toString());
        this.orderDateLabel.setText("Order date: " + current.getDate());
        this.orderTimeLabel.setText("Order time: " + current.getTime());
        
        this.customerNameLabel.setText("Name: "+current.getCustomerName() );
        this.addressLabel.setText("Address: " + current.getAddress());
        this.deliveryManLabel.setText(this.deliveryManLabel.getText()+" "+current.getDeliveryManName());
        
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("totalPrice"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        
        this.cartTableView.getItems().addAll(current.getCart().getProductOrderList());
    }    
    
}
