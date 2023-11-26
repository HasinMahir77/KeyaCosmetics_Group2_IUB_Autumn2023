/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import HasinMahir.Product;
import HasinMahir.Review;
import HasinMahir.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class TakeReviewController implements Initializable {

    @FXML
    private Button reviewButton;
    @FXML
    private TextField ratingTextField;
    @FXML
    private TextArea reviewTextField;
    @FXML
    private Label reviewingLabel;

    /**
     * Initializes the controller class.
     */
    Object subject;
    MainpkgSS ss;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Setting the subject
        try{
            subject = (Product)MainpkgSS.getReviewStage().getUserData();
            System.out.println("Reviewing product");
        }
        catch(Exception e){
            subject = (User)MainpkgSS.getReviewStage().getUserData();
            System.out.println("Reviewing user");
        }
       
    }    

    @FXML
    private void reviewButtonOnClick(ActionEvent event) {
        Review review;
    }
    
    
}
