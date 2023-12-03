
package Amit_AffiliateMarketer;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ViewAdCampaignListFXMLController implements Initializable {

    @FXML
    private TableView<Campaign> tableView;
    @FXML
    private TableColumn<Campaign, String> productColumn;
    @FXML
    private TableColumn<Campaign, String> influencerColumn;
    @FXML
    private TableColumn<Campaign, LocalDate> startsColumn;
    @FXML
    private TableColumn<Campaign, LocalDate> endsColumn;
    @FXML
    private TableColumn<Campaign, Integer> budgetColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productColumn.setCellValueFactory(new PropertyValueFactory<Campaign, String>("productName"));
        influencerColumn.setCellValueFactory(new PropertyValueFactory<Campaign, String>("influencerName"));
        startsColumn.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("durationStarts"));
        endsColumn.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("durationEnds"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<Campaign, Integer>("budget"));
        
        tableView.getItems().addAll(AffiliateMarketer.GetCampaignList());
    }    

    @FXML
    private void seeDescriptionButtonClick(MouseEvent event) throws IOException {
        
        Campaign cmp = tableView.getSelectionModel().getSelectedItem();
        
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeeCampaignDescriptionFXML.fxml"));
        Parent root = loader.load();
        SeeCampaignDescriptionFXMLController ctrl = loader.getController();
        ctrl.data(cmp);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    private void saveTableViewContentAsPDF(ObservableList<Campaign> items, String filePath) {
        try {
            PdfWriter pdfWriter = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            for (Campaign campaign : items) {
                document.add(new Paragraph("Influencers Name: " + campaign.getInfluencerName()));
                document.add(new Paragraph("Name: " + campaign.getProductName()));
                document.add(new Paragraph("Budget: " + campaign.getBudget()));
                document.add(new Paragraph("Starts: " + campaign.getDurationStarts()));
                document.add(new Paragraph("Ends: " + campaign.getDurationEnds()));
                
            
                
              

                document.add(new Paragraph("\n")); // Add space between entries
            }

            document.close();

            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
