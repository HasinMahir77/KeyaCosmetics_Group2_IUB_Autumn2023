/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HasinMahir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.MainpkgSS;

/**
 * FXML Controller class
 *
 * @author hasin
 */
public class TakeReviewController implements Initializable {

    @FXML
    private TextArea reviewTextField;
    @FXML
    private Button reviewButton;
    @FXML
    private Label reviewingLabel;
    @FXML
    private TextField ratingTextField;

    /**
     * Initializes the controller class.
     */
    Review review;
    MainpkgSS ss;
    Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stage = Review.getStage(); //Getting current 
        review = (Review)stage.getUserData();
       
        
        reviewingLabel.setText(reviewingLabel.getText()+" "+review.getSubject());
       
    }    

    @FXML
    private void reviewButtonOnClick(ActionEvent event) {
        int rating;
        
       try{ //Trying to make a review with integer rating
           
           rating = Integer.parseInt(ratingTextField.getText());
           
           if (rating>=0 && rating<=10){ //Success
               review.setRating(rating);
               review.setReview(reviewTextField.getText());
               stage.close(); //Closed popup
           }
           else {
               Alert a = new Alert(Alert.AlertType.ERROR,"Please enter a rating between 0 and 10.");
               a.showAndWait();
               //Canceled writing the review
           }
       }
       catch(Exception e){ //Integer rating not found
           Alert a = new Alert(Alert.AlertType.ERROR,"Please enter an integer rating.");
           a.showAndWait();
           //Canceled writing the review
       }
       
       
    }
    
}
