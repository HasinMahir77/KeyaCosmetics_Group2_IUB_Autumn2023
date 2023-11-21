/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

import java.io.*;
import java.time.LocalDate;

public class Applicant implements Serializable {

    private String applicantName;
    private String contactInfo;
    private String position;
    private Integer id;
    private String assignedbyhr;
    private LocalDate assignedDate;
    private String contactInformation;

    public Applicant(String applicantName, String contactInfo, String position, Integer id, String assignedbyhr, LocalDate assignedDate, String contactInformation) {
        this.applicantName = applicantName;
        this.contactInfo = contactInfo;
        this.position = position;
        this.id = id;
        this.assignedbyhr = assignedbyhr;
        this.assignedDate = assignedDate;
        this.contactInformation = contactInformation;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssignedbyhr() {
        return assignedbyhr;
    }

    public void setAssignedbyhr(String assignedbyhr) {
        this.assignedbyhr = assignedbyhr;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

}