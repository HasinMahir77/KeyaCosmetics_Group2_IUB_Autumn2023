
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewInfluencerListFXMLController implements Initializable {

    @FXML
    private TableView<Influencer> tableView;
    @FXML
    private TableColumn<Influencer, String> nameColumn;
    @FXML
    private TableColumn<Influencer, String> socialMediaIDColumn;
    @FXML
    private TableColumn<Influencer, Integer> followersColumn;
    @FXML
    private TableColumn<Influencer, String> genderColumn;
    @FXML
    private TableColumn<Influencer, Integer> AgeOfInfColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Influencer, String>("name"));
        socialMediaIDColumn.setCellValueFactory(new PropertyValueFactory<Influencer, String>("socialMediaID"));
        followersColumn.setCellValueFactory(new PropertyValueFactory<Influencer, Integer>("followers"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Influencer, String>("gender"));
        AgeOfInfColumn.setCellValueFactory(new PropertyValueFactory<Influencer, Integer>("ageOfInfuence"));
        tableView.getItems().addAll(AffiliateMarketer.GetInfluencerList());
    }       
}
