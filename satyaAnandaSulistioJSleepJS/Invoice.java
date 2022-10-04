package satyaAnandaSulistioJSleepJS;
import java.util.*;


/**
 * Write a description of class Invoice here.
 *
 * @author Satya Ananda Sulistio
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    public Calendar time;
    public PaymentStatus status;
    public RoomRating rating;

    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }
    
    public enum RoomRating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId)
    {
        // initialise instance variables
        super(id);
        time = Calendar.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
    }
    
     public Invoice(int id, Account buyer, Renter renter)
    {
        // initialise instance variables
        super(id);
        time = Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
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
        String buffer = "buyerId: " + buyerId + " renterId: "+ renterId + " time: " + time.getTime();  
        return buffer;
    }
}
