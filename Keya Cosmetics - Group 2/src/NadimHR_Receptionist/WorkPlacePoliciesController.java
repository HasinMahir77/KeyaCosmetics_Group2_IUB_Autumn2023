/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import static com.itextpdf.io.IOException.PdfEncodings;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class WorkPlacePoliciesController implements Initializable {

    @FXML
    private TextArea termslabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Hr HR = new Hr();
        String policyText = HR.loadPolicy();
        termslabel.setText(policyText);
        termslabel.setEditable(false);
    }

    @FXML
    private void saveAsPDF(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            createPDF(file);
        }
    }

    private void createPDF(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            PdfWriter pdfWriter = new PdfWriter(fos);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            // Add content to PDF
            document.add(new Paragraph("Workplace Policies"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph(termslabel.getText()));

            document.close();

            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
