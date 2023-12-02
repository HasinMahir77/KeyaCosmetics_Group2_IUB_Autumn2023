/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class RecruitmentAndSelectionController implements Initializable {

    @FXML
    private TextField nameTextFeild;
    @FXML
    private TextField ContactInfo;
    @FXML
    private ComboBox<String> PositonComboBox;
    @FXML
    private DatePicker assignedDate;
    @FXML
    private ComboBox<String> assingedbyhrComboBox;
    @FXML
    private ComboBox<String> contactinformationCombox;
    @FXML
    private TextField aaplicantIDTextfeild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assingedbyhrComboBox.getItems().addAll(
                "nadim",
                "naim"
        );
        contactinformationCombox.getItems().addAll(
                "Gmail Address",
                "Number"
        );
        PositonComboBox.getItems().addAll("Accountant", "Customer Service Executive", "Production manager", "Receptionist");
    }

    @FXML
    private void AssignedEmployeeOnClick(ActionEvent event) {
        String ApplicantName = nameTextFeild.getText();
        String contactInfo = ContactInfo.getText();
        String Position = PositonComboBox.getValue();
        String Assignedbyhr = assingedbyhrComboBox.getValue();
        String ContactInformation = contactinformationCombox.getValue();
        LocalDate SelectedDate = assignedDate.getValue();
        int Id = Integer.parseInt(aaplicantIDTextfeild.getText());

        if (SelectedDate == null
                || ApplicantName.isEmpty() || Position == null ||
                Assignedbyhr == null || ContactInformation == null ) {
            showErrorAlert("Missing Information", "Please fill in all fields.");
            return;
        }
        Applicant applicant = new Applicant(ApplicantName, contactInfo, Position, Id, Assignedbyhr ,  SelectedDate ,  ContactInformation);
        Hr.saveRecruiemntDataofApplicants(applicant,"Recruiment data of employees.bin");
        nameTextFeild.clear();
        ContactInfo.clear();
        assingedbyhrComboBox.getSelectionModel().clearSelection();
        contactinformationCombox.getSelectionModel().clearSelection();
        assignedDate.setValue(null);

        showSuccessAlert("Applicant info Saved", "The file has been saved successfully.");
    }

    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean showConfirmationAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);


        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;

    }


}
