/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeAttendanceController implements Initializable {

    @FXML
    private ComboBox<?> positionComboBox;
    @FXML
    private ComboBox<?> nameComboBox;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> positiontCol;
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
    private void AddButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void createButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void saveAsPDF(ActionEvent event) {
    }
    
}
