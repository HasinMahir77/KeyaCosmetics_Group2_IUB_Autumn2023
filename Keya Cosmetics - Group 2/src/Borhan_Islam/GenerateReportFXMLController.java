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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class GenerateReportFXMLController implements Initializable {

    @FXML
    private TableView<Expense> tableView;
    @FXML
    private TableColumn<Expense, String> nameColumn;
    @FXML
    private TableColumn<Expense, String> categoryColumn;
    @FXML
    private TableColumn<Expense, Float> amountColumn;
    @FXML
    private TextArea reportTextArea;
    @FXML
    private Label nameLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label dateLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));   
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableView.getItems().addAll(Expense.loadAllExpenseRecords()); 
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               // detailedTextArea.setText(newSelection.getDetailedReport());
               nameLabel.setText(newSelection.getName());
               categoryLabel.setText(newSelection.getCategory());
               amountLabel.setText(newSelection.getAmount().toString());
               dateLabel.setText(newSelection.getDate().toString());
            }
        });        
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard();
    }

    @FXML
    private void saveButton(ActionEvent event) {
        String name = nameLabel.getText();
        String category = categoryLabel.getText();
        Float amount = Float.valueOf(amountLabel.getText());
        String date=dateLabel.getText();
        String report=reportTextArea.getText();

        if (showConfirmationAlert("Are you sure you want to save this report?")) {        
            GenerateReport.saveGeneratedReports(name, category, amount, date, report);
            showSuccessAlert("Report saved successfully.");
        }        

    }
    public void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText(message);

        return alert.showAndWait().orElse(null).equals(ButtonType.OK);
    }

    public void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }     
}
