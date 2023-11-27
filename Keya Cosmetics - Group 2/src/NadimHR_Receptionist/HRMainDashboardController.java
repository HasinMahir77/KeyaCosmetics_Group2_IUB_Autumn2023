/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class HRMainDashboardController implements Initializable {

    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void employeeDetailsChartsOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Employee details.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void requirmentandselectionOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("recruitment and selection.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void performancemanagementsandrewardsOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Performance managements and rewards.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void expenceandreimbursementOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Expense and Reimbursement.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void updateworkplacepoliciesOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Update workplace policies.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void administerpayrollreportsOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Administer payroll reports.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void attendenceleavemanagementOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AttendanceLeave management.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void auditfinancialmanagementsOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Audited Financial Managements.fxml"));
        borderpane.setCenter(root);
    }
     @FXML
    private void AnalyzedapplicantsOnclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ApplicantSorting.fxml"));
        borderpane.setCenter(root);
    }
    @FXML
    private void backOnCLick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HR mainDashboard.fxml"));
        Main.getMainStage().getScene().setRoot(root);
    }
   

}
