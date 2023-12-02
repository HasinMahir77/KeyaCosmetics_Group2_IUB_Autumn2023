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
public class Expense extends User implements Serializable{
    String name;
    String category;
    Float amount;
    LocalDate date;
    String paymentMethod;
    String reference;
    
    public Expense(){
        
    }

    public Expense(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
    }

    public Expense(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public Expense(String name, String category, Float amount, LocalDate date, String paymentMethod, String reference) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.reference = reference;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Expense{" + "name=" + name + ", category=" + category + ", amount=" 
                + amount + ", date=" + date + ", paymentMethod=" + paymentMethod + 
                ", reference=" + reference + '}';
    }
    
    public void display(){
        System.out.println("Expense{" + "name=" + name + ", category=" +
                category + ", amount=" + amount + ", date=" + date + ", paymentMethod=" +
                paymentMethod + ", reference=" + reference + '}');
    }
    private static final String ALL_EXPENSE_FILE_PATH = "all_expenses.bin";
    private static final String LATEST_EXPENSE_FILE_PATH = "latest_expense.bin";

    public static void saveExpenseRecord(String name, String category, Float amount, LocalDate date, String paymentMethod, String reference) {
        Expense expenseRecord = new Expense(name, category, amount, date, paymentMethod, reference);

        // Save the expense to the all_expenses file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ALL_EXPENSE_FILE_PATH, true))) {
            oos.writeObject(expenseRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save the latest expense to the latest_expense file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LATEST_EXPENSE_FILE_PATH))) {
            oos.writeObject(expenseRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Expense loadLatestExpenseRecord() {
        Expense latestExpense = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LATEST_EXPENSE_FILE_PATH))) {
            latestExpense = (Expense) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return latestExpense;
    }

    public static List<Expense> loadAllExpenseRecords() {
        List<Expense> expenseRecords = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ALL_EXPENSE_FILE_PATH))) {
            while (true) {
                try {
                    Expense expense = (Expense) ois.readObject();
                    expenseRecords.add(expense);
                } catch (EOFException e) {
                    break; // Exit loop when EOF is reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return expenseRecords;
    }

}
