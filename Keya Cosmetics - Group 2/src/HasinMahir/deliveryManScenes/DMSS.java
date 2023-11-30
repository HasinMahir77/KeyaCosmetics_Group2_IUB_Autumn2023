/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir.deliveryManScenes;

import HasinMahir.Order;
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
public class DMSS {
    private static Stage cartStage;
    
    public DMSS(){}
    
    public void switchScene(String fxml, String title) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage mainStage = Main.getMainStage();
        mainStage.setTitle("Keya: "+title);
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void switchToDashboard() throws IOException{
        this.switchScene("DeliveryManDashboard.fxml", "Dashboard");
    }
    public void switchToProfile() throws IOException{
        this.switchScene("DeliveryManProfile.fxml", "Profile");
    }
    public void switchToTasks() throws IOException{
        this.switchScene("DeliveryManTasks.fxml", "Tasks");
    }
    public void switchToPayments() throws IOException{
        this.switchScene("DeliveryManPayments.fxml", "Payments");
    }
  
    public void showCart(Order order) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("OrderCart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setUserData(order);
        cartStage = stage;
        stage.setScene(scene);
        stage.setTitle("Order Details");        
    }
    
    public static Stage getCartStage(){
        return cartStage;
    }
}
