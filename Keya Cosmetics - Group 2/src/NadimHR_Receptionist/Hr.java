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
import java.util.List;
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
    //recruitment and selection
        public static List<Object> readObjectsFromFile(String applicantfileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(applicantfileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj != null) {
                        objects.add(obj);
                        }
                    } catch (EOFException e) {
                        break;
                   }
               }
           } catch (IOException | ClassNotFoundException ex) {
               ex.printStackTrace();
           }
           return objects;
           }
           
}
