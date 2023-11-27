
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class AnalyzeInfluencersOnClickFXMLController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        ObservableList <Influencer> infList = AffiliateMarketer.GetInfluencerList();
        
        for (int i = 0; i < infList.size(); i ++) {
            series.getData().add(new XYChart.Data<String,Number>(infList.get(i).getName(),infList.get(i).getFollowers()));
        }
        barChart.getData().add(series);
    }
}
