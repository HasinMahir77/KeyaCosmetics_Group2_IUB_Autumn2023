/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
public class SeePayrollRecordsFXMLController implements Initializable {

    @FXML
    private TableView<Payroll> tableView;
    @FXML
    private TableColumn<Payroll, String> nameTable;
    @FXML
    private TableColumn<Payroll, String> desigTable;
    @FXML
    private TableColumn<Payroll, Float> basicTable;
    @FXML
    private TableColumn<Payroll, Float> bonusTable;
    @FXML
    private TableColumn<Payroll, String> bonusTypeTable;
    @FXML
    private TableColumn<Payroll, Float> deductionsTable;
    @FXML
    private TableColumn<Payroll, LocalDate> paydateTable;
    @FXML
    private TableColumn<Payroll, Float> netSalaryTable;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        desigTable.setCellValueFactory(new PropertyValueFactory<>("desig"));
        basicTable.setCellValueFactory(new PropertyValueFactory<>("salary"));
        bonusTable.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        bonusTypeTable.setCellValueFactory(new PropertyValueFactory<>("bonustype"));
        deductionsTable.setCellValueFactory(new PropertyValueFactory<>("deductions"));
        paydateTable.setCellValueFactory(new PropertyValueFactory<>("paymentdate"));
        netSalaryTable.setCellValueFactory(new PropertyValueFactory<>("netsalary"));         
        tableView.getItems().addAll(Payroll.loadPayrollRecords());  
    }
}
