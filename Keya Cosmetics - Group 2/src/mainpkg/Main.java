/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mainpkg;

import HasinMahir.Customer;
import HasinMahir.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        stage.setTitle("Keya Cosmetics: Login");
        stage.show();
        
        //Inserting a user
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO
        
        ArrayList<File> userFiles = new ArrayList<File>();
        
        userFiles.add(new File("CustomerList.bin"));
        userFiles.add(new File("ProductManagerList.bin"));
        userFiles.add(new File("HRList.bin"));
        userFiles.add(new File("ReceptionistList.bin"));
        userFiles.add(new File("AccountantList.bin"));
        
         
        //[Failsafe] Creating empty bin file if it doesn't exist
        
        for (File userFile: userFiles){
            if (!userFile.exists()){
                if (userFile.getName().equals("CustomerList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Customer("User","User","Customer","Customer","User","11111");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                catch(Exception e){
                    System.out.println(e);
                }
              }
                else if (userFile.getName().equals("HRList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Customer("User","User","HR","HR","User","123456");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                catch(Exception e){
                    System.out.println(e);
                }
              }
                else if (userFile.getName().equals("AccountantList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Customer("User","User","Accountant","Accountant","User","1111");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                catch(Exception e){
                    System.out.println(e);
                }
              }
                
            }
            
            
            }//For loop's scope ends
            
        
        //------------------------------------------------------
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
