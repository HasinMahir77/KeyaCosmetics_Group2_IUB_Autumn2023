/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hasin
 */
public class MainpkgSS {
    
    static Stage reviewStage;
    
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
    public void switchtoRegisterEmployeeScene() throws IOException{
        Main.getMainStage().setTitle("Keya Cosmetics: Employee Registration");
        Parent root = FXMLLoader.load(getClass().getResource("RegisterEmployeeScene.fxml"));
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void takeReviewScene(Stage stage) throws IOException{
        reviewStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("TakeReview.fxml"));
        stage.setTitle("Review");
        Scene scene = new Scene(root);
        stage.show();
    }
    public static Stage getReviewStage(){
        return reviewStage;
    }
    
    
}
