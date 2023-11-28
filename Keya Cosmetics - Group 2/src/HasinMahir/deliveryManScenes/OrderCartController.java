/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.Cart;
import HasinMahir.Order;
import HasinMahir.OrderedProduct;
import HasinMahir.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class OrderCartController implements Initializable {

    @FXML
    private Label orderIdLabel;
    @FXML
    private TableColumn<OrderedProduct, String> nameColumn;
    @FXML
    private TableColumn<OrderedProduct, Integer> unitColumn;
    @FXML
    private TableColumn<OrderedProduct, Float> totalPriceColumn;

    /**
     * Initializes the controller class.
     */
    ObservableList<Product> productArray = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> cartTableView;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Cart cart = null;
        Stage stage = (Stage)cartTableView.getParent().getScene().getWindow();
       
        nameColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, String>("name"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Integer>("quantity"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<OrderedProduct, Float>("totalPrice"));
        
        try{
            cart = (Cart)stage.getUserData();
        }
        catch(Exception e){e.printStackTrace(System.out);}
        
        if (cart!=null){
            cartTableView.getItems().addAll(cart.getProductOrderList());
        }
    }    
    
}
