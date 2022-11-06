package com.satyaAnandaSulistioJSleepJS;


/**
 * Write a description of class Complaint here.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Complaint extends Serializable
{
    // instance variables - replace the example below with your own
    public String desc;
    public String date;

    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(String date, String desc)
    {
        // initialise instance variables
        this.date = date;
        this.desc = desc;
    }

    /**
     * Override default toString method with the following format
     *
     * @return    date and desc in String
     */
    public String toString()
    {
        // put your code here
        return ("Date: " + date + " Desc: " + desc);
    }
}
