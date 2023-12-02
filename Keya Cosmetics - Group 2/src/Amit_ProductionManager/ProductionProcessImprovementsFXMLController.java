
package Amit_ProductionManager;

import HasinMahir.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class ProductionProcessImprovementsFXMLController implements Initializable {

    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private TextArea improvementTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList <Product> pList = ProductionManager.GetProductList();
        for (int i = 0; i < pList.size(); i ++) {
            productComboBox.getItems().add(pList.get(i).getName());
        }
    }    

    @FXML
    private void saveButtonOnClick(MouseEvent event) {
        String name = productComboBox.getValue();
        String improvement = improvementTextArea.getText();
        
        ProductionImprovement pi = new ProductionImprovement(name, improvement);
        ProductionManager.addImprovement(pi);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Production Improvement has been added successfully");
        a.showAndWait();
    }
    
}
