/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author hasin
 */
public class MainpkgSwitcher {
    public void switchScene(String fxml, String title) throws IOException{
        Main.getMainStage().setTitle(title);
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void switchtoLoginScene() throws IOException{
        Main.getMainStage().setTitle("Keya Cosmetics: Login");
        Parent root = FXMLLoader.load(getClass().getResource("LoginSignupScene.fxml"));
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    
}
