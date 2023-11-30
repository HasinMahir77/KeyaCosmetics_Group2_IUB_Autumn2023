/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.Order;
import HasinMahir.DeliveryPayment;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableView<Order> taskTableView;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, Float> priceColumn;
    @FXML
    private TableColumn<Order, String> addressColumn;
    @FXML
    private TableColumn<Order, String> addressColumn1;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button viewDetailButton;
    @FXML
    private Button taskButton;

    /**
     * Initializes the controller class.
     */
    Order selectedOrder;
    DeliveryMan current;
    @FXML
    private TableView<Order> orderTableView;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedOrder = null;
        current = (DeliveryMan)Main.getUserData();
    }    


   
    @FXML
    private void tasksButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToTasks();
    }

    @FXML
    private void paymentsButtonOnClick(ActionEvent event) throws IOException {
        DMSS ss = new DMSS();
        ss.switchToPayments();
    }

    @FXML
    private void updateSelectedOrder(MouseEvent event) {
        if(!orderTableView.getSelectionModel().isEmpty()){
            this.selectedOrder = taskTableView.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    private void viewDetailButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void taskButtonOnClick(ActionEvent event) {
        //Nothing
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
    
}