/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mainpkg;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 *
 * @author hasin
 */
public class ObjectWriterController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void writeProductScene(ActionEvent event) throws IOException {
        Scene scene = Main.getMainStage().getScene();
        Parent root = FXMLLoader.load(getClass().getResource("ProductWriter.fxml"));
        scene.setRoot(root);
        System.out.println("SS called");
    }
    
}
