package com.satyaAnandaSulistioJSleepJS;
import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.*;

/**
 * This class is the blueprint for Room object. It holds the attributes of a Room.
 * It extends Serializable class to generate a room ID incrementally.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Room extends Serializable
{
    /**
     * This field is used to store the size of a room in metres squared.
     *
     * @since 1.0
     */
    public int size;

    /**
     * This field is used to store the ID that rents the room.
     *
     * @since 1.0
     */
    public int accountId;

    /**
     * This field is used to store a room's name
     *
     * @since 1.0
     */
    public String name;

    /**
     * This field is an ArrayList with type Facility enum. It allows storing for multiple facilities.
     *
     * @since 1.0
     */
    public ArrayList<Facility> facility;

    /**
     * This field is a Price object. It contains the room's price and discount value.
     *
     * @since 1.0
     */
    public Price price;

    /**
     * This field stores the room's address.
     *
     * @since 1.0
     */
    public String address;

    /**
     * This field is a BedType enum type. It indicates a room's bed size.
     *
     * @since 1.0
     */
    public BedType bedType;

    /**
     * This field is a City enum type. It stores the city where a room is located.
     *
     * @since 1.0
     */
    public City city;

    /**
     * This field is an ArrayList with type Date. It stores the dates when the room is occupied/booked.
     *
     * @since 1.0
     */
    public ArrayList<Date> booked = new ArrayList<Date>();

    /**
     * Constructor for objects of Room class
     *
     * @param accountId initializes accountId
     * @param name initializes name
     * @param price initializes price
     * @param facility initializes facility
     * @param city initializes city
     * @param size initializes size
     * @param address initializes address
     * @param bedType initializes bedType
     */
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType)
    {
        // initialise instance variables
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType;
    }

    /**
     * This method returns the class' fields value in String.
     *
     * @return the class' fields value in String
     */
    public String toString(){
        return ("Size: " + size + " Name: " + name + " Facility: " + facility + " Price: " + price + " Address: " + address + " Bed Type: " + bedType + " City: " + city + " id: " + id + " booked: " + booked);
    }
    
    /*
    public boolean read(String s){
        return false;
    }
    

    public Object write(){
        return null;
    }
    */
}