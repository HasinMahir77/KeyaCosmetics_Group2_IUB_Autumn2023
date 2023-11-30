/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.Product;
import HasinMahir.OrderedProduct;
import static HasinMahir.customerScenes.CustomerShopSceneController.current;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import mainpkg.Main;
import mainpkg.MainpkgSS;
import mainpkg.ObjectOutputStreamA;


/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerProductWriterController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TableColumn<Product, Integer> priceColumn;
    @FXML
    private TableColumn<Product, Integer> vatRateColumn;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    private ComboBox<String> categoryBox;
    @FXML
    private TextField vatRateTextField;
    @FXML
    private Button removeButton;
    Product selectedProduct;
    @FXML
    private ListView<String> categoryListView;
    String selectedCategory;
    @FXML
    private ImageView keyaIconS;

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

        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        vatRateColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
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
        productTableView.setItems(productArray);
    }

    @FXML
    private void writeN(ActionEvent event) {
        Product p;
        String name = nameTextField.getText();
        float price = Float.parseFloat(priceTextField.getText());
        float vatRate = Float.parseFloat(vatRateTextField.getText());
        
        if (selectedCategory.equals("Detergent")){
            p = new Product(name,price,Product.Category.DETERGENT,vatRate);
        }
        else if (selectedCategory.equals("Body Soap")){
            p = new Product(name,price,Product.Category.BODY_SOAP,vatRate);
        }
        else if (selectedCategory.equals("Skincare")){
            p = new Product(name,price,Product.Category.SKINCARE,vatRate);
        }
        else if (selectedCategory.equals("Toothpaste")){
            p = new Product(name,price,Product.Category.TOOTHPASTE,vatRate);
        }
        else if (selectedCategory.equals("Deodorant")){
            p = new Product(name,price,Product.Category.DEODORANT,vatRate);
        }
        else if (selectedCategory.equals("Shampoo")) {
            p = new Product(name,price,Product.Category.SHAMPOO,vatRate);
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

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        MainpkgSS ss = new MainpkgSS();
        ss.switchtoLoginScene();
    }

    @FXML
    private void writeE(ActionEvent event) {
        Product p;
        String name = nameTextField.getText();
        float price = Float.parseFloat(priceTextField.getText());
        float vatRate = Float.parseFloat(vatRateTextField.getText());
        
        if (selectedCategory.equals("Detergent")){
            p = new Product(name,price,Product.Category.DETERGENT,vatRate);
        }
        else if (selectedCategory.equals("Body Soap")){
            p = new Product(name,price,Product.Category.BODY_SOAP,vatRate);
        }
        else if (selectedCategory.equals("Skincare")){
            p = new Product(name,price,Product.Category.SKINCARE,vatRate);
        }
        else if (selectedCategory.equals("Toothpaste")){
            p = new Product(name,price,Product.Category.TOOTHPASTE,vatRate);
        }
        else if (selectedCategory.equals("Deodorant")){
            p = new Product(name,price,Product.Category.DEODORANT,vatRate);
        }
        else if (selectedCategory.equals("Shampoo")) {
            p = new Product(name,price,Product.Category.SHAMPOO,vatRate);
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
        productTableView.getItems().clear();
        productTableView.getItems().setAll(productArray);
        
    }


    @FXML
    private void remove(ActionEvent event) {
        if (selectedProduct==null){
        }
        else{
            productTableView.getItems().remove(selectedProduct);
            ObservableList<Product> productArray = productTableView.getItems();
            
            
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
    private void updateSelectedProduct(MouseEvent event) {
        if(!productTableView.getSelectionModel().isEmpty()){
            this.selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        } 
    }

    @FXML
    private void updateSelectedCategory(MouseEvent event) {
        selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
    }
}
