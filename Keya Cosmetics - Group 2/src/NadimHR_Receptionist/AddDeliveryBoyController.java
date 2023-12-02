/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class AddDeliveryBoyController implements Initializable {

    @FXML
    private DatePicker dateOfEnlishmentDatePicker;
    @FXML
    private TextArea AdressTextArea;
    @FXML
    private RadioButton AllRadioButton;
    @FXML
    private RadioButton BangladeshiRadioButton;
    @FXML
    private RadioButton NonBangladeshiRadioButton;
    @FXML
    private TableView<DeliveryManDatabase> tableview;
    @FXML
    private TableColumn<DeliveryManDatabase, Integer> idCol;
    @FXML
    private TableColumn<DeliveryManDatabase, String> nameCol;
    @FXML
    private TableColumn<DeliveryManDatabase, String> nationalityCol;
    @FXML
    private TableColumn<DeliveryManDatabase, String> employeeCol;
    @FXML
    private TableColumn<DeliveryManDatabase, LocalDate> dateOFEnCol;
    @FXML
    private TableColumn<DeliveryManDatabase, String> adressCol;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private ComboBox<String> countryComboBox;
    @FXML
    private PieChart pieChart;
    @FXML
    private ComboBox<String> employeeComboBox;

    private ObservableList<DeliveryManDatabase> displayedexistinDeliveryManDatabases = FXCollections.observableArrayList();

    private ToggleGroup nationalityToggleGroup = new ToggleGroup();
    @FXML
    private TextField DBIDtextfeild;
    @FXML
    private TextField DBNameTextFeild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        employeeCol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        dateOFEnCol.setCellValueFactory(new PropertyValueFactory<>("dateOfEnlishment"));
        adressCol.setCellValueFactory(new PropertyValueFactory<>("adress"));

        countryComboBox.getItems().addAll("India", "Srilanka", "Bangladesh", "Nepal", "Pakistan", "Bhutan");
        employeeComboBox.getItems().addAll("Nadim", "Naim", "Tawhid");
        BangladeshiRadioButton.setToggleGroup(nationalityToggleGroup);
        NonBangladeshiRadioButton.setToggleGroup(nationalityToggleGroup);
        AllRadioButton.setToggleGroup(nationalityToggleGroup);

        List<Object> objectList = Hr.readObjectsFromFile("DeliveryManDatabase.bin");
        for (Object obj : objectList) {
            if (obj instanceof DeliveryManDatabase) {
                displayedexistinDeliveryManDatabases.add((DeliveryManDatabase) obj);
            }
        }
        tableview.setItems(displayedexistinDeliveryManDatabases);
    }

    @FXML
    private void loaddAllDataFromBinFileOnClicks(ActionEvent event) {
    }

    private boolean isDBIDNumberUnique(int DBid) {
        for (DeliveryManDatabase deliveryManDatabase : displayedexistinDeliveryManDatabases) {
            if (deliveryManDatabase.getId() == DBid) {
                return false;
            }
        }
        return true;
    }

    @FXML
    private void AddToTableView(ActionEvent event) {
        int Sid;
        String Sname = DBNameTextFeild.getText();
        String Snationality = countryComboBox.getValue();
        String SempId = employeeComboBox.getValue();
        LocalDate SdateOfEnlishment;
        String Sadress = AdressTextArea.getText();
        try {
            Sid = Integer.parseInt(DBIDtextfeild.getText());
            if (!isDBIDNumberUnique(Sid)) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "DB no. number must be unique.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "DB number must be a valid integer.");
            return;
        }

        SdateOfEnlishment = dateOfEnlishmentDatePicker.getValue();
        if (SdateOfEnlishment == null || SdateOfEnlishment.isAfter(LocalDate.now())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Enlishment.");
            return;
        }
        if (Sname.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "DB name cannot be empty.");
            return;
        }
        if (Sadress.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Address cannot be empty.");
            return;
        }
        if (Snationality == null || SempId == null) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select nationality and HR.");
            return;
        }
        if (SdateOfEnlishment == null || SdateOfEnlishment.isAfter(LocalDate.now())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Establishment.");
            return;
        }
        if (DBNameTextFeild.getText().isEmpty() || Sname.isEmpty() || Snationality == null || SempId == null
                || SdateOfEnlishment == null || Sadress.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please fill in all fields.");
            return;
        }
        DeliveryManDatabase newSupplier = new DeliveryManDatabase(Sid, Sname, Snationality, Sadress, SdateOfEnlishment, SempId);
        displayedexistinDeliveryManDatabases.add(newSupplier);

        Hr.writeDbDataToFile(displayedexistinDeliveryManDatabases, "DeliveryManDatabase.bin");
        showAlert(Alert.AlertType.INFORMATION, "Success", "DB added successfully.");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }

    @FXML
    private void loadTableViewOnClick(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) nationalityToggleGroup.getSelectedToggle();
        String selectedEmployee = employeeComboBox.getValue();

        if (selectedEmployee == null || selectedRadioButton == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select an employee and nationality.");
            return;
        }

        String nationality = selectedRadioButton == BangladeshiRadioButton ? "Bangladesh"
                : selectedRadioButton == NonBangladeshiRadioButton ? "NonBangladeshi" : "All";

        List<DeliveryManDatabase> allDeliveryManDatabase = Hr.readDBFromFile("DeliveryManDatabase.bin");
        List<DeliveryManDatabase> filteredDeliveryManDatabase = new ArrayList<>();

        for (DeliveryManDatabase DB : allDeliveryManDatabase) {
            boolean matchesEmployee = selectedEmployee.equals("All") || DB.getEmpId().equals(selectedEmployee);
            boolean matchesNationality = nationality.equals("All")
                    || (nationality.equals("NonBangladeshi") && !DB.getNationality().equals("Bangladesh"))
                    || DB.getNationality().equals(nationality);

            if (matchesEmployee && matchesNationality) {
                filteredDeliveryManDatabase.add(DB);
            }
        }

        filteredDeliveryManDatabase.sort(Comparator.comparing(DeliveryManDatabase::getName));

        ObservableList<DeliveryManDatabase> observableList = FXCollections.observableArrayList(filteredDeliveryManDatabase);
        tableview.setItems(observableList);

    }

    @FXML
    private void barchartOnClick(ActionEvent event) {
         if (displayedexistinDeliveryManDatabases.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No DBMan to display in Bar Chart.");
            return;
        }

        barChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        int countNadim = 0;
        int countNaim = 0;
        int countTawhid= 0;

        for (DeliveryManDatabase DB : displayedexistinDeliveryManDatabases) {
            if ("Nadim".equals(DB.getEmpId())) {
                countNadim++;
            } else if ("Naim".equals(DB.getEmpId())) {
                countNaim++;
            } else if ("Tawhid".equals(DB.getEmpId())) {
                countTawhid++;
            }

        }

        series.getData().add(new XYChart.Data<>("Nadim", countNadim));
        series.getData().add(new XYChart.Data<>("Naim", countNaim));
        series.getData().add(new XYChart.Data<>("Tawhid", countTawhid));

        barChart.getData().add(series);

    }

    @FXML
    private void piChartOnClick(ActionEvent event) {
          if (displayedexistinDeliveryManDatabases.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No suppliers to display in Pie Chart.");
            return;
        }
        pieChart.getData().clear();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int countNadim = 0;
        int countNaim = 0;
        int countTawhid= 0;

        for (DeliveryManDatabase DB : displayedexistinDeliveryManDatabases) {
            if ("Nadim".equals(DB.getEmpId())) {
                countNadim++;
            } else if ("Naim".equals(DB.getEmpId())) {
                countNaim++;
            } else if ("Tawhid".equals(DB.getEmpId())) {
                countTawhid++;
            }
        }
        pieChartData.add(new PieChart.Data("Nadim", countNadim));
        pieChartData.add(new PieChart.Data("Naim", countNaim));
        pieChartData.add(new PieChart.Data("Tawhid", countTawhid));
        pieChart.setData(pieChartData);
    }

    @FXML
    private void formatTableViewDSataOnClick(ActionEvent event) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure?");
        confirmationAlert.setContentText("This action will erase the data in the bin file. Continue?");

        ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {

            displayedexistinDeliveryManDatabases.clear();
            Hr.writeDbDataToFile(displayedexistinDeliveryManDatabases, "DeliveryManDatabase.bin");

            showAlert(Alert.AlertType.INFORMATION, "Success", "TableView data cleared successfully.");
        }
    }

}
