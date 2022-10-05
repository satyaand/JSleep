package satyaAnandaSulistioJSleepJS;
import java.util.*;
import java.text.*;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Calendar to;
    public Calendar from;
    private int roomId;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        from = Calendar.getInstance();
        to = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        from = Calendar.getInstance();
        to = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return ("Formatted Date = " + sdf.format(super.time.getTime()));
    }
    
    public String getDuration(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return (sdf.format(from.getTime()) + " - " + sdf.format(to.getTime()));
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
        return ("to: " + to + " from: " + from + " roomId: " + roomId);
    }
    
    public int getRoomId(){
        return roomId;
    }
}
