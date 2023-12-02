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
import javafx.scene.input.MouseEvent;
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
        // TODO
        ArrayList<String> categories = new ArrayList<String>();
       
        //Initializing Categories
        categoryListView.getItems().addAll("Detergent","Body Soap",
                "Toothpaste","Deodorant","Skincare","Shampoo");
      
        
        //Initializing Product TableView

        this.nameTable.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        this.categoryTable.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        this.priceTable.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        this.vatTable.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        //Collecting products from file
        
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
    private void switchToPmDashboard(ActionEvent event) throws IOException {
        BorhanSS ss = new BorhanSS();
        ss.switchToPmDashboard();     
    }

    @FXML
    private void removeProductButton(ActionEvent event) {
        if (selectedProduct==null){
        }
        else{
            tableView.getItems().remove(selectedProduct);
            ObservableList<Product> productArray = tableView.getItems();
            
            
            File productFile = new File("ProductList.bin");
            productFile.delete();
            
            //First object
            try(FileOutputStream fos = new FileOutputStream(productFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(productArray.get(0));
                
            }
            catch(Exception e){}
             //2nd to last objects
            try(FileOutputStream fos = new FileOutputStream(productFile,true);
                    ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
                for (Product p: productArray.subList(1, productArray.size())){
                    oos.writeObject(p);
                }
            }
            catch(Exception e){}
            this.updateProductTable();
        }
    }

    @FXML
    private void addProductButton(ActionEvent event) {
        Product p;
        String name_ = nameText.getText();
        float price_ = Float.parseFloat(priceText.getText());
        float vatRate_ = Float.parseFloat(vatText.getText());
        
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
        
        try{
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (productFile.exists()){
                fos = new FileOutputStream(productFile,true);
                    oos = new ObjectOutputStreamA(fos);
            }
            else{
                fos = new FileOutputStream(productFile);
                    oos = new ObjectOutputStream(fos);
            }
                oos.writeObject(p);
                System.out.println("Object Written");
            }catch(Exception e){System.out.println(e);}
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

    @FXML
    private void updateSelectedCategory(MouseEvent event) {
        selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void updateSelectedProduct(MouseEvent event) {
        selectedProduct = tableView.getSelectionModel().getSelectedItem();
    }
}
