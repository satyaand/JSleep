package com.satyaAnandaSulistioJSleepJS;
import java.util.*;

/**
 * Payment class is used to store the payment made by accounts to book rooms.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Payment extends Invoice
{
    /**
     * This field stores the check-in date of a room's booking.
     *
     * @since 1.0
     */
    public Date to;

    /**
     * This field stores the check-out date of a room's booking.
     *
     * @since 1.0
     */
    public Date from;

    /**
     * This field stores the ID of the room being paid.
     *
     * @since 1.0
     */
    private int roomId;

    /**
     * Constructor for objects of class Payment.
     *
     * @param buyerId initializes the ID of a room's buyer
     * @param renterId initializes the ID of a room's renter
     * @param roomId initializes the ID of a room
     * @param from initializes the check-in date
     * @param to initializes the check-out date
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to){
        super(buyerId, renterId);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }

    /**
     * Constructor for objects of class Payment.
     *
     * @param buyer initializes the ID of a room's buyer from Account object
     * @param renter initializes the ID of a room's renter from Renter object
     * @param roomId initializes the ID of a room
     * @param from initializes the check-in date
     * @param to initializes the check-out date
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to){
        super(buyer, renter);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }

    /**
     * This method adds booking time to the booked field (list) in the object Room.
     * It checks the availability of a room within the span of date ranging from the parameter "from" until "to".
     * The availability is checked through a method called availability.
     *
     * @param from initializes the check-in date to be made booking
     * @param to initializes the check-out date to be made booking
     * @param room The room about to be booked if the conditions are met.
     * @return true if booking is successful, otherwise false
     */
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

    /**
     * Return the field roomId due to the nature of private identifier. This is the getter method for that field.
     *
     * @return roomId value
     */
    public int getRoomId(){
        return roomId;
    }

    /**
     * Checks whether there's a conflict in booking date.
     * If there's none, the room is available to book, otherwise the room is already booked.
     *
     * @param from the check-in date
     * @param to the check-out date
     * @param room the room about to be booked
     * @return true if the room is available, otherwise false
     */
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
