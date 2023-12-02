/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeOvertimeDataController implements Initializable {

    @FXML
    private ListView<Overtime> listView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<EmployeeAttendence> tableView;
    @FXML
    private TableColumn<EmployeeAttendence, String> nameCol;
    @FXML
    private TableColumn<EmployeeAttendence, String> postCol;
    @FXML
    private TableColumn<EmployeeAttendence, String> TimeCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
                List<Object> OvertimeDutyHoursList = Receptionist.readObjectsFromFile("AdditionalHourRecords.bin");
        List<Overtime> OvertimeDutyHours = new ArrayList<>();
        for (Object obj : OvertimeDutyHoursList) {
            if (obj instanceof Overtime) {
                OvertimeDutyHours.add((Overtime) obj);
            }
        }
        listView.getItems().addAll(OvertimeDutyHours);
        

    }    
    @FXML
    private void loadAttendanceRecordOnClick(ActionEvent event) {
                LocalDate currentDate = datePicker.getValue();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = currentDate.format(dateFormatter);
        String fileName = "attendanceRecords_" + dateString + ".bin";

        List<Object> attendanceList = Receptionist.readObjectsFromFile(fileName);
        ObservableList<EmployeeAttendence> loadedItems = FXCollections.observableArrayList();
        for (Object obj : attendanceList) {
            if (obj instanceof EmployeeAttendence) {
                loadedItems.add((EmployeeAttendence) obj);
            }
        }
        tableView.getItems().addAll(loadedItems);
    
    }

    
}
