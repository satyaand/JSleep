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

    
    public Account(int id, String name, String email, String password)
    {
        // initialise instance variables
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
