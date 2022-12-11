package com.satyaAnandaSulistioJSleepJS;
import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.*;

public class Room extends Serializable
{
    // instance variables - replace the example below with your own
    public int size;
    public int accountId;
    public String name;
    public ArrayList<Facility> facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<Date>();

    /**
     * Constructor for objects of Room class
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
    
    public String toString(){
        return ("Size: " + size + " Name: " + name + " Facility: " + facility + " Price: " + price + " Address: " + address + " Bed Type: " + bedType + " City: " + city + " id: " + id + " booked: " + booked);
    }
    

    public boolean read(String s){
        return false;
    }
    

    public Object write(){
        return null;
    }
}