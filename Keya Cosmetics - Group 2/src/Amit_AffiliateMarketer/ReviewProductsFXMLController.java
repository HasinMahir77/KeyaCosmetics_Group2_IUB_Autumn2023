package Amit_AffiliateMarketer;

import HasinMahir.Product;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ReviewProductsFXMLController implements Initializable {


    @FXML
    private ComboBox<String> selectProductCombobox;
    @FXML
    private TextArea reviewTextArea;
    ObservableList <Product> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        try {
             Product c;
             ois = new ObjectInputStream(new FileInputStream("ProductList.bin"));
             
            while(true){
                c = (Product) ois.readObject();
                list.add(c);
                selectProductCombobox.getItems().addAll(c.getName());
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }    
    
    @FXML
    private void submitButtonOnClick(MouseEvent event) {
        String review = reviewTextArea.getText();
        String productName = selectProductCombobox.getValue();
        Product selectedProduct = null;
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i).getName().equals(productName)) {
                selectedProduct = list.get(i);
            }
        }
        ProductReview pr = new ProductReview(selectedProduct, review);
        AffiliateMarketer.AddNewReview(pr);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Review has been submitted successfully");
        a.showAndWait();
        
    }

}
