/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mainpkg;

<<<<<<< HEAD
import Amit_AffiliateMarketer.AffiliateMarketer;
import Borhan_Islam.Accountant;
import Borhan_Islam.ProductManager;
=======
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
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
<<<<<<< HEAD
        // TODO
        
        ArrayList<File> userFiles = new ArrayList<File>();
        
        userFiles.add(new File("CustomerList.bin"));
        userFiles.add(new File("DeliveryManList.bin"));
        userFiles.add(new File("HRList.bin"));
        userFiles.add(new File("ReceptionistList.bin"));
        userFiles.add(new File("AccountantList.bin"));
        userFiles.add(new File("AffiliateMarketerList.bin"));
        userFiles.add(new File("ProductManagerList.bin"));
        
        
        
        //[Failsafe] Creating empty bin file if it doesn't exist
        
        for (File userFile: userFiles){
            if (!userFile.exists()){
                
                //Customer
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
                //HR
                else if (userFile.getName().equals("HRList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Hr("User","User","HR","HR");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                catch(Exception e){
                    System.out.println(e);
                }
              }
                //Accountant
                else if (userFile.getName().equals("AccountantList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Accountant("User","User","acc","acc","123");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
              }
                //Product Manager
                else if (userFile.getName().equals("ProductManagerList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new ProductManager("User","User","pm","pm", "01976967342");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
              }
                //Affiliate Marketer
                else if (userFile.getName().equals("AffiliateMarketerList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new AffiliateMarketer("User","User","User","User");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
              }  
                //Delivery Man
                else if (userFile.getName().equals("DeliveryManList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new DeliveryMan("User","User","User","User","01824441272");
                    user.setDob(LocalDate.now());
                    user.setDoj(LocalDate.now());
                    user.setNid("2152328");
                    oos.writeObject(user);
                    System.out.println("File "+userFile.getName()+" not found.");
                    System.out.println("Initialized");
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
              }  
                //Receptionist
                else if (userFile.getName().equals("ReceptionistList.bin")){
                try(FileOutputStream fos = new FileOutputStream(userFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    User user = new Receptionist("User","User","HR","HR","");
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
=======
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
>>>>>>> parent of 247bdc8 (Merge branch 'Newnadim' into Nadim)
        launch(args);
    }
    public static Stage getMainStage(){
        return mainStage;
    }
    
    
}
