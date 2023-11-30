/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.DeliveryPayment;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mainpkg.Main;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManPaymentsController implements Initializable {
    DMSS ss = new DMSS();
    @FXML
    private ImageView keyaIcon;
    @FXML
    private MenuBar userMenuBar;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button tasksButton;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TabPane mainTabPane;
    @FXML
    private Tab depositTab;
    @FXML
    private ListView<DeliveryPayment> paymentListView;
    @FXML
    private Tab withdrawTab;

    /**
     * Initializes the controller class.
     */
    DeliveryMan current;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData();
        
    }    


    @FXML
    private void dashboardButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToDashboard();
    }

    @FXML
    private void tasksButtonOnClick(ActionEvent event) throws IOException {
        ss.switchToTasks();
    }


    @FXML
    private void withdrawTabOnClick(Event event) throws IOException {
        if (withdrawTab.getContent()==null){
            Parent root = FXMLLoader.load(getClass().getResource("DeliveryManWithdrawEarning.fxml"));
        withdrawTab.setContent(root);
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
    
}
