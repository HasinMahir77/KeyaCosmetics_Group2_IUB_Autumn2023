/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Order;
import HasinMahir.Order.Status;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class RecordsFXMLController implements Initializable {

    @FXML
    private TableView<Order> recordsTableView;
    @FXML
    private TextField searchTextfield;
    @FXML
    private TableColumn<Order, String> nameTable;
    @FXML
    private TableColumn<Order, Status> statusTable;
    @FXML
    private TableColumn<Order, Float> priceTable;
    @FXML
    private TableColumn<Order, LocalTime> timeTable;
    @FXML
    private TableColumn<Order, LocalDate> dateTable;
    @FXML
    private TableColumn<Order, String> idTable;
    @FXML
    private Button showRecordsFXID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTable.setCellValueFactory(new PropertyValueFactory<>("customerUserName"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        timeTable.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        idTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        showRecordsFXID.setDisable(false);
    } 
    

    @FXML
    private void showRecordsOnButtonClicked(ActionEvent event) throws IOException {

        ObjectInputStream ois = null;

            while (true) {
                try {
                    Order order = (Order) ois.readObject();
                    recordsTableView.getItems().addAll(Order.getOrderList());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

        showRecordsFXID.setDisable(true);        

        }

    }
    @FXML
    private void searchTextfieldOnEnterPressed(ActionEvent event) {
            searchTextfield.setText(null);    
    }


    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
    }
    
} 