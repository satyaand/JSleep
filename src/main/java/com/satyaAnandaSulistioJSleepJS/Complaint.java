package com.satyaAnandaSulistioJSleepJS;


import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

/**
 * This class is an object for complaints reported by guests.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Complaint extends Serializable
{
    /**
     * This String type field is used to store the description of the complaint.
     *
     * @since 1.0
     */
    public String desc;

    /**
     * This String type field is used to store the date of the complaint.
     *
     * @since 1.0
     */
    public String date;

    /**
     * Constructor for objects of class Complaint
     *
     * @param date initializes the date of complaint
     * @param desc initializes the description of complaint
     */
    public Complaint(String date, String desc)
    {
        // initialise instance variables
        this.date = date;
        this.desc = desc;
    }

    /**
     * Overrides default toString method with the format description and description consecutively.
     *
     * @return    Fields date and desc in String
     */
    public String toString()
    {
        // put your code here
        return ("Date: " + date + " Desc: " + desc);
    }
}
