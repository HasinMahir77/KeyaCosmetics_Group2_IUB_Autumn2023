/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class ApplicantSortingController implements Initializable {

    @FXML
    private TableView<Applicant> TableView_1;
    @FXML
    private TableColumn<Applicant, String> applicantNameColumn;
    @FXML
    private TableColumn<Applicant, String> contactInfoColumn;
    @FXML
    private TableColumn<Applicant, String> PositionColumn;
    @FXML
    private TableColumn<Applicant, Integer> IDcolumn;
    @FXML
    private TableColumn<Applicant, String> AssignedbyColumn;
    @FXML
    private TableColumn<Applicant, LocalDate> assignedDateColumn;
    @FXML
    private TableView<Applicant> TableView_11;
    @FXML
    private TableColumn<Applicant, String> applicantNameColumn1;
    @FXML
    private TableColumn<Applicant, String> contactInfoColumn1;
    @FXML
    private TableColumn<Applicant, String> PositionColumn1;
    @FXML
    private TableColumn<Applicant, Integer> IDcolumn1;
    @FXML
    private TableColumn<Applicant, String> AssignedbyColumn1;
    @FXML
    private TableColumn<Applicant, LocalDate> assignedDateColumn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applicantNameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getApplicantName()));
        contactInfoColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getContactInfo()));
        PositionColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue(). getPosition()));
        IDcolumn.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getId()).asObject());


        AssignedbyColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAssignedbyhr()));
        assignedDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAssignedDate()));
        
        applicantNameColumn1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getApplicantName()));
        contactInfoColumn1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getContactInfo()));
        PositionColumn1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue(). getPosition()));
        IDcolumn1.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getId()).asObject());


        AssignedbyColumn1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAssignedbyhr()));
        assignedDateColumn1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAssignedDate()));
        ObservableList<Applicant> applicant = FXCollections.observableList(Hr.loadApplicantsFromFile("Recruiment data of employees.bin"));
        ObservableList<Applicant> sortedapplicant = FXCollections.observableList(Hr.loadApplicantsFromFile("SortedApplicants.bin"));

   
        TableView_1.setItems(applicant);
      
        TableView_11.setItems(sortedapplicant);
        //format 
    }    

    @FXML
    private void sortOutButtonOnClick(ActionEvent event) {
        Applicant selectedCase = TableView_1.getSelectionModel().getSelectedItem();
        if (selectedCase != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Are you sure you want to delete this case?");
            alert.setContentText("This action cannot be undone.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                TableView_1.getItems().remove(selectedCase);
                Hr.updateFile(TableView_1.getItems(),"Recruiment data of employees.bin");
                Hr.sortedapplicant(selectedCase, "SortedApplicants.bin");
                TableView_11.getItems().add(selectedCase);

            }
        }
    }

    @FXML
    private void formatedSortedApplicantsFile(ActionEvent event) {
        
        
    }

    @FXML
    private void formatAppoicantsBinFileOnClick(ActionEvent event) {
    }

    @FXML
    private void saveSelectedAppplicantesAsPDF(ActionEvent event) {
    }
    
}
