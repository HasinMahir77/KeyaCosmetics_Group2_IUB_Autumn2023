/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class MantainOvertimeDataOfEmployeesController implements Initializable {

    @FXML
    private TableView<Overtime> TableView;
    @FXML
    private TableColumn<Overtime, String> DesignationColumn;
    @FXML
    private TableColumn<Overtime, String> NameColumn;
    @FXML
    private TableColumn<Overtime, Float> HoursColumn;
    @FXML
    private TableColumn<Overtime, LocalDate> DateColumn;
    @FXML
    private ComboBox<String> DesignationComboBox;
    @FXML
    private ComboBox<String> NameComboBox;
    @FXML
    private TextField HoursTextField;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private Button LoadInformationButton;
    @FXML
    private Button SendButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DesignationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        HoursColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DatePicker.setValue(LocalDate.now());
        DatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
        
        //
                DesignationComboBox.getItems().addAll("Receptionist", "Affiliate markter", "Accountant",
                "Delivary man", "Human Resources Manager");

        DesignationComboBox.setOnAction(event -> {
            String selectedPost = DesignationComboBox.getValue();
            if (null == selectedPost) {
                NameComboBox.getItems().clear();
            } else {
                switch (selectedPost) {
                    case "Receptionist":
                        NameComboBox.getItems().clear();
                        NameComboBox.getItems().addAll("Shams Muzaffar", "Sumaiya Muzaffar");
                    
                        break;
                    case "Affiliate markter":
                        NameComboBox.getItems().clear();
                        NameComboBox.getItems().addAll("Habib Ahmed", "Zahirul Islam Chowdhury");
                        break;
                    case "Accoutant":
                        NameComboBox.getItems().clear();
                        NameComboBox.getItems().addAll("Nafisa Rahman", "Saleh Ahmed");
                        break;
                    case "Delivary man":
                        NameComboBox.getItems().clear();
                        NameComboBox.getItems().addAll("Nasrin Akhter", "Zahid Islam");
                        break;
                    case "HR Manager":
                        NameComboBox.getItems().clear();
                        NameComboBox.getItems().add("Nadim");
                        break;
                    default:
                        NameComboBox.getItems().clear();
                        break;
                }
            }
        });
    }    

    @FXML
    private void loadInformationOnClick(ActionEvent event) {
                String designation = DesignationComboBox.getValue();
        String name = NameComboBox.getValue();
        String hoursText = HoursTextField.getText();
        Float hoursValue = Float.valueOf(hoursText);
        LocalDate date = DatePicker.getValue();
        TableView.getItems().add(new Overtime(designation, name, hoursValue, date));
        
    }

    @FXML
    private void sendInformationOnClick(ActionEvent event) {
                String designation = DesignationComboBox.getValue();
        String name = NameComboBox.getValue();
        String hoursText = HoursTextField.getText();
        LocalDate date = DatePicker.getValue();

        if (designation == null || name == null || hoursText.isEmpty() || date == null) {
            showErrorAlert("Error", "Please enter all required data.");
            return;
        }

        float hoursValue;
        try {
            hoursValue = Float.parseFloat(hoursText);
        } catch (NumberFormatException e) {
            showErrorAlert("Error", "Invalid hours format. Please enter a valid number.");
            return;
        }

        if (hoursValue <= 0) {
            showErrorAlert("Error", "Hours must be a positive value.");
            return;
        }

            List<Object> OvertimeHoursList = Receptionist.readObjectsFromFile("OvertimeRecords.bin");
        for (Object obj : OvertimeHoursList) {
            if (obj instanceof Overtime) {
                Overtime existingRecord = (Overtime) obj;
                if (existingRecord.getDate().equals(date)) {
                    showErrorAlert("Error", "Record already submitted for today.");
                    return;
                }
            }
        }
            ////////////
        Overtime newOvertimeDutyHours = new Overtime(designation, name, hoursValue, date);
        boolean addStatus = Receptionist.addO_DutyHour(newOvertimeDutyHours, "OvertimeRecords.bin");
        if (addStatus) {
            showInfoAlert("Success", "Send Successfully!");
        } else {
            showErrorAlert("Error", "Oops, something went wrong");
        }
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    
    }

    @FXML
    private void saveAspdfOmClk(ActionEvent event) {
    }
    
}
//kichas