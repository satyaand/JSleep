package satyaAnandaSulistioJSleepJS;


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

    
    public Account(String name, String email, String password)
    {
        // initialise instance variables
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return ("Name: " + name + " Email: " + email + " Password: " + password);
    }
    

    public boolean read(String s){
        return false;
    }
    

    public Object write(){
        return null;
    }
}
