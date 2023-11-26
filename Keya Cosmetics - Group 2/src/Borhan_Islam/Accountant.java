package Borhan_Islam;

import HasinMahir.Cart;
import HasinMahir.User;
import java.io.Serializable;
import java.util.List;
import mainpkg.ObjectOutputStreamA;


public class Accountant extends User implements Serializable{
    public Accountant() {
    }
    
    public Accountant(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.del=false;

    }
    public String toString() {
        return ("Accountant "+"Name: "+this.firstName+" "+this.lastName+", Username: "+this.username);
    }
}
