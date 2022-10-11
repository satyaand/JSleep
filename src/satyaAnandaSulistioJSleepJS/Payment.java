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
    public Date to;
    public Date from;
    private int roomId;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer, renter);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return ("Formatted Date = " + sdf.format(super.time.getTime()));
    }
    
    public static boolean makeBooking(Date from, Date to, Room room){
        boolean reserved = false;
        Date dateTemp = new Date(to.getTime() - from.getTime());
        int length = dateTemp.getDate();
        
        if(availability(from, to, room)){
            for(int i = 0; i < length; i++){
                Date insertedDate = new Date(from.getTime() + (86400000 * i));
                room.booked.add(insertedDate);
            }
            reserved = true;
        } else {
            reserved = false;
        }
        return reserved;
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
    
    public static boolean availability(Date from, Date to, Room room){
        if(to.before(from)){
            return false;
        } else if(room.booked.size() == 0){
            return true;
        }

        int comparatorFrom = 0;
        int comparatorTo = 0;
        for(int i = 0; i < room.booked.size() - 1; i++){
            comparatorFrom = from.compareTo(room.booked.get(i));
            if(comparatorFrom == 0){
                for(int j = i; j < room.booked.size() - 1; j++){
                    comparatorTo = to.compareTo(room.booked.get(j));
                    if(comparatorTo == 0){
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
