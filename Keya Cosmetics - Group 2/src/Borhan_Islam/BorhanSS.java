/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

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
    public void generateReportOnButtonClicked() throws IOException {
        this.switchScene("GenerateReportFXML.fxml", "Generate Report");
    }
    public void productionAnalysisOnButtonClicked() throws IOException {
        this.switchScene("ProductionAnalysisFXML.fxml", "Production Analysis");
    }
    public void payrollOnButtonClicked() throws IOException {
        this.switchScene("PayrollFXML.fxml", "Payroll");
    }
    public void auditReportOnButtonClicked() throws IOException {
        this.switchScene("AuditReportFXML.fxml", "Audit Report");
    }
    public void updatedTermsOnButtonClicked() throws IOException {
        this.switchScene("UpdatedTermsFXML.fxml", "Updated Terms");
    }
    public void expenseControlOnButtonClicked() throws IOException {
        this.switchScene("ExpenseControlSysFXML.fxml", "Expense Control");
    }
    public void reimbursementOnButtonClicked() throws IOException {
        this.switchScene("ReimbursementFXML.fxml", "Reimbursement");
    }
    public void accProfileOnButtonClicked() throws IOException {
        this.switchScene("AccProfileFXML.fxml", "Accountant Profile");
    }
    public void addproductOnButtonClicked() throws IOException {
        this.switchScene("AddProductFXML.fxml", "Add Products");
    }
    public void seeProductDetailsOnButtonClicked() throws IOException {
        this.switchScene("ProductDetailsFXML.fxml", "See Product Details");
    }
    public void reviewProductsOnButtonClicked() throws IOException {
        this.switchScene("ReviewProductFXML.fxml", "Review Products");
    }
    public void viewStockOnButtonClicked() throws IOException {
        this.switchScene("ViewStockFXML.fxml", "View Products");
    }
    public void newProductIdeaOnButtonClicked() throws IOException {
        this.switchScene("NewProductIdeaFXML.fxml", "New Product Idea");
    }
    public void pmProfileOnButtonClicked() throws IOException {
        this.switchScene("PmProfileFXML.fxml", "Product Manager Profile");
    }
    public void switchToAccDashboard() throws IOException {
        this.switchScene("AccountantDashboardFXML.fxml", "");
    }
    public void switchToPmDashboard() throws IOException {
        this.switchScene("ProductManagerDashboardFXML.fxml", "");
    }

}
