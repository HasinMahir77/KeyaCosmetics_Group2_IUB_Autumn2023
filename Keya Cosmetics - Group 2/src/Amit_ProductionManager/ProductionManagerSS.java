/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amit_ProductionManager;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class ProductionManagerSS {
    public ProductionManagerSS(){}
    
    public void switchScene(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage mainStage = Main.getMainStage();
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void switchScene(String fxml, String title) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage mainStage = Main.getMainStage();
        mainStage.setTitle("Keya: "+title);
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void switchDashboard() throws IOException{
        this.switchScene("ProductionManagerHomePageFXML.fxml","Home");
    }
}
