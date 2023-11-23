package Borhan_Islam;

import HasinMahir.User;
import java.io.Serializable;
import java.util.List;


public class Accountant extends User implements Serializable{
    public Accountant(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
        this.del=false;
        
    }    
}
