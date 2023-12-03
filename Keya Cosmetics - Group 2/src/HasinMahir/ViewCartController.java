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
public class ViewCartController implements Initializable {

    @FXML
    private Label orderIdLabel;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Order current = (Order)Order.getStage().getUserData();
        
        if (current!=null){System.out.println("Order received from userdata");}
        
        this.orderIdLabel.setText("Order ID: "+ current.getId());
        this.priceLabel.setText("Total: " + Float.toString(current.getPrice()) + " BDT");
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("totalPrice"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        
        System.out.println(current.getCart().getProductOrderList());
        this.cartTableView.getItems().addAll(current.getCart().getProductOrderList());
    
    }    
    
}
