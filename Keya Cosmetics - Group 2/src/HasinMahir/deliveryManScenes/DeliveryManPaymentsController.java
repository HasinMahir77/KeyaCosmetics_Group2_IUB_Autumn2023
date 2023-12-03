/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.DeliveryPayment;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
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
    DeliveryMan current;
    DeliveryPayment selectedPayment;

    /**
     * Initializes the controller class.
     */
    @FXML
    private RadioButton bKashRadioButton;
    @FXML
    private RadioButton bankRadioButton;
    @FXML
    private RadioButton cashRadioButton;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label dojLabel;
    @FXML
    private Label balanceLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = (DeliveryMan)Main.getUserData();
        selectedPayment = null;
        
        //Labels 
         nameLabel.setText(nameLabel.getText()+" "+current.getFirstName()+" "+current.getLastName());
        dojLabel.setText(dojLabel.getText()+" "+current.getDoj().toString());
        phoneLabel.setText(phoneLabel.getText()+" "+current.getPhone().toString());
        current.setDob(LocalDate.now());
        dobLabel.setText(dobLabel.getText()+" "+current.getDob().toString());
        balanceLabel.setText(balanceLabel.getText()+" "+current.getBalance());
        
        //Listview
        this.updateListView();
        
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

    @FXML
    private void bKashRadioButtonOnAction(ActionEvent event) {
        this.bankRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void bankRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.cashRadioButton.setSelected(false);
    }

    @FXML
    private void cashRadioButtonOnAction(ActionEvent event) {
        this.bKashRadioButton.setSelected(false);
        this.bankRadioButton.setSelected(false);
    }

    @FXML
    private void updateSelectedPayment(MouseEvent event) {
        if (!this.paymentListView.getItems().isEmpty()){
            this.selectedPayment = this.paymentListView.getSelectionModel().getSelectedItem();
        }
        
    }

    @FXML
    private void depositButtonOnAction(ActionEvent event) {
        if (this.selectedPayment==null){
            new Alert(Alert.AlertType.ERROR,"Please select a payment").show();
            return;
        }
        else{
            current.setBalance(current.getBalance()+selectedPayment.getAmount());
            selectedPayment.setDone();
            current.saveInstance();
            this.updateListView();
            balanceLabel.setText("Balance: "+current.getBalance());
        }
    }
    private void updateListView(){
        this.paymentListView.getItems().clear();
        for (DeliveryPayment dp: current.getPaymentDepositList()){
            if (!dp.isDone()){
                this.paymentListView.getItems().add(dp);
            }
        }
        
    }
}
