package com.satyaAnandaSulistioJSleepJS;
import java.util.*;
import java.io.*;


/**
 * This method is used to validate a filtered price list whether they're under a filtered value or not.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Validate
{
    /**
     * This field is used to store a certain value of x.
     *
     * @since 1.0
     */
    private int x;

    /**
     * Constructor for objects of class Validate.
     */
    public Validate()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Adding valid prices to a new array list.
     *
     * @param  list  an array of Price type containing list of prices
     * @param value an integer to check whether the given price is valid
     * @param less a boolean variable to check whether given price in a list is less than the value
     * @return an array list containing validated prices
     */
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList arrTemp = new ArrayList();
        for(Price run : list){
            if(run.price <= value && less){
                arrTemp.add(run.price);
            } else if(run.price > value && !less){
                arrTemp.add(run.price);
            }
        }
        return arrTemp;
    }
}
