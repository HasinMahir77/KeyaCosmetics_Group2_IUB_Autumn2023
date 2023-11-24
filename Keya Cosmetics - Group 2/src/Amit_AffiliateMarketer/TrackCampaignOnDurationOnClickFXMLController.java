package Amit_AffiliateMarketer;

import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class TrackCampaignOnDurationOnClickFXMLController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        
        ObservableList <Campaign> cmpList = AffiliateMarketer.GetCampaignList();
        for (int i = 0; i < cmpList.size(); i ++){
            long daysDifference = ChronoUnit.DAYS.between(
                    cmpList.get(i).getDurationStarts(), 
                    cmpList.get(i).getDurationEnds());
            String ss = cmpList.get(i).getProductName() + ", " + cmpList.get(i).getInfluencerName();
            series.getData().add(new XYChart.Data<String,Number>(ss,daysDifference));
            lineChart.getData().add(series);
        }
    }    
}
