package com.satyaAnandaSulistioJSleepJS;
import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.*;


/**
 * Write a description of class Invoice here.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    public enum PaymentStatus
    {
        WAITING, SUCCESS, FAILED
    }
    
    public enum RoomRating
    {
        BAD, NEUTRAL, GOOD, NONE
    }
    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int buyerId, int renterId)
    {
        // initialise instance variables
        this.buyerId = buyerId;
        this.renterId = renterId;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
    }
    
     public Invoice(Account buyer, Renter renter)
    {
        // initialise instance variables
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return    string of fields values
     */
    public String print()
    {
        // put your code here
        return "buyerId: " + buyerId + " renterId: "+ renterId;
    }
}
