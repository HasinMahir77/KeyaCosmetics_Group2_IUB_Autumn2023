/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeOvertimeDataController implements Initializable {

    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private ComboBox<String> NameComboBox;
    @FXML
    private TextField timeTextField;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private ListView<String> listView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> postCol;
    @FXML
    private TableColumn<?, ?> TimeCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadAttendanceRecordOnClick(ActionEvent event) {
    }

    
}
