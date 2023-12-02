
package Amit_ProductionManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class ManageVendorsController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private DatePicker deliveredDate;
    @FXML
    private TextField rate;
    @FXML
    private TableView<Vendors> tableView;
    @FXML
    private TableColumn<Vendors, String> nameCol;
    @FXML
    private TableColumn<Vendors, LocalDate> deliveredCol;
    @FXML
    private TableColumn<Vendors, Integer> rateCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<Vendors, String>("name"));
        deliveredCol.setCellValueFactory(new PropertyValueFactory<Vendors, LocalDate>("delivered"));
        rateCol.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("rate"));

        
        tableView.getItems().addAll(ProductionManager.GetVendorList());
    }    

    @FXML
    private void addNewVendorButtonClick(MouseEvent event) {
        String Name = name.getText();
        LocalDate Delivered = deliveredDate.getValue();
        int Rate = Integer.parseInt(rate.getText());
        
        Vendors v = new Vendors(Name, Delivered, Rate);
        ProductionManager.addVendors(v);
        tableView.getItems().add(v);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Production Improvement has been added successfully");
        a.showAndWait();
    }
    
}
