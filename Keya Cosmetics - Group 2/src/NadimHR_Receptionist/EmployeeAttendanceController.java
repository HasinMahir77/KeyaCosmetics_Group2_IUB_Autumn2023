/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeAttendanceController implements Initializable {

    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private ComboBox<String> nameComboBox;
    @FXML
    private TableView<EmployeeAttendence> tableView;
    @FXML
    private TableColumn<EmployeeAttendence, String> nameCol;
    @FXML
    private TableColumn<EmployeeAttendence, String> positiontCol;
    @FXML
    private TableColumn<EmployeeAttendence, String> TimeCol;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        positiontCol.setCellValueFactory(new PropertyValueFactory<>("post"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = currentDate.format(dateFormatter);
        String fileName = "AttendanceRecords_" + dateString + ".bin";
        
        List<Object> attendanceList = Receptionist.readObjectsFromFile(fileName);
        ObservableList<EmployeeAttendence> loadedItems = FXCollections.observableArrayList();
        for (Object obj : attendanceList) {
            if (obj instanceof EmployeeAttendence) {
                loadedItems.add((EmployeeAttendence) obj);
            }
        }
        tableView.getItems().addAll(loadedItems);
        positionComboBox.getItems().addAll("Receptionist", "Hr", "Accountant",
                "Product Manager", "Affiliate Marketer");
        positionComboBox.setOnAction(event -> {
            String selectedPost = positionComboBox.getValue();
            if (null == selectedPost) {
                nameComboBox.getItems().clear();
            } else {
                switch (selectedPost) {
                    case "Receptionist":
                        nameComboBox.getItems().clear();
                        nameComboBox.getItems().addAll("Shams Muzaffar", "Sumaiya Muzaffar");
                        break;
                    case "Accountant":
                        nameComboBox.getItems().clear();
                        nameComboBox.getItems().addAll("Nasrin Muzaffar", "Aysha Muzaffar");
                        break;
                    case "Hr":
                        nameComboBox.getItems().clear();
                        nameComboBox.getItems().addAll("Nadim Ahmed", "Naimul Islam");
                        break;
                    case "Affiliate Marketer":
                        nameComboBox.getItems().clear();
                        nameComboBox.getItems().addAll("Amit Chowdhury", "Borhan Islam");
                        break;
                    case "Product Manager":
                        nameComboBox.getItems().clear();
                        nameComboBox.getItems().addAll("Hasin Mahir", " Mahir Kalam");
                        break;
                    default:
                        nameComboBox.getItems().clear();
                        break;
                }
            }

        });
    }

    @FXML
    private void AddButtonOnClick(ActionEvent event
    ) {
        String selectedPostision = positionComboBox.getValue();
        String selectedName = nameComboBox.getValue();

        if (selectedPostision != null && !selectedPostision.isEmpty() &&
            selectedName != null && !selectedName.isEmpty()) {
            String checkInTime = getCurrentTime();
            tableView.getItems().add(new EmployeeAttendence(selectedName, selectedPostision, checkInTime));
        } else {
            showErrorAlert("Please select both position and name.");
        }
    }
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    @FXML
    private void createButtonOnClick(ActionEvent event) {
        ObservableList<EmployeeAttendence> items = tableView.getItems();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = currentDate.format(dateFormatter);
        String fileName = "attendanceRecords_" + dateString + ".bin";
        
        
        boolean addStatus = Receptionist.write_Objects_ToFile(items, fileName);
        if (addStatus) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Attendance Added Successfully!");
                a.showAndWait();
        } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Oops, something went wrong");
                a.showAndWait();
        }
    }

    @FXML
    private void saveAsPDF(ActionEvent event) {
        
        
       
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
