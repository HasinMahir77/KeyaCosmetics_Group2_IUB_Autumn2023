/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 88019
 */
public class GenerateReport implements Serializable{
    String name;
    String category;
    Float amount;
    String date;
    String report;


    public GenerateReport(String name, String category, Float amount, String date, String report) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.report = report;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GenerateReport{" + "name=" + name + ", category=" + category + ", amount=" + amount +  ", date=" + date + ", report=" + report + '}';
    }


    private static final String REPORT_FILE_PATH = "reportsGENERATED.bin";
    
    public static void saveGeneratedReports(String name, String category, Float amount, String date, String report) {
        GenerateReport generatedReport = new GenerateReport(name, category, amount, date, report);
        List<GenerateReport> existingReports = loadGeneratedReport();
        existingReports.add(generatedReport);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REPORT_FILE_PATH))) {
            for (GenerateReport reports : existingReports) {
                oos.writeObject(reports);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<GenerateReport> loadGeneratedReport() {
        List<GenerateReport> generatedReports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REPORT_FILE_PATH))) {
            while (true) {
                try {
                    GenerateReport reports = (GenerateReport) ois.readObject();
                    generatedReports.add(reports);
                } catch (EOFException e) {
                    break; // Exit loop when EOF is reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return generatedReports;
    }     
}
