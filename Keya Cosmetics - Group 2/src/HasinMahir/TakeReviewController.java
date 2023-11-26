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
        stage = Review.getStage();
        review = (Review)stage.getUserData();
       
        
        reviewingLabel.setText(reviewingLabel.getText()+" "+review.getSubject());
       
    }    

    @FXML
    private void reviewButtonOnClick(ActionEvent event) {
       review.setRating(Integer.parseInt(ratingTextField.getText()));
       review.setReview(reviewTextField.getText());
       stage.close();
    }
    
}
