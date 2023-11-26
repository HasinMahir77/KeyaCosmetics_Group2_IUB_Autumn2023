
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;


public class TrackCampaignOnBudgetOnClickFXMLController implements Initializable {

    @FXML
    private PieChart pieChart;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <Campaign> cmpList = AffiliateMarketer.GetCampaignList();
        for (int i = 0; i < cmpList.size(); i ++) {
            String ss = cmpList.get(i).getProductName() + ", " + cmpList.get(i).getInfluencerName();
            list.add( new PieChart.Data(ss,cmpList.get(i).getBudget()));
        }
        pieChart.setData(list);
    }    
    
}
