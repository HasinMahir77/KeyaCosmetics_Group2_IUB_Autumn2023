/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.Order;
import HasinMahir.DeliveryPayment;
import HasinMahir.Order.Status;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManTasksController implements Initializable {

    @FXML
    private ImageView keyaIcon;
    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button tasksButton;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TableView<Order> orderTableView;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, Float> priceColumn;
    @FXML
    private TableColumn<Order, String> addressColumn;
    @FXML
    private TableColumn<Order, Status> statusColumn;
    @FXML
    private Button doTaskButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button viewDetailButton;

    /**
     * Initializes the controller class.
     */
    Order selectedOrder;
    DeliveryMan current;
    ObservableList<Order> orderList;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedOrder = null;
        current = (DeliveryMan)Main.getUserData();
        
        //TableView
        idColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order, Status>("status"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("address"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Float>("price"));
        
        //Getting Orders
        orderList = FXCollections.observableArrayList();
        orderTableView.setItems(orderList);
        this.updateOrderTable();
        
    }    


   
    @FXML
    private void tasksButtonOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void paymentsButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToPayments();
    }

    @FXML
    private void updateSelectedOrder(MouseEvent event) {
        if(!orderTableView.getSelectionModel().isEmpty()){
            this.selectedOrder = orderTableView.getSelectionModel().getSelectedItem();
            
            //Updating the disabled do task button
            doTaskButton.setDisable(false);
            
            if (selectedOrder.getStatus()==Status.OUT_FOR_DELIVERY){
                doTaskButton.setText("Deliver");
            }
            else{
                doTaskButton.setText("Return");
            }
        }
    }

    @FXML
    private void viewDetailButtonOnClick(ActionEvent event) throws IOException {
        if (selectedOrder==null){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select an order");
        }
        else if (this.orderList.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR,"No orders available");
        }
        else {
            selectedOrder.viewDetails();
        }
    }

    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        current.saveInstance();
        MainpkgSS ss = new MainpkgSS();
        ss.switchtoLoginScene();
    }

    @FXML
    private void lightenGreyButton(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color:  #eef0f5");
    }

    @FXML
    private void darkenGreyButton(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #d0d0db");
    }

    @FXML
    private void profileButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToProfile();;
    }


    @FXML
    private void lightenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #79edad");
    }

    @FXML
    private void dashboardButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToDashboard();
    }
    private void updateOrderTable() {
        this.orderList.clear();
        for (Order o: Order.getOrderList()){
            if (o.getStatus()==Order.Status.OUT_FOR_DELIVERY || o.getStatus()==Order.Status.OUT_FOR_RETURN){
                this.orderList.add(o);
            }
        }
        
    }

    @FXML
    private void doTaskButtonOnClick(ActionEvent event) {
        if (selectedOrder==null){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select an order");
        }
        else if (this.orderList.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR,"No orders available");
        }
        else if(selectedOrder.getStatus()==Status.OUT_FOR_DELIVERY) {
            current.deliverOrder(selectedOrder);
            //Instance saved in dm class
        }
        else if(selectedOrder.getStatus()==Status.OUT_FOR_RETURN) {
            current.deliverOrder(selectedOrder);
            //Instance saved in dm class
        }
        this.updateOrderTable();
    }
}
