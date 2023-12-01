/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

import HasinMahir.Cart;
import HasinMahir.User;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Nadimul
 */
public class Hr extends User implements Serializable{
  
    public Hr(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.del=false;
        this.policyFile = null;
    }
 
  //reimbursementRequestRecord
    public static boolean writeReimbursements(ObservableList<ReimbursementRequestRecord> reimbursements, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            for (ReimbursementRequestRecord reimbursement : reimbursements) {
                oos.writeObject(reimbursement);
            }

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
 

    public static ArrayList<ReimbursementRequestRecord> loadReimbursements(String fileName) {
        ArrayList<ReimbursementRequestRecord> existingReimbursements = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    ReimbursementRequestRecord reimbursement = (ReimbursementRequestRecord) ois.readObject();
                    existingReimbursements.add(reimbursement);
                } catch (EOFException eof) {
                    // End of file reached, break the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return existingReimbursements;
    }
    //workpolicies
    private final File policyFile;

    public Hr() {
        policyFile = new File("updatedpolicies.bin");
    }

    public void savePolicy(String policyText) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(policyFile))) {
            oos.writeObject(policyText);
            showAlert("Policy saved successfully.", Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            showAlert("Error saving policy.", Alert.AlertType.ERROR);
        }
    }

    public String loadPolicy() {
        String policyText = "";

        if (policyFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(policyFile))) {
                policyText = (String) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                showAlert("Error loading policy.", Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Policy file not found.", Alert.AlertType.WARNING);
        }

        return policyText;
    }
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Policy Update");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
       //applicant
        public static ArrayList<Applicant> loadApplicantsFromFile(String fileName) {
        ArrayList<Applicant> applicant = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Applicant applicants = (Applicant) ois.readObject();
                    applicant.add(applicants);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return applicant;
    }
       public static ObservableList<Applicant> loadApplicantsToFiles(String fileName) {
        ArrayList<Applicant> applicant = loadApplicantsFromFile(fileName);
        ObservableList<Applicant> observableList = FXCollections.observableArrayList(applicant);
        return observableList;
    }
       public static boolean writeloadApplicantsFromFile(ObservableList<Applicant> Applicants, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            for (Applicant applicants: Applicants) {
                oos.writeObject(applicants);
            }

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //recruitment and selection
    public static void saveRecruiemntDataofApplicants(Applicant applicant, String fileName) {
        ArrayList<Applicant> existingApplicants = loadApplicantsFromFile(fileName);
        existingApplicants.add(applicant);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Applicant applicants : existingApplicants) {
                oos.writeObject(applicants);
            }
            System.out.println("Data saved: " + applicant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //chart of applicants
      public static Map<String, Double> calculatePositionType(ArrayList<Applicant> applicants) {
        Map<String, Double> positionTypeRatioMap = new HashMap<>();
        int totalApplicants= applicants.size();

        for (String Position : getapplicantstypes(applicants)) {
            long count = applicants.stream()
                    .filter(ca -> ca.getPosition().equals(Position))
                    .count();
            double ratio = (double) count / totalApplicants * 100;
            positionTypeRatioMap.put(Position, ratio);
        }

        return positionTypeRatioMap;
    }

    private static ArrayList<String> getapplicantstypes(ArrayList<Applicant> applicants) {
        ArrayList<String> ApplicantType = new ArrayList<>();
        for (Applicant Position : applicants) {
            if (!ApplicantType.contains(Position.getPosition())) {
                ApplicantType.add(Position.getPosition());
            }
        }
        return ApplicantType;
    }
    //sort
        public static void updateFile(ObservableList<Applicant> sortedApp, String fileName) {
    try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
        for (Applicant applicant : sortedApp) {
            output.writeObject(applicant);
        }
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    public static void sortedapplicant(Applicant applicant, String fileName) {
        ArrayList<Applicant> exsApp = loadApplicantsFromFile(fileName);
        exsApp.add(applicant);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Applicant sortedapplicant : exsApp) {
                oos.writeObject(sortedapplicant);
            }
            System.out.println("Sorted Applicants saved: " + applicant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
