/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

/**
 *
 * @author Nadimul
 */
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Receptionist extends User implements Serializable {

    public Receptionist(String firstName, String lastName, String username, String password, String phone) {
        super(firstName, lastName, username, password, phone);
    }

    static boolean writeObjectsToFile(ObservableList<EmployeeAttendence> items, String HR_Appointmentbin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String username;

    public Receptionist(String userName) {
        this.username = userName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    @Override
    public String toString() {
        return "Receptionistt{" + "username=" + username + '}';
    }

    //-------------File read & write for Receptionist
    public static List<Object> readObjectsFromFile(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)) {
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

    public static boolean writeObjectsToFile(List<Object> objects, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Object obj : objects) {
                oos.writeObject(obj);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //----------------------------------------------
    public static boolean addNewAppointment(CreateAppointment appointment, String fileName) {
        List<Object> appointments = readObjectsFromFile(fileName);
        appointments.add(appointment);
        return writeObjectsToFile(appointments, fileName);
    }
    //-----------------------------------------------

    public static boolean write_Objects_ToFile(ObservableList<EmployeeAttendence> items, String fileName) {
     List<Object> attendanceList = new ArrayList<>(items);
       return writeObjectsToFile(attendanceList, fileName);
     }
        public static boolean addNewOutsiderAttendance(NonEmployeeAttendance items, String fileName) {
        List<Object> attendanceList = readObjectsFromFile(fileName);
        attendanceList.add(items);
        return writeObjectsToFile(attendanceList, fileName);
    }
        //readOysideerATtd
            public static ArrayList<NonEmployeeAttendance> readVisaApplicationsFromFile(String fileName) {
        ArrayList<NonEmployeeAttendance> list = new ArrayList<>();
        File f= null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(fileName);
            ois= new ObjectInputStream(fis);
            while(true){
               try{
                NonEmployeeAttendance Info= (NonEmployeeAttendance) ois.readObject();
                list.add(Info);
               }
               catch(EOFException ef){
                   break;
               }
            }
        }
        catch(Exception e){
            
        }
        finally{
            try{
                if(ois!=null) ois.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return list;
    }
}
