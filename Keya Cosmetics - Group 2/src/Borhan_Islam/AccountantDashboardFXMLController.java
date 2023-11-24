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
import mainpkg.Main;
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
        BorhanSS ss = new BorhanSS();
        ss.recordsOnButtonClicked();        
        
    }

    @FXML
    private void searchDeleteOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.searchDeleteOnButtonClicked();  

    }

    @FXML
    private void generateReportOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.generateReportOnButtonClicked();   
    }

    @FXML
    private void transactionOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.transactionOnButtonClicked();   
    }

    @FXML
    private void profileOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.profileOnButtonClicked();    
    }

    @FXML
    private void logoutOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.logoutOnButtonClicked();  
    }

    @FXML
    private void incomeStatementOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.incomeStatementOnButtonClicked();  
    }

    @FXML
    private void productionAnalysisOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.productionAnalysisOnButtonClicked();
    }

    @FXML
    private void expenseControlSysOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.expenseControlSysOnButtonClicked();
    }
    
}
