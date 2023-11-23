/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class ProductWriterController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private TextField vatRateTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        categoryBox.getItems().addAll("Laundry Soap","Body Soap",
                "Toothpaste","Deo","Skincare","Petroleum");
        
    }    

    @FXML
    private void writeN(ActionEvent event) {
        Product p;
        String name = nameTextField.getText();
        int price = Integer.parseInt(priceTextField.getText());
        int vatRate = Integer.parseInt(vatRateTextField.getText());
        if (categoryBox.getValue().equals("Laundry Soap")){
            p = new Product(name,price,Product.Category.LAUNDRY_SOAP,vatRate);
        }
        else if (categoryBox.getValue().equals("Body Soap")){
            p = new Product(name,price,Product.Category.BODY_SOAP,vatRate);
        }
        else if (categoryBox.getValue().equals("Skincare")){
            p = new Product(name,price,Product.Category.SKINCARE,vatRate);
        }
        else if (categoryBox.getValue().equals("Toothpaste")){
            p = new Product(name,price,Product.Category.TOOTHPASTE,vatRate);
        }
        else if (categoryBox.getValue().equals("Deo")){
            p = new Product(name,price,Product.Category.DEODORANT,vatRate);
        }
        else {
            p = new Product(name,price,Product.Category.PETROLEUM_JELLY,vatRate);
        }
        //Writing
        FileChooser fc = new FileChooser();
        File productFile = fc.showSaveDialog(null);
        
        try(FileOutputStream fos = new FileOutputStream(productFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(p);
                System.out.println("Object Written");
            }catch(Exception e){}
    }

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        MainpkgSwitcher ss = new MainpkgSwitcher();
        ss.switchtoLoginScene();
    }

    @FXML
    private void writeE(ActionEvent event) {
        Product p;
        String name = nameTextField.getText();
        int price = Integer.parseInt(priceTextField.getText());
        int vatRate = Integer.parseInt(vatRateTextField.getText());
        if (categoryBox.getValue().equals("Laundry Soap")){
            p = new Product(name,price,Product.Category.LAUNDRY_SOAP,vatRate);
        }
        else if (categoryBox.getValue().equals("Body Soap")){
            p = new Product(name,price,Product.Category.BODY_SOAP,vatRate);
        }
        else if (categoryBox.getValue().equals("Skincare")){
            p = new Product(name,price,Product.Category.SKINCARE,vatRate);
        }
        else if (categoryBox.getValue().equals("Toothpaste")){
            p = new Product(name,price,Product.Category.TOOTHPASTE,vatRate);
        }
        else if (categoryBox.getValue().equals("Deo")){
            p = new Product(name,price,Product.Category.DEODORANT,vatRate);
        }
        else {
            p = new Product(name,price,Product.Category.PETROLEUM_JELLY,vatRate);
        }
        //Writing
        FileChooser fc = new FileChooser();
        File productFile = fc.showOpenDialog(null);
        
        try(FileOutputStream fos = new FileOutputStream(productFile,true);
                    ObjectOutputStream oos = new ObjectOutputStreamA(fos)){
                oos.writeObject(p);
                System.out.println("Object Written");
            }catch(Exception e){}
    }
    
}
