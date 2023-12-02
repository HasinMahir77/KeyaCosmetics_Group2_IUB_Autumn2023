/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Borhan_Islam;

import HasinMahir.User;
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
public class AuditReport extends User implements Serializable{
    private String title;
    private String detailedReport;
    private LocalDate date;

    public AuditReport(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
    }

    public AuditReport(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public AuditReport(){
    
    }

    public AuditReport(String title, String detailedReport, LocalDate date) {
        this.title = title;
        this.detailedReport = detailedReport;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailedReport() {
        return detailedReport;
    }

    public void setDetailedReport(String detailedReport) {
        this.detailedReport = detailedReport;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AuditReport{" + "title=" + title + ", detailedReport=" + detailedReport + ", date=" + date + '}';
    }
    
    public void Display(){
        System.out.println("AuditReport{" + "title=" + title + ", detailedReport=" + detailedReport + ", date=" + date + '}');
    }
    private static final String AUDIT_FILE_PATH = "audit.bin";
    
    public static void saveAuditReportRecord(String title, String detailedReport, LocalDate date) {
        AuditReport auditReport = new AuditReport(title, detailedReport, date);
        List<AuditReport> existingAudits = loadAuditReportRecords();
        existingAudits.add(auditReport);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AUDIT_FILE_PATH))) {
            for (AuditReport audits : existingAudits) {
                oos.writeObject(audits);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<AuditReport> loadAuditReportRecords() {
        List<AuditReport> auditReports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AUDIT_FILE_PATH))) {
            while (true) {
                try {
                    AuditReport audits = (AuditReport) ois.readObject();
                    auditReports.add(audits);
                } catch (EOFException e) {
                    break; // Exit loop when EOF is reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return auditReports;
    } 
}
