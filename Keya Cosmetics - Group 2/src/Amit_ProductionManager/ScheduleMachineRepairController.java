
package Amit_ProductionManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ScheduleMachineRepairController implements Initializable {

    @FXML
    private ComboBox<String> machineCombobox;
    @FXML
    private DatePicker datedatePickeer;
    @FXML
    private TableView<RepairSchedule> tableview;
    @FXML
    private TableColumn<RepairSchedule, String> machineCol;
    @FXML
    private TableColumn<RepairSchedule, LocalDate> repairDateCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        machineCol.setCellValueFactory(new PropertyValueFactory<RepairSchedule, String>("machineName"));
        repairDateCol.setCellValueFactory(new PropertyValueFactory<RepairSchedule, LocalDate>("repairDate"));
        tableview.getItems().addAll(ProductionManager.GetRepairScheduleList());
        
        ObservableList <Machine> mList = ProductionManager.GetMachineList();
        for (int i = 0; i < mList.size(); i ++) {
            machineCombobox.getItems().add(mList.get(i).getName());
        }
        
    }    

    @FXML
    private void AddButtOnClick(MouseEvent event) {
        String name = machineCombobox.getValue();
        LocalDate repairDate = datedatePickeer.getValue();
        RepairSchedule rs = new RepairSchedule(name, repairDate);
        ProductionManager.addRepairSchedule(rs);
        
        tableview.getItems().add(rs);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Repair Schedule has been added successfully");
        a.showAndWait();
    }
    
}
