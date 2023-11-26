
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class AddNewInfluencerFXMLController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField socialmediaIDTextField;
    @FXML
    private TextField followersTextField;
    @FXML
    private TextField ageOfInfluence;
    @FXML
    private RadioButton maleradioButton;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton femaleRadioButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void addInfluencerButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String socialmediaID = socialmediaIDTextField.getText();
        int followers = Integer.parseInt(followersTextField.getText());
        int ageOfInf = Integer.parseInt(ageOfInfluence.getText());
        String gender = "Male";
        if(femaleRadioButton.isSelected()) {
            gender = "Female";
        }
        Influencer inf = new Influencer(name, socialmediaID, followers, gender,ageOfInf); 
        AffiliateMarketer.AddNewInfluencer(inf);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Influencer has been added succesfully");
        a.showAndWait();
    }
    
}
