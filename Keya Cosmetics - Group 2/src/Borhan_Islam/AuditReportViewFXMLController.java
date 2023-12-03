/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import NadimHR_Receptionist.Applicant;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

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

    @FXML
    private void generatePDF(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            saveTableViewContentAsPDF(tableView.getItems(), file.getAbsolutePath());
        }
    }

    private void saveTableViewContentAsPDF(ObservableList<AuditReport> items, String filePath) {
        try {
            PdfWriter pdfWriter = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            for (AuditReport audit : items) {
                document.add(new Paragraph("Date: " + audit.getDate()));
                document.add(new Paragraph("Title: " + audit.getTitle()));
                document.add(new Paragraph("Report: " + audit.getDetailedReport()));

                document.add(new Paragraph("\n")); // Add space between entries
            }

            document.close();

            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
