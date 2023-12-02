
package Borhan_Islam;

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
import javafx.util.Duration;
import mainpkg.MainpkgSS;

public class AccountantDashboardFXMLController implements Initializable {

    @FXML
    private Label timeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            timeLabel.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();

    }

    @FXML
    private void recordsOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.recordsOnButtonClicked();  
    }

    @FXML
    private void generateReportOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.generateReportOnButtonClicked();  
    }

    @FXML
    private void logoutOnButtonClicked(ActionEvent event) throws IOException {
        MainpkgSS logout = new MainpkgSS();
        logout.switchtoLoginScene();
    }

    @FXML
    private void productionAnalysisOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.productionAnalysisOnButtonClicked();
    }

    @FXML
    private void payrollOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.payrollOnButtonClicked();          
    }

    @FXML
    private void auditReportOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.auditReportOnButtonClicked();          
    }

    @FXML
    private void updatedTermsOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.updatedTermsOnButtonClicked();          
    }

    @FXML
    private void expenseControlOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.expenseControlOnButtonClicked();          
    }

    @FXML
    private void reimbursementOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.reimbursementOnButtonClicked();          
    }

    @FXML
    private void accProfileOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.accProfileOnButtonClicked();          
    }

}
