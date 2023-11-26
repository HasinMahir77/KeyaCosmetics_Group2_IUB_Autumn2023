/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir.customerScenes;

import HasinMahir.Customer;
import HasinMahir.Product;
import HasinMahir.Product.Category;
import HasinMahir.ProductOrder;
import HasinMahir.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import mainpkg.MainpkgSwitcher;
import mainpkg.Main;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class CustomerShopSceneController implements Initializable {
    static Customer current;

    @FXML
    private MenuBar userMenuBar;
    @FXML
    private MenuItem ordersMenuItem;
    @FXML
    private ListView<String> categoryListView;    
    @FXML
    private Button cartButton;
    @FXML
    private TextField quantityTextField;
    @FXML
    private Menu userMenu;
    @FXML
    private MenuItem accountMenuItem;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private ImageView keyaIcon;
    @FXML
    private TextField searchTextField;
    private Label searchLabel;
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
    private Button shopButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    
    
    Product selectedProduct;
    String selectedCategory;
    ObservableList<Product> productArray = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initializing Quanity text field
        quantityTextField.setText("1");
        // Initializing Category List
        current = (Customer)Main.getMainStage().getUserData(); 
     
     //Initializing CategoryListView   
        userMenu.setText(current.getUsername()+" ↓");
        categoryListView.getItems().addAll("All","Detergent","Body Soap",
                "Toothpaste","Deodorant","Skincare","Shampoo");
        
        //Initializing Product TableView
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        vatRateColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        //Collecting products from file
        
        this.productArray = FXCollections.observableArrayList(); //Array to store products
        File productFile = new File("ProductList.bin");
        
        try(FileInputStream fis = new FileInputStream(productFile);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            while(true){
                this.productArray.add((Product)ois.readObject());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //Inserting Products into TableView
        productTableView.setItems(productArray);
    }   

    @FXML
    private void darkenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #79edad");
    }

    @FXML
    private void lightenGreenButtonOnHover(MouseEvent event) {
        ((Button)event.getSource()).setStyle("-fx-background-color: #affad3");  
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        MainpkgSwitcher logout = new MainpkgSwitcher();
        logout.switchtoLoginScene();
    }

    @FXML
    private void lightenUserMenuBar(MouseEvent event) {
        //userMenuBar.setStyle("-fx-background-color: #affad3");
        userMenu.setStyle("-fx-background-color: #affad3");
    }

    @FXML
    private void darkenUserMenuBar(MouseEvent event) {
        userMenu.setStyle("-fx-background-color: #58db95");
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void switchToAccountScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToAccountScene();
    }
    @FXML
    private void switchToCartScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToCartScene();
    }

    @FXML
    private void minusButtonOnClick(ActionEvent event) {
        int q;
        try{
            q = Integer.parseInt(quantityTextField.getText())-1;
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
            return;
        }
        if (q<=1){
            quantityTextField.setText(Integer.toString(1));
        }
        else {
            quantityTextField.setText(Integer.toString(q));
        }
        
    }

    @FXML
    private void plusButtonOnClick(ActionEvent event) {
        int q;
        try{
            q = Integer.parseInt(quantityTextField.getText())+1;
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
            return;
        }
        if (q<=1){
            quantityTextField.setText(Integer.toString(1));
        }
        else {
            quantityTextField.setText(Integer.toString(q));
        }
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try{
            Product p = this.selectedProduct;
            current.getCart().add(p,Integer.parseInt(quantityTextField.getText()));
            current.saveInstance();
        }
        catch(NumberFormatException e){
            quantityTextField.setText("1");
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
        }
        catch(NullPointerException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select a product.");
            a.showAndWait();
        }
        
    }

    @FXML
    private void removeButtonOnClick(ActionEvent event) {
        try {
            Product p = this.selectedProduct;
            //Duplicate Checking implemented in Cart class
            current.getCart().remove(p,Integer.parseInt(quantityTextField.getText()));
            current.saveInstance();
        }
        catch(NumberFormatException e){
            quantityTextField.setText("1");
            Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer.");
            a.showAndWait();
        }
        catch(NullPointerException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Please select a product.");
            a.showAndWait();
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
        //Checking if any category text was clicked
        if (categoryListView.getSelectionModel().isEmpty()){
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("All")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            productTableView.setItems(this.productArray);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Skincare")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Toothpaste")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Body Soap")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Shampoo")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Deodorant")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Petroleum")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
        else if(categoryListView.getSelectionModel().getSelectedItem().equals("Detergent")){
            this.selectedCategory = categoryListView.getSelectionModel().getSelectedItem();
            
            ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
            for (Product p: this.productArray){
                if (p.getCategory().equals(this.selectedCategory)){
                    selectedProducts.add(p);
                }
            }
            productTableView.setItems(selectedProducts);
        }
    }
    @FXML
    private void switchToOrderScene(ActionEvent event) throws IOException {
        CustomerSceneSwitcher ss = new CustomerSceneSwitcher();
        ss.switchToOrderScene();
    }
        
    
}
