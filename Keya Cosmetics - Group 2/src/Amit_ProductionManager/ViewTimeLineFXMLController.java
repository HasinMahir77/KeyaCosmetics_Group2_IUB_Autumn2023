
package Amit_ProductionManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ViewTimeLineFXMLController implements Initializable {

    @FXML
    private TextArea textArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <String> sList = ProductionManager.GetTimeLine();
        for (int i = 0; i < sList.size(); i ++) {
            textArea.setText(sList.get(i) + "\n\n");
        }
        // TODO
    }    
    
}
