package com.satyaAnandaSulistioJSleepJS;

import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.regex.*;


/**
 * Write a description of class Renter here.
 *
 * @author Satya Ananda Sulistio
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public final static String REGEX_NAME = "^[A-Z]+[A-Za-z0-9_]{4,20}(?!\\s)$";
    public final static String REGEX_PHONE = "^\\d{9,12}$";
    public String phoneNumber;
    public String address;
    public String username;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(String username, String phoneNumber, String address)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public boolean validate(){
        Pattern pName = Pattern.compile(REGEX_NAME);
        Pattern pNumber = Pattern.compile(REGEX_PHONE);

        if(username == null || phoneNumber == null){
            return false;
        }

        Matcher mName = pName.matcher(username);
        Matcher mNumber = pNumber.matcher(phoneNumber);

        return (mName.matches() && mNumber.matches());
    }
}
