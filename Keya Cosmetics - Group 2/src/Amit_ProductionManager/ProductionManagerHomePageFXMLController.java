
package Amit_ProductionManager;

import Amit_AffiliateMarketer.AffiliateMarketer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.LogoutSceneSwitcher;
import mainpkg.Main;


public class ProductionManagerHomePageFXMLController implements Initializable {

    ProductionManager pm;
    @FXML
    private BorderPane borderPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pm = (ProductionManager)Main.getUserData();
    }    

    @FXML
    private void manageInventoryOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void improveProcessOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductionProcessImprovementsFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
        
    }

    @FXML
    private void scheduleMachineRepairOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScheduleMachineRepair.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void createTimelineOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateTimelineFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void viewTimelineOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewTimeLineFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void AddNewMachineOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewMachineFXML.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void manageVendorsOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageVendors.fxml"));
        Parent root = loader.load();
        borderPane.setCenter(root);
    }

    @FXML
    private void LogoutOnClick(ActionEvent event) throws IOException {
        Main.getMainStage().setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/LoginSignupScene.fxml"));
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    
}
