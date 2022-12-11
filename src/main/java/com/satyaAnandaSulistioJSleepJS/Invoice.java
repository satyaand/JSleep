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
    /**
     * This field is used to store the ID value of the room's buyer.
     *
     * @since 1.0
     */
    public int buyerId;

    /**
     * This field is used to store the ID value of the room's renter.
     *
     * @since 1.0
     */
    public int renterId;

    /**
     * This field is used to store the status of the room's booking payment.
     *
     * @since 1.0
     */
    public PaymentStatus status;

    /**
     * This field is used to store the rating given to the room.
     *
     * @since 1.0
     */
    public RoomRating rating;

    /**
     * This enum contains three possible status of payment, including WAITING, SUCCESS, and FAILED.
     * Each enums are associated with their actual meaning relative to the status.
     *
     * @author Satya Ananda Sulistio
     * @version 1.0
     */
    public enum PaymentStatus
    {
        WAITING, SUCCESS, FAILED
    }

    /**
     * This enum contains four possible rating given to a room, including BAD, NEUTRAL, GOOD, and NONE.
     * Each enums are associated with their actual meaning relative to the rate.
     *
     * @author Satya Ananda Sulistio
     * @version 1.0
     */
    public enum RoomRating
    {
        BAD, NEUTRAL, GOOD, NONE
    }
    /**
     * Constructor for objects of class Invoice
     * By default, the payment status is set to WAITING and the rating is set to NONE.
     * Implicitly, whenever an invoice is created, it needs to be accepted before being set to SUCCESS.
     *
     * @param buyerId initializes the room's buyer ID
     * @param renterId initializes the room's renter ID
     */
    protected Invoice(int buyerId, int renterId)
    {
        this.buyerId = buyerId;
        this.renterId = renterId;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
    }

    /**
     * Alternative constructor for objects of class Invoice
     * By default, the payment status is set to WAITING and the rating is set to NONE.
     * Implicitly, whenever an invoice is created, it needs to be accepted before being set to SUCCESS.
     *
     * @param buyer initializes the room's buyer ID based on the Account object
     * @param renter initializes the room's renter ID based on the Renter object
     */
     public Invoice(Account buyer, Renter renter)
    {
        // initialise instance variables
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        status = PaymentStatus.WAITING;
        rating = RoomRating.NONE;
    }

    /**
     * A print method that returns the fields value in String.
     *
     * @return    String of fields values
     */
    public String print()
    {
        // put your code here
        return "buyerId: " + buyerId + " renterId: "+ renterId;
    }
}
