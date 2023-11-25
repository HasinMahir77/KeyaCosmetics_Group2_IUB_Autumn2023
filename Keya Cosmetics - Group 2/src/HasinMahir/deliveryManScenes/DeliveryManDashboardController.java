/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.Order;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManDashboardController implements Initializable {

    @FXML
    private ImageView keyaIcon;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button pendingTasksButton;
    @FXML
    private Button handoverButton;
    @FXML
    private TableView<Order> orderTableView;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, Float> priceColumn;
    @FXML
    private TableColumn<Order, String> addressColumn;
    @FXML
    private Button viewDetailButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button accountsButton;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    DeliveryMan current;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData(); //Initialized user 
        
        //TableView
        ObservableList<Order> orderList = FXCollections.observableArrayList();
        orderList.addAll(Order.getOrderList());
        orderTableView.setItems(orderList);
        
        idColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Float>("price"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("address"));
    }    

    @FXML
    private void pendingTasksButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void handoverButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void paymentsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void accountsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void lightenGreyButton(MouseEvent event) {
    }

    @FXML
    private void darkenGreyButton(MouseEvent event) {
    }
    
}
