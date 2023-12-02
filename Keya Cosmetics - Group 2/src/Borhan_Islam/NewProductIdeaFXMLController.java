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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class NewProductIdeaFXMLController implements Initializable {

    @FXML
    private ComboBox<String> categoryCombo;
    @FXML
    private TextField productNameText;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField priceExclText;
    @FXML
    private TextField vatText;
    @FXML
    private TextField priceInclText;
    @FXML
    private Button sendDetailsfxid;
    @FXML
    private Button saveDatafxid;
    @FXML
    private Button seeSaveDatafxid;
    @FXML
    private TableView<NewProduct> tableView;
    @FXML
    private TableColumn<NewProduct, String> productColumn;
    @FXML
    private TableColumn<NewProduct, String> categoryColumn;
    @FXML
    private TableColumn<NewProduct, Float> costColumn;
    @FXML
    private TableColumn<NewProduct, Float> priceExclColumn;
    @FXML
    private TableColumn<NewProduct, Float> vatColumn;
    @FXML
    private TableColumn<NewProduct, Float> priceInclColumn;
    @FXML
    private TextField tentativeCostText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sendDetailsfxid.setDisable(true);
        seeSaveDatafxid.setDisable(true);
        saveDatafxid.setDisable(false);
        
        tableView.setVisible(false);
        String[] category = {"Detergent","Body Soap",
                "Toothpaste","Deodorant","Skincare","Shampoo"};       
        categoryCombo.getItems().addAll(category);

        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        priceExclColumn.setCellValueFactory(new PropertyValueFactory<>("priceExcl"));
        vatColumn.setCellValueFactory(new PropertyValueFactory<>("vat"));
        priceInclColumn.setCellValueFactory(new PropertyValueFactory<>("priceIncl"));
        
        
    }    

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard(); 
    }

    @FXML
    private void sendDetailsButton(ActionEvent event) {
             if (showConfirmationAlert("Are you sure you?")) {
                showSuccessAlert("Details sent to Production Manager!");   
        }
    }
    @FXML
    private void saveDataButton(ActionEvent event) {
        if (!validateInputFields()) {
                    return;
                }
            String productName = productNameText.getText();
            String category = categoryCombo.getValue();
            Float cost=Float.valueOf(tentativeCostText.getText());
            Float priceExcl=Float.valueOf(priceExclText.getText());
            Float vat = Float.valueOf(vatText.getText());
            Float priceIncl= Float.valueOf(priceInclText.getText());
            String description=descriptionTextArea.getText();

            if (productName == null || category == null || cost == null || priceExcl == null || vat == null || priceIncl == null
                    || description == null) {
                showErrorAlert("Please fill in all the required fields.");
                return;
            } 
            if (showConfirmationAlert("Are you sure you want to save this product?")) {

                NewProduct.saveNewProductRecord(productName, category, cost, priceExcl, vat, priceIncl, description);             
                
   
                showSuccessAlert("Record added successfully.");
                sendDetailsfxid.setDisable(true);
                seeSaveDatafxid.setDisable(false);            
            }         
    }

    @FXML
    private void seeSaveDataButton(ActionEvent event) {
        tableView.setVisible(true);
        tableView.getItems().addAll(NewProduct.loadNewProductRecords());
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
    private boolean validateInputFields() {
        try {
            Float cost=Float.valueOf(tentativeCostText.getText());            
            Float priceExcl=Float.valueOf(priceExclText.getText());
            Float vat=Float.valueOf(vatText.getText());
            Float priceIncl=Float.valueOf(priceInclText.getText());
            
            if (cost <= 0) {
                showErrorAlert("Cost cannot be zero.");
                return false;
            }
            if (priceExcl <= 0) {
                showErrorAlert("Price cannot be zero.");
                return false;
            }

            if (vat < 5 || vat > 15) {
                showErrorAlert("Vat is between 5-15.");
                return false;
            }
            if (priceIncl < 0) {
                showErrorAlert("Price cannot be zero.");
                return false;
            }
            
            return true;
        } catch (NumberFormatException e) {
            showErrorAlert("Invalid input in Price/Cost/Vat.");
            return false;
        }
    }
}
