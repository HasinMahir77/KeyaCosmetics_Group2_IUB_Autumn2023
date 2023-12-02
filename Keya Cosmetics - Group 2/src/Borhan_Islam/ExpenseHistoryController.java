/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ExpenseHistoryController implements Initializable {

    @FXML
    private TableView<Expense> tableView;
    @FXML
    private TableColumn<Expense, String> nameColumn;
    @FXML
    private TableColumn<Expense, String> categoryColumn;
    @FXML
    private TableColumn<Expense, Float> amountColumn;
    @FXML
    private TableColumn<Expense, LocalDate> dateColumn;
    @FXML
    private TableColumn<Expense, String> paymentmethodColumn;
    @FXML
    private TableColumn<Expense, String> referenceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        paymentmethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        referenceColumn.setCellValueFactory(new PropertyValueFactory<>("reference"));
        tableView.getItems().addAll(Expense.loadAllExpenseRecords());    
    
    }    

    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.goBackButton();
    }
    
}
