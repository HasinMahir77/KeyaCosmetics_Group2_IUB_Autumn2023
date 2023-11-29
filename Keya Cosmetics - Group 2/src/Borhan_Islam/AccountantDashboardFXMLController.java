/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import mainpkg.Main;
import mainpkg.MainpkgSS;
/**
 * FXML Controller class
 *
 * @author hasin
 */
public class AccountantDashboardFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void recordsOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RecordsFXML.fxml"));
    }

    @FXML
    private void generateReportOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GenerateReportFXML.fxml"));
    }

    @FXML
    private void transactionOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("transactionFXML.fxml"));

    }

    @FXML
    private void profileOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfileFXML.fxml"));
    }

    @FXML
    private void logoutOnButtonClicked(ActionEvent event) throws IOException {
        //LOGOUT CODES
    }

    @FXML
    private void incomeStatementOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IncomeFXML.fxml"));

    }

    @FXML
    private void productionAnalysisOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductionAnalysisFXML.fxml"));

    }

    @FXML
    private void expenseControlSysOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ExpenseControlSysFXML.fxml"));

    }

    @FXML
    private void searchDeleteOnButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchOrDeleteFXML.fxml"));
    }

}
