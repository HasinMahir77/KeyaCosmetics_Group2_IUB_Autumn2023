
package Amit_ProductionManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class AddNewMachineFXMLController implements Initializable {

    @FXML
    private TextField nametextfield;
    @FXML
    private TextField modelidtextfield;
    @FXML
    private TextField costtextfield;
    @FXML
    private TableView<Machine> tableView;
    @FXML
    private TableColumn<Machine, String> nameCol;
    @FXML
    private TableColumn<Machine, String> modelIDCol;
    @FXML
    private TableColumn<Machine, Integer> CostCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<Machine, String>("name"));
        modelIDCol.setCellValueFactory(new PropertyValueFactory<Machine, String>("modelno"));
        CostCol.setCellValueFactory(new PropertyValueFactory<Machine, Integer>("cost"));
        tableView.getItems().addAll(ProductionManager.GetMachineList());
    }    
    

    @FXML
    private void addmachinebuttonOnClick(MouseEvent event) {
        String name = nametextfield.getText();
        String modelno = modelidtextfield.getText();
        int cost = Integer.parseInt(costtextfield.getText());
        
        Machine m = new Machine(name, modelno, cost);
        ProductionManager.addMachine(m);
        tableView.getItems().add(m);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Machine has been added successfully");
        a.showAndWait();
    }
    
}
