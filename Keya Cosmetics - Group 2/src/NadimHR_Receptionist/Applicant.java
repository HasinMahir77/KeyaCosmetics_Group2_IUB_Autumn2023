/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.List;

public class Applicant {

    private int employeeId;
    private String employeeName;
    private double salary;
    private LocalDate paymentDate;

    public Applicant(int employeeId, String employeeName, double salary, LocalDate paymentDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.paymentDate = paymentDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}


class DataService {
    public static List<Applicant> fetchDataFromDatabase() {
        return Arrays.asList(
                new Applicant(3, "John Smith", 7000.0, LocalDate.now()),
                new Applicant(4, "Jane Smith", 8000.0, LocalDate.now())
                // Add more applicants as needed
        );
    }
}

