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
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class RecordsFXMLController implements Initializable {

    @FXML
    private TableView<?> recordsTableView;
    @FXML
    private TextField searchTextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showRecordsOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void editOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void filterOnButtonClicked(ActionEvent event) {
    }

    @FXML
    private void searchTextfieldOnEnterPressed(ActionEvent event) {
    }

    private void recordsToDashboardButton(ActionEvent event) throws IOException {

    }

    @FXML
    private void switchToDashboardButton(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToDashboardButton();    
            
    }
    
}
