/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;
import NadimHR_Receptionist.ReimbursementRequestRecord;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ReimbursementFXMLController implements Initializable {
  
    @FXML
    private TableView<ReimbursementRequestRecord> tableView;
    @FXML
    private TableColumn<ReimbursementRequestRecord, String> nameTable;
    @FXML
    private TableColumn<ReimbursementRequestRecord, Float> amountTable;
    @FXML
    private TableColumn<ReimbursementRequestRecord, LocalDate> dateTable;
    @FXML
    private TableColumn<ReimbursementRequestRecord, String> desigTable;
    @FXML
    private TableColumn<ReimbursementRequestRecord, String> paymentMethodTable;
    @FXML
    private TableColumn<ReimbursementRequestRecord, String> expDesTable;
    private ObservableList<ReimbursementRequestRecord> reimbList = FXCollections.observableArrayList();    
    @FXML
    private Button loadRequestfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTable.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        amountTable.setCellValueFactory(new PropertyValueFactory<>("expenseAmount"));
        dateTable.setCellValueFactory(new PropertyValueFactory<>("reimbursementDate"));
        desigTable.setCellValueFactory(new PropertyValueFactory<>("designation"));
        paymentMethodTable.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        expDesTable.setCellValueFactory(new PropertyValueFactory<>("expenseDistribution"));
        tableView.setItems(reimbList);

    }    
    public ObservableList<ReimbursementRequestRecord> getReimbList() {
        return reimbList;
    }

    public void setReimbList(ObservableList<ReimbursementRequestRecord> reimbList) {
        this.reimbList = reimbList;  

    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToAccDashboard(); 
    }

    @FXML
    private void ApproveButton(ActionEvent event) {
        if (showConfirmationAlert("Are you sure you want to approve?")) {            
            
            showSuccessAlert("Approved!");
        }
    }
    @FXML
    private void RejectButton(ActionEvent event) {
        if (showConfirmationAlert("Are you sure you want to reject?")) {            
            
            showSuccessAlert("Rejected!");
        }    
    }

    @FXML
    private void loadRequestButton(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Reimbursement.bin"));

            while (true) {
                try {
                    ReimbursementRequestRecord rr = (ReimbursementRequestRecord) ois.readObject();

                    tableView.getItems().add(rr);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        loadRequestfxid.setDisable(true);        

        }
    }
    
    public void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText(message);

        return alert.showAndWait().orElse(null).equals(ButtonType.OK);
    }

    public void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }   
}
