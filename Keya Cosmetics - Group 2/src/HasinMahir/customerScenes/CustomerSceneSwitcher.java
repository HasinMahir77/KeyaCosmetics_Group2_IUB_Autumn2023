/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir.customerScenes;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class CustomerSceneSwitcher {

    public CustomerSceneSwitcher() {
    }
    
    
    public void switchScene(String fxml, String title) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage mainStage = Main.getMainStage();
        mainStage.setTitle(title);
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void switchToAccountScene() throws IOException {
        this.switchScene("CustomerAccountScene.fxml", "Manage Account");
    }
    public void switchToShopScene() throws IOException {
        this.switchScene("CustomerShopScene.fxml", "Shop");
    }
    public void switchToCartScene() throws IOException {
        this.switchScene("CustomerCartScene.fxml", "Cart");
    }
}
