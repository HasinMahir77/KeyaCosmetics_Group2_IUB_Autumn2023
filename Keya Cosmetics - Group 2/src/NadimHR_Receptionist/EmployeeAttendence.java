/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Nadimul
 */
public class EmployeeAttendence implements Serializable{
    private String name;
    private String post;
    private String time;
    private LocalDate TimeCol;

    public EmployeeAttendence(String name, String post, String time) {
        this.name = name;
        this.post = post;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
}
