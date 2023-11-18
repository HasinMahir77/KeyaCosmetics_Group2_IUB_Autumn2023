/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.io.Serializable;

/**
 *
 * @author hasin
 */
public class CustomerServiceExecutive extends User implements Serializable {

    public CustomerServiceExecutive() {
    }

    public CustomerServiceExecutive(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }
    public String toString() {
        return ("Customer Service Exec "+"Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
    
}
