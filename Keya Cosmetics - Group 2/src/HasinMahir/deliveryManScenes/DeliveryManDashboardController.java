/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.Order;
import HasinMahir.Order.Status;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManDashboardController implements Initializable {
    DMSS ss = new DMSS();

    @FXML
    private ImageView keyaIcon;
    @FXML
    private Button dashboardButton;
    @FXML
    private TableView<Order> orderTableView;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, String> addressColumn;
    @FXML
    private TableColumn<Order, Status> statusColumn;
    @FXML
    private Button viewDetailButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    private DeliveryMan current;
    private Order selectedOrder;
    @FXML
    private Label nameLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label dojLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Button profileButton;
    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button tasksButton;
    ObservableList<Order> orderList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData(); //Initialized user 
        this.selectedOrder=null;
        
        
        nameLabel.setText(nameLabel.getText()+" "+current.getFirstName()+" "+current.getLastName());
        dojLabel.setText(dojLabel.getText()+" "+current.getDoj().toString());
        phoneLabel.setText(phoneLabel.getText()+" "+current.getPhone().toString());
        current.setDob(LocalDate.now());
        dobLabel.setText(dobLabel.getText()+" "+current.getDob().toString());
        balanceLabel.setText(balanceLabel.getText()+" "+current.getBalance());
        
        //TableView
        idColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order, Status>("status"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("address"));
        
        //Getting Orders
        orderList = FXCollections.observableArrayList();
        orderTableView.setItems(orderList);
        this.updateOrderTable();
         
    }    



    @FXML
    private void paymentsButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToPayments();
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
        ss.switchToProfile();
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
    private void viewDetailButtonOnClick(ActionEvent event) throws IOException {
        if (selectedOrder!=null && !this.orderTableView.getItems().isEmpty()){
            System.out.println("view cart now");
            selectedOrder.viewCart();
        }
    }

    @FXML
    private void acceptButtonOnClick(ActionEvent event) {
        if (selectedOrder!=null && !this.orderTableView.getItems().isEmpty()){
            current.acceptOrder(this.selectedOrder);
            this.updateOrderTable();
            //Payment generated in DM class
            
        }
    }

    private void updateOrderTable() {
        this.orderList.clear();
        for (Order o: Order.getOrderList()){
            if (o.getStatus()==Status.PENDING || o.getStatus()==Status.INITIATED_RETURN){
                this.orderList.add(o);
            }
        }
        
    }

    @FXML
    private void tasksButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToTasks();
    }

    @FXML
    private void updateSelectedOrder(MouseEvent event) {
        if(!orderTableView.getSelectionModel().isEmpty()){
            this.selectedOrder = orderTableView.getSelectionModel().getSelectedItem();
        } 
    }
    
 
}
