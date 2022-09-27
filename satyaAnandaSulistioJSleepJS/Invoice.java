package satyaAnandaSulistioJSleepJS;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    public String time;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId, String time)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    
     public Invoice(int id, Account buyer, Renter renter, String time)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String print()
    {
        // put your code here
        String buffer = "buyerId: " + buyerId + " renterId: "+ renterId + " time: " + time;  
        return buffer;
    }
}
