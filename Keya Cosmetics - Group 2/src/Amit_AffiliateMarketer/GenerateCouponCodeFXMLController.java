
package Amit_AffiliateMarketer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class GenerateCouponCodeFXMLController implements Initializable {

    @FXML
    private ComboBox<String> percentageCombobox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        percentageCombobox.getItems().addAll("5", 
                "10",
                "15",
                "20",
                "25",
                "30",
                "35",
                "40",
                "50");
    }    

    @FXML
    private void generateCouponCodeButtonOnClick(MouseEvent event) {
        int percentage = Integer.parseInt(percentageCombobox.getValue());
        String couponCode = AffiliateMarketer.generateCouponCode();
        CouponCode coupon = new CouponCode(couponCode, percentage);
        AffiliateMarketer.AddNewCouponCode(coupon);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("New Copuon has been added submitted successfully\n"
                + "Coupon Code: " + couponCode);
        a.showAndWait();
        
    }
    
}
