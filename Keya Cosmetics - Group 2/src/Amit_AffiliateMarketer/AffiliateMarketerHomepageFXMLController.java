
package Amit_AffiliateMarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class AffiliateMarketerHomepageFXMLController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void submitContentOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void reviewProductOnClick(ActionEvent event) throws IOException {
<<<<<<< HEAD
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReviewProductsFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
=======
        Review r = new Review();
        r.setSender(this.am.getUsername());
        Product p = new Product("Soap",20,Category.BODY_SOAP,5);
        r.takeReview(p);
        System.out.println(r.getReview());
        System.out.println(r.getRating());
              
       
        
        
>>>>>>> origin/AmitRoy
    }

    @FXML
    private void generateCouponCode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GenerateCouponCodeFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void addNewInfluencerOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewInfluencerFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void viewInfluencerListOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewInfluencerListFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void createAdCampaignOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAdCampaignFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void viewAdCampaignListOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAdCampaignListFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void analyzeInfluencersOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnalyzeInfluencersOnClickFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void trackCampaignOnBudgetOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TrackCampaignOnBudgetOnClickFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void trackCampaignOnDurationOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TrackCampaignOnDurationOnClickFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }
    
}
