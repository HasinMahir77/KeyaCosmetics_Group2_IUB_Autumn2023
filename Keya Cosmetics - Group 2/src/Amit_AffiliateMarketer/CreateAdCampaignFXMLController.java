package Amit_AffiliateMarketer;

import HasinMahir.Product;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateAdCampaignFXMLController implements Initializable {

    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private ComboBox<String> InfluencerComboBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField budgetTextField;
    @FXML
    private TextArea descriptionTextArea;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <Product> pList = AffiliateMarketer.GetProductList();
        for (int i = 0; i < pList.size(); i ++) {
            productComboBox.getItems().add(pList.get(i).getName());
        }
        
        ObservableList <Influencer> infList = AffiliateMarketer.GetInfluencerList();
        for (int i = 0; i < infList.size(); i ++) {
            InfluencerComboBox.getItems().add(infList.get(i).getName());
        }
    }    
    @FXML
    private void saveButtonClick(MouseEvent event) {
        String productName = productComboBox.getValue();
        String influencerName = InfluencerComboBox.getValue();
        LocalDate durationStarts = startDatePicker.getValue();
        LocalDate durationEnds = endDatePicker.getValue();
        String description = descriptionTextArea.getText();
        int budget = Integer.parseInt(budgetTextField.getText());
        
        Campaign cmp = new Campaign(productName, influencerName, durationStarts, durationEnds, description, budget);
        AffiliateMarketer.AddNewCampaign(cmp);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New campaign has been added successfully");
        a.showAndWait();
    }
}
