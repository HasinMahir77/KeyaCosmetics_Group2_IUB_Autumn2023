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
public class SearchOrDeleteFXMLController implements Initializable {

    @FXML
    private Label timeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy | hh:mm:ss a");
        timeLabel.setText(LocalDateTime.now().format(formatter));

            }),
        new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
 
    }    

    @FXML
    private void addProductsOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void pmprofileButtonClicked(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.pmprofileButtonClicked();          
    }

    @FXML
    private void logoutOnButtonClicked(ActionEvent event) throws IOException {
        MainpkgSS logout = new MainpkgSS();
        logout.switchtoLoginScene();        
    }
    
}
