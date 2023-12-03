/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mainpkg;

import Borhan_Islam.Accountant;
import HasinMahir.Customer;
import HasinMahir.DeliveryMan;
import HasinMahir.Order;
import HasinMahir.User;
import NadimHR_Receptionist.Hr;
import NadimHR_Receptionist.Receptionist;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
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
        stage.setTitle("hahaKeya Cosmetics: Login");
        stage.show();
        
        //Inserting a user
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO
        launch(args);
    }
    public static Stage getMainStage(){
        return mainStage;
    }
    public static void setUserData(User user){
        mainStage.setUserData(user);
    }
    public static Object getUserData(){
        return mainStage.getUserData();
    }
}
