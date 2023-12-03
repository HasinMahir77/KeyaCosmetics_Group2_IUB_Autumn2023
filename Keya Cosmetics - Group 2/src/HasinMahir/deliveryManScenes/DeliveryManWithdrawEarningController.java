/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.DeliveryMan;
import HasinMahir.DeliveryPayment;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class DeliveryManWithdrawEarningController implements Initializable {

    @FXML
    private ListView<DeliveryPayment> paymentListView;
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
    DeliveryMan current;
    DeliveryPayment selectedPayment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // TODO
        
        current = (DeliveryMan)Main.getUserData(); //Initialized user 
        this.selectedPayment=null;
        
        
        nameLabel.setText(nameLabel.getText()+" "+current.getFirstName()+" "+current.getLastName());
        dojLabel.setText(dojLabel.getText()+" "+current.getDoj().toString());
        phoneLabel.setText(phoneLabel.getText()+" "+current.getPhone().toString());
        current.setDob(LocalDate.now());
        dobLabel.setText(dobLabel.getText()+" "+current.getDob().toString());
        balanceLabel.setText(balanceLabel.getText()+" "+current.getBalance());
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
    private void updateSelectedOrder(MouseEvent event) {
        if(!paymentListView.getSelectionModel().isEmpty()){
            this.selectedPayment = paymentListView.getSelectionModel().getSelectedItem();
        } 
    }
}
