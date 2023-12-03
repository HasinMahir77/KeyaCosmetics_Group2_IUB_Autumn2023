/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ProductDetailsFXMLController implements Initializable {

    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, String> categoryCol;
    @FXML
    private TableColumn<Product, Float> priceCol;
    @FXML
    private TableColumn<Product, Float> vatCol;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private Label nameLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label vatLabel;
    @FXML
    private TableView<Product> tableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        this.categoryCol.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        this.priceCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        this.vatCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("vatRate"));   
        ObservableList<Product> productArray = FXCollections.observableArrayList(); //Array to store products
        File productFile = new File("ProductList.bin");
        
        try(FileInputStream fis = new FileInputStream(productFile);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            while(true){
                productArray.add((Product)ois.readObject());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //Inserting Products into TableView
        tableView.setItems(productArray);
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nameLabel.setText(newSelection.getName());
                categoryLabel.setText(newSelection.getCategory());
                priceLabel.setText(String.valueOf(newSelection.getPrice()));
                vatLabel.setText(String.valueOf(newSelection.getVatRate()));
//                detailsTextArea.setText(newSelection.());
            
            }
        });    
    }    

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard(); 
    }


    @FXML
    private void selectedProductTable(MouseEvent event) {
    
    }

    @FXML
    private void saveDetailsButton(ActionEvent event) {
        String name=nameLabel.getText();
        String category=categoryLabel.getText();
        Float price=Float.valueOf(priceLabel.getText());
        Float vat=Float.valueOf(vatLabel.getText());
        String details=detailsTextArea.getText();
        if (showConfirmationAlert("Are you sure you want to save this report?")) {        
            ProductDetails.saveProductDetailsRecord(name, category, price, vat, details);  
            showSuccessAlert("Report saved successfully.");
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
