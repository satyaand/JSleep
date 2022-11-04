package satyaAnandaSulistioJSleepJS;

import java.util.regex.*;

/**
 * Write a description of class Account here.
 *
 * @author Satya Ananda Sulistio
 * @version (a version number or a date)
 */

public class Account extends Serializable
{
    // instance variables
    public String name;
    public String email;
    public String password;
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]*[.]{1}[a-zA-Z]*$";
    public final static String REGEX_PASSWORD = "^(?!.*\\s)(?!.*[@#$%^&-+=!_])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

    public Account(String name, String email, String password)
    {
        // initialise instance variables
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return ("Account{name=" + name + ", email=" + email + ", password=" + password + ", id=" + id + "}");
    }
    

    public boolean read(String s){
        return false;
    }
    
    public boolean validate(){
        if(email == null || password == null || email.isBlank() || password.isBlank()){
            return false;
        }
        boolean mEmail = Pattern.compile(REGEX_EMAIL).matcher(email).matches();
        boolean mPass = Pattern.compile(REGEX_PASSWORD).matcher(password).matches();
        return (mEmail && mPass);
    }

    public Object write(){
        return null;
    }
}
