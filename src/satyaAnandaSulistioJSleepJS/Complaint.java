package satyaAnandaSulistioJSleepJS;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
    // instance variables - replace the example below with your own
    public String desc;
    public String date;

    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(String date, String desc)
    {
        // initialise instance variables
        this.date = date;
        this.desc = desc;
    }

    /**
     * Print fields dari class ini
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        return ("Date: " + date + " Desc: " + desc);
    }
}
