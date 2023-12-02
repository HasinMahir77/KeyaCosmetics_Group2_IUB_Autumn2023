
package Amit_ProductionManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class CreateTimelineFXMLController implements Initializable {

    @FXML
    private TextArea writingTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void SaveButtonOnClick(MouseEvent event) {
        String ss = writingTextArea.getText();
        ProductionManager.addTimeLine(ss);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Repair Schedule has been added successfully");
        a.showAndWait();
    }
    
}
