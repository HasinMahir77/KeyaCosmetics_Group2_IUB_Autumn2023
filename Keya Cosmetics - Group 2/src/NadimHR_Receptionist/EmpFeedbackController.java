/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmpFeedbackController implements Initializable {

    @FXML
    private TableView<FeedbackToHR> feedbackTableView;
    @FXML
    private TableColumn<FeedbackToHR, String> feedbackTypeColumn;
    @FXML
    private TableColumn<FeedbackToHR, String> nameColumn;
    @FXML
    private TableColumn<FeedbackToHR, String> emailColumn;
    @FXML
    private TableColumn<FeedbackToHR, String> feedbackColumn;

    private ObservableList<FeedbackToHR> feedbackList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                feedbackTypeColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getFeedbackType()));
        nameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        emailColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));
        feedbackColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getFeedback()));
        ObservableList<FeedbackToHR> userFeedbacks = FeedbackToHR.loadFeedbackFromFile();
        feedbackTableView.setItems(userFeedbacks);
    }    

    @FXML
    private void formatBinFleDataOnClck(ActionEvent event) {
    }

    @FXML
    private void SaveAsPDFonClick(ActionEvent event) {
    }
    
}
