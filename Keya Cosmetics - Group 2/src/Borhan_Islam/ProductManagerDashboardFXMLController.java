/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ProductManagerDashboardFXMLController implements Initializable {

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
    private void addproductOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.addproductOnButtonClicked();  
    }

    @FXML
    private void seeProductDetailsOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.seeProductDetailsOnButtonClicked();  
    }

    @FXML
    private void reviewProductsOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.reviewProductsOnButtonClicked();  
    }

    @FXML
    private void viewStockOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.viewStockOnButtonClicked();  
    }

    @FXML
    private void newProductIdeaOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.newProductIdeaOnButtonClicked();  
    }



    @FXML
    private void reimbursementOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void pmProfileOnButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.pmProfileOnButtonClicked();  
    }

    @FXML
    private void logoutOnButtonClicked(ActionEvent event) throws IOException {
        MainpkgSS logout = new MainpkgSS();
        logout.switchtoLoginScene();
    }

    @FXML
    private void sendfeedbackButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.sendfeedbackButton();      
    }

    @FXML
    private void loadDetailedProductsButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.loadDetailedProductsButton();  
    }
    
}
