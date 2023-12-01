/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class AuditReportViewFXMLController implements Initializable {

    @FXML
    private TableView<AuditReport> tableView;
    @FXML
    private TableColumn<AuditReport, LocalDate> dateTableColumn;
    @FXML
    private TableColumn<AuditReport, String> titleTableColumn;
    @FXML
    private TextArea detailedTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                detailedTextArea.setText(newSelection.getDetailedReport());
            }
        });

        // Load audit reports into the table
        tableView.setItems(FXCollections.observableList(AuditReport.loadAuditReportRecords()));
    }  

    @FXML
    private void goBackToAudit(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.goBackToAudit();
    }
    
}
