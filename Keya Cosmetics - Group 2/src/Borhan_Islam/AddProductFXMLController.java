/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.Product.Category;
import HasinMahir.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import mainpkg.ObjectOutputStreamA;

/**
 * FXML Controller class
 *
 * @author 88019
 */
public class AddProductFXMLController implements Initializable {

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> nameTable;
    @FXML
    private TableColumn<Product, String> categoryTable;
    @FXML
    private TableColumn<Product, Integer> priceTable;
    @FXML
    private TableColumn<Product, Integer> vatTable;
    @FXML
    private TextField nameText;
    @FXML
    private TextField priceText;
    @FXML
    private TextField vatText;
    String selectedCategory;    
    Product selectedProduct;    
    @FXML
    private ListView<String> categoryListView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> categories = new ArrayList<String>();
       
        //Initializing Categories
        categoryListView.getItems().addAll("Detergent","Body Soap",
                "Toothpaste","Deodorant","Skincare","Shampoo");
        nameTable.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        categoryTable.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        priceTable.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        vatTable.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));        

        ObservableList<Product> productList = FXCollections.observableArrayList(); //Array to store products
        File productFile = new File("ProductList.bin");
        
        try(FileInputStream fis = new FileInputStream(productFile);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            while(true){
                productList.add((Product)ois.readObject());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //Inserting Products into TableView
        tableView.setItems(productList);
    }          

    @FXML
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard();     
    }

    @FXML
    private void removeProductButton(ActionEvent event) {
    }

    @FXML
    private void addProductButton(ActionEvent event) {
        Product p;
        String name_ = nameText.getText();
        float price_ = Integer.parseInt(priceText.getText());
        int vatRate_ = Integer.parseInt(vatText.getText());
        
        if (selectedCategory.equals("Detergent")){
            p = new Product(name_,price_,Product.Category.DETERGENT,vatRate_);
        }
        else if (selectedCategory.equals("Body Soap")){
            p = new Product(name_,price_,Product.Category.BODY_SOAP,vatRate_);
        }
        else if (selectedCategory.equals("Skincare")){
            p = new Product(name_,price_,Product.Category.SKINCARE,vatRate_);
        }
        else if (selectedCategory.equals("Toothpaste")){
            p = new Product(name_,price_,Product.Category.TOOTHPASTE,vatRate_);
        }
        else if (selectedCategory.equals("Deodorant")){
            p = new Product(name_,price_,Product.Category.DEODORANT,vatRate_);
        }
        else if (selectedCategory.equals("Shampoo")) {
            p = new Product(name_,price_,Product.Category.SHAMPOO,vatRate_);
        }
        else{
            return;
        }
        //Writing
        File productFile = new File("ProductList.bin");
        
        try(FileOutputStream fos = new FileOutputStream(productFile,true);
                    ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
                oos.writeObject(p);
                System.out.println("Object Written");
            }catch(Exception e){System.out.println(e);}
        this.updateProductTable();
        
    }

 

    @FXML
    private void addProductNewListButton(ActionEvent event) {
        Product p;
        String name_ = nameText.getText();
        float price_ = Integer.parseInt(priceText.getText());
        int vatRate_ = Integer.parseInt(vatText.getText());
        
        if (selectedCategory.equals("Detergent")){
            p = new Product(name_,price_,Product.Category.DETERGENT,vatRate_);
        }
        else if (selectedCategory.equals("Body Soap")){
            p = new Product(name_,price_,Product.Category.BODY_SOAP,vatRate_);
        }
        else if (selectedCategory.equals("Skincare")){
            p = new Product(name_,price_,Product.Category.SKINCARE,vatRate_);
        }
        else if (selectedCategory.equals("Toothpaste")){
            p = new Product(name_,price_,Product.Category.TOOTHPASTE,vatRate_);
        }
        else if (selectedCategory.equals("Deodorant")){
            p = new Product(name_,price_,Product.Category.DEODORANT,vatRate_);
        }
        else if (selectedCategory.equals("Shampoo")) {
            p = new Product(name_,price_,Product.Category.SHAMPOO,vatRate_);
        }
        else{
            return;
        }
        //Writing
        FileChooser fc = new FileChooser();
        File productFile = new File("ProductList.bin");
        productFile.delete();
        
        
        try(FileOutputStream fos = new FileOutputStream(productFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(p);
                System.out.println("Object Written");
            }catch(Exception e){}
        this.updateProductTable();
    }

    private void updateProductTable(){
        ObservableList<Product> productArray = FXCollections.observableArrayList();
        //Getting files from file
        File f = new File("ProductList.bin");
       try(FileInputStream fos = new FileInputStream(f);
               ObjectInputStream oos = new ObjectInputStream(fos)){
           while (true){
               Product p = (Product)oos.readObject();
               productArray.add(p);
           }
       }
       catch(Exception e){}
        
        //-----------------
        tableView.getItems().clear();
        tableView.getItems().setAll(productArray);
        
    }   
}
