package com.satyaAnandaSulistioJSleepJS;
import java.util.*;
import java.text.*;
import java.time.LocalDate;

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
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to){
        super(buyerId, renterId);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }
    
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to){
        super(buyer, renter);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }

    
    public static boolean makeBooking(Date from, Date to, Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for(Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()){
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Printing the value of fields in the Payment class
     *
     * @return    All the fields value from the class Payment
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
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for(Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()){
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }
}
