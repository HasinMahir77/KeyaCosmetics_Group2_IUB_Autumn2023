/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mainpkg;

import HasinMahir.Customer;
import NadimHR_Receptionist.Hr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hasin
 */
public class Main extends Application {
    private static Stage mainStage; // MainStage is the only stage and is updated.
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginSignupScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("HRList.bin");
        if (f.exists()){
            System.out.println("HRList.bin exists");
        } else{
            try(FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                Hr HR = new Hr("hr","nadim","hr","12345678");
                oos.writeObject(HR);
                System.out.println("HR Written");
            }catch(Exception e){System.out.println(e);}
        }
        launch(args);
    }
    public static Stage getMainStage(){
        return mainStage;
    }
    
    
}
