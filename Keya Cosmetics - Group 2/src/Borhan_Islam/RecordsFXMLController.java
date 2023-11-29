/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Order;
import HasinMahir.Order.Status;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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
    private Button filterfxid;
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
    private void showRecordsOnButtonClicked(ActionEvent event) {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("OrderList.bin"));

            while (true) {
                try {
                    // Read an object of type HasinMahir.Order
                    Order order = (Order) ois.readObject();

                    // Add the converted record to the TableView
                    recordsTableView.getItems().add(order);
                    System.out.println(order.getPrice());
                } catch (EOFException e) {
                    // End of file reached
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    // Handle the exception if the class is not found
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
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
    private void editOnButtonClicked(ActionEvent event) {
//       Records records = new Records(  
//            nameText.getText(),
//            Integer.parseInt(idText.getText()),
//            Double.parseDouble(salaryText.getText())  
//            );
//        nameText.setText(null); idText.setText(null);  salaryText.setText(null);
//        employee.display();
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(
//                    new FileOutputStream("Stud.bin", true)
//            );
//            oos.writeObject(employee);
//            oos.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    
    }

    @FXML
    private void filterOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
    }
    
} 