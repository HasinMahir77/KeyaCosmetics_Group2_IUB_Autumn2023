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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class ViewStockFXMLController implements Initializable {

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> nameTable;
    @FXML
    private TableColumn<Product, String> categoryTable;
    @FXML
    private TableColumn<Product, Float> priceTable;
    @FXML
    private TableColumn<Product, Float> vatTable;
    @FXML
    private Button loadfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.nameTable.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        this.categoryTable.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        this.priceTable.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        this.vatTable.setCellValueFactory(new PropertyValueFactory<Product, Float>("vatRate"));   

    }    

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard(); 
    }



    @FXML
    private void loadButton(ActionEvent event) {
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
    
    }

    @FXML
    private void updateSelectedProduct(MouseEvent event) {
    }
    
}
