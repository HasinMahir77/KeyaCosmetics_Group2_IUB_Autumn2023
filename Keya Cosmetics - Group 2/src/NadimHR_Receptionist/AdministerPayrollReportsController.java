/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;
import NadimHR_Receptionist.DataService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdministerPayrollReportsController implements Initializable {

    @FXML
    private TableView<Applicant> payrollTableView;

    @FXML
    private TableColumn<Applicant, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Applicant, String> employeeNameColumn;

    @FXML
    private TableColumn<Applicant, Double> salaryColumn;

    @FXML
    private TableColumn<Applicant, LocalDate> paymentDateColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void initializeTableView() {

    }

    @FXML
    private void loadOnClick(ActionEvent event) {

    }

    @FXML
    private void makepdfOnClick(ActionEvent event) {

    }
}
