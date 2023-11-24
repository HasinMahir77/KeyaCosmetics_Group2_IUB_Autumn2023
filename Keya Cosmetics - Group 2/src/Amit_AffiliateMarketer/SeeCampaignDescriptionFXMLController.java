
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class SeeCampaignDescriptionFXMLController implements Initializable {

    @FXML
    private TextArea descriptionTextArea;
    public void data(Campaign cmp) {
        descriptionTextArea.setText(cmp.getDescription());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
