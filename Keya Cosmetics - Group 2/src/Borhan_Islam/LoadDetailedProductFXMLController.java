/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class LoadDetailedProductFXMLController implements Initializable {

    @FXML
    private TableView<ProductDetails> tableView;
    @FXML
    private TableColumn<ProductDetails, String> nameCol;
    @FXML
    private TableColumn<ProductDetails, String> categoryCol;
    @FXML
    private TableColumn<ProductDetails, Float> priceCol;
    @FXML
    private TableColumn<ProductDetails, Float> vatCol;
    @FXML
    private TextArea detailedTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nameCol.setCellValueFactory(new PropertyValueFactory<ProductDetails, String>("name"));
        this.categoryCol.setCellValueFactory(new PropertyValueFactory<ProductDetails, String>("category"));
        this.priceCol.setCellValueFactory(new PropertyValueFactory<ProductDetails, Float>("price"));
        this.vatCol.setCellValueFactory(new PropertyValueFactory<ProductDetails, Float>("vat")); 
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                detailedTextArea.setText(newSelection.getDetails());
            }
        }); 
        tableView.setItems(FXCollections.observableList(ProductDetails.loadProductDetailsRecords()));        
    }    

    @FXML
    private void switchToAccDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard();   
    }

    @FXML
    private void selectedProductTable(MouseEvent event) {
    }
    
}
