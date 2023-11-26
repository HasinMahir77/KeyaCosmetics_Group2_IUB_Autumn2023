/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package NadimHR_Receptionist;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Nadimul
 */
public class EmployeeDetailsController implements Initializable {

    @FXML
    private PieChart PositionTypeChart;
    @FXML
    private BarChart<String,Integer> barchart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadButton(ActionEvent event) {
        PositionTypeChart.getData().clear();
        barchart.getData().clear();
        
        ArrayList<Applicant> Applicants = Hr.loadApplicantsFromFile("Recruiment data of employees.bin");
        int totalCases = Applicants.size();
        int[] caseTypeCounts = new int[5];
        for (Applicant assignment : Applicants) {
            String caseType = assignment.getPosition();
            if (caseType.equals("Accountant")) {
                caseTypeCounts[0]++;
            } else if (caseType.equals("Customer Service Executive")) {
                caseTypeCounts[1]++;
            } else if (caseType.equals("Production manager")) {
                caseTypeCounts[2]++;
            } else if (caseType.equals("Receptionist")) {
                caseTypeCounts[3]++;

            }
        }
         XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>("Accountant", caseTypeCounts[0]));
            series.getData().add(new XYChart.Data<>("Customer Service Executive", caseTypeCounts[1]));
            series.getData().add(new XYChart.Data<>("Production manager", caseTypeCounts[2]));
            series.getData().add(new XYChart.Data<>("Receptionist", caseTypeCounts[3]));
            barchart.getData().add(series);
            
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Accountant (" + caseTypeCounts[0] + " cases)", (double) caseTypeCounts[0] / totalCases),
            new PieChart.Data("Customer Service Executive(" + caseTypeCounts[1] + " cases)", (double) caseTypeCounts[1] / totalCases),
            new PieChart.Data("Production manager (" + caseTypeCounts[2] + " cases)", (double) caseTypeCounts[2] / totalCases),
            new PieChart.Data("Receptionist (" + caseTypeCounts[3] + " cases)", (double) caseTypeCounts[3] / totalCases)
 
        );

        PositionTypeChart.setData(pieChartData);
    }
    
}
