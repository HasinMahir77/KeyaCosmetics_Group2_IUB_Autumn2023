
package Amit_AffiliateMarketer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    
}
