/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

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
    private MenuItem accountMenuItem;
    @FXML
    private MenuItem ordersMenuItem;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private Button dashboardButton1;
    @FXML
    private Button tasksButton;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TableView<?> taskTableView;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private TableColumn<?, ?> addressColumn;
    @FXML
    private TableColumn<?, ?> addressColumn1;
    @FXML
    private VBox dashboardButton;
    @FXML
    private Button viewDetailButton;
    @FXML
    private Button taskButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToAccountScene(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void lightenUserMenuBar(MouseEvent event) {
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
    }

    @FXML
    private void lightenGreyButton(MouseEvent event) {
    }

    @FXML
    private void darkenGreyButton(MouseEvent event) {
    }

    @FXML
    private void tasksButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void paymentsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void profileButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void updateSelectedTask(MouseEvent event) {
    }

    @FXML
    private void viewDetailButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void taskButtonOnClick(ActionEvent event) {
    }
    
}
