/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.Main;

/**
 *
 * @author hasin
 */
public class BorhanSS {
    
    public BorhanSS() {
    }
    
    public void switchScene(String fxml, String title) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage mainStage = Main.getMainStage();
        mainStage.setTitle("Keya: "+title);
        Scene scene = Main.getMainStage().getScene();
        scene.setRoot(root);
    }
    public void recordsOnButtonClicked() throws IOException {
        this.switchScene("RecordsFXML.fxml", "Records");
    }
    public void searchDeleteOnButtonClicked() throws IOException {
        this.switchScene("SearchOrDeleteFXML.fxml", "Search & Delete");
    }
    public void generateReportOnButtonClicked() throws IOException {
        this.switchScene("GenerateReportFXML.fxml", "");
    }
    public void transactionOnButtonClicked() throws IOException {
        this.switchScene("TransactionFXML.fxml", "");
    }
    public void profileOnButtonClicked() throws IOException {
        this.switchScene("ProfileFXML.fxml", "");
    }
    public void logoutOnButtonClicked() throws IOException {
        this.switchScene("LoginGrid.fxml", "");
    }
    public void incomeStatementOnButtonClicked() throws IOException {
        this.switchScene("IncomeFXML.fxml", "");
    }
    public void productionAnalysisOnButtonClicked() throws IOException {
        this.switchScene("ProductionAnalysisFXML.fxml", "");
    }
    public void expenseControlSysOnButtonClicked() throws IOException {
        this.switchScene("ExpenseControlSysFXML.fxml", "");
    }
  
}
