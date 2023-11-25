/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;
import Borhan_Islam.Accountant;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mainpkg.Main;
import mainpkg.MainpkgSwitcher;
/**
 * FXML Controller class
 *
 * @author hasin
 */
public class AccountantDashboardFXMLController implements Initializable {

    @FXML
    private Label timeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ---- hh:mm:ss a");
        timeLabel.setText(LocalDateTime.now().format(formatter));

            }),
        new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
        MainpkgSwitcher logout = new MainpkgSwitcher();
        logout.switchtoLoginScene();
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
