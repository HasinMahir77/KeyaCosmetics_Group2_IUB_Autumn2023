/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Cart;
import HasinMahir.Customer;
import HasinMahir.Order;
import HasinMahir.Order.Status;
import HasinMahir.Product;
import HasinMahir.OrderedProduct;
import HasinMahir.Review;
import static HasinMahir.customerScenes.CustomerShopSceneController.current;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerOrderSceneController implements Initializable {

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem accountMenuItem;
    @FXML
    private MenuItem ordersMenuItem;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button cartButton;
    @FXML
    private ImageView keyaIcon;
    @FXML
    private Button shopButton;
    @FXML
    private Label profileLabel;
    @FXML
    private Label securityLabel;
    @FXML
    private Label cartLabel;
    @FXML
    private TableView<Order> orderTableView;
    @FXML
    private PieChart orderPieChart;
    private Order selectedOrder;
    
    
    
    @FXML
    private Label orderLabel;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, Status> statusColumn;
    @FXML
    private TableColumn<Order, Float> priceColumn;
    @FXML
    private Button cancelButton;
    @FXML
    private Button reviewButton;
    @FXML
    private Button returnButton;

    /**
     * Initializes the controller class.
     */
    ObservableList<Order> orderList = FXCollections.observableArrayList();
    @FXML
    private Button viewDetailsButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.selectedOrder = null;
        orderTableView.setPlaceholder(new Label("No orders to show."));
        orderLabel.setTextFill(Color.BLUE);
        // Getting user data
        Customer current = (Customer)Main.getMainStage().getUserData();
        userMenu.setText(current.getUsername()+" ↓");
        
        //Collecting orders
        this.orderTableView.setItems(this.orderList);
        this.updateOrderTable();
        
        
        //TableView
        //orderTableView.setPlaceholder("No orders placed yet");
        idColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Float>("price"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order, Status>("status"));
        
        orderTableView.setItems(orderList);
        //Pie Chart
        
        
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
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #79edad");
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

    private void switchToCartScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void switchToCartSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void switchToAccountScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }

    @FXML
    private void switchToAccountSceneFromLabel(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }

    @FXML
    private void switchToSecurityScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToSecurityScene();
    }

    @FXML
    private void returnButtonOnClick(ActionEvent event) {
        if (this.selectedOrder!=null){
            this.selectedOrder.setStatus(Status.INITIATED_RETURN);
        }
    }

    @FXML
    private void updateSelectedOrder(MouseEvent event) {
       if(!orderTableView.getSelectionModel().isEmpty()){
            this.selectedOrder = orderTableView.getSelectionModel().getSelectedItem();
            this.updateButton();
        } 
    }
    private void updateButton() {
       if (selectedOrder.getStatus()==Status.DELIVERED){
           cancelButton.setDisable(true);
           reviewButton.setDisable(false);
           returnButton.setDisable(false);
           
       }
       else if (selectedOrder.getStatus()==Status.CANCELED){
           cancelButton.setDisable(true);
           reviewButton.setDisable(true);
           returnButton.setDisable(true);
       }
       else if (selectedOrder.getStatus()==Status.INITIATED_RETURN || selectedOrder.getStatus()==Status.RETURNED){
           cancelButton.setDisable(true);
           reviewButton.setDisable(false);
           returnButton.setDisable(true);
       }
       else if (selectedOrder.getStatus()==Status.PENDING || selectedOrder.getStatus()==Status.OUT_FOR_DELIVERY){
           cancelButton.setDisable(false);
           reviewButton.setDisable(true);
           returnButton.setDisable(true);
       }
    }

    @FXML
    private void switchToCartScene(MouseEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }
    private void updateOrderTable(){
        this.orderList.clear();
        this.orderList.addAll(Order.getOrderList());
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
        if (!(this.selectedOrder==null)){
            this.selectedOrder.setStatus(Status.CANCELED);
        }
        this.selectedOrder.saveInstance();
    }

    @FXML
    private void reviewButtonOnClick(ActionEvent event) throws IOException {
        if (this.selectedOrder!=null){
            this.selectedOrder.addReview(current.getUsername());
        }
    }
    private void updatePieChart(){
        if (this.selectedOrder!=null){
        }
        
        
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void switchToOrderSceneFromLabel(MouseEvent event) {
    }

    
}
