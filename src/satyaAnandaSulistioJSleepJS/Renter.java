package satyaAnandaSulistioJSleepJS;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public int phoneNumber;
    public String address;
    public String username;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(String username)
    {
        // initialise instance variables
        this.username = username;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    public Renter(String username, String address)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phoneNumber = 0;
    }
    
    public Renter(String username, int phoneNumber)
    {
        // initialise instance variables
        this.username = username;
        this.address = "";
        this.phoneNumber = phoneNumber;
    }
    
    public Renter(String username, int phoneNumber, String address)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
