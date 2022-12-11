package com.satyaAnandaSulistioJSleepJS;

import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.regex.*;


/**
 * The class Renter is used to store room's renter credentials, including phone number, address, and username.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Renter extends Serializable
{
    /**
     * The field is used for REGEX pattern to validate the username.
     * The username must start with a capital letter, only alphabets, digits, and underscores are allowed,
     * at least 4 characters and 20 at most, no whitespace allowed.
     *
     * Ex: 5-21 characters is considered valid, while 4/22 is not.
     * @since 1.0
     */
    public final static String REGEX_NAME = "^[A-Z]+[A-Za-z0-9_]{4,20}(?!\\s)$";

    /**
     * The field is used for REGEX pattern to validate the phone number.
     * The phone number only has at least 9 digit and 12 at most. Importantly, only numbers are allowed.
     *
     * @since 1.0
     */
    public final static String REGEX_PHONE = "^\\d{9,12}$";

    /**
     * This field is used to store the renter's phone number. It may be validated using REGEX.
     *
     * @since 1.0
     */
    public String phoneNumber;

    /**
     * This field is used to store the renter's address.
     *
     * @since 1.0
     */
    public String address;

    /**
     * This field is used to store the renter's username. It may be validated with REGEX.
     *
     * @since 1.0
     */
    public String username;

    /**
     * Constructor for objects of class Renter
     *
     * @param username initializes username
     * @param phoneNumber initializes phoneNumber
     * @param address initializes address
     */
    public Renter(String username, String phoneNumber, String address)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method validates the username and phoneNumber criteria based on the REGEX patterns.
     *
     * @return {@code true} if both fields match their REGEX pattern respectively, {@code false} otherwise
     */
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
