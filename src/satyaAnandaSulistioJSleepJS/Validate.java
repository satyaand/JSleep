package satyaAnandaSulistioJSleepJS;
import java.util.*;
import java.io.*;


/**
 * Write a description of class Validate here.
 *
 * @author Satya Ananda Sulistio
 * @version (a version number or a date)
 */
public class Validate
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Validate
     */
    public Validate()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Adding valid prices to a new array list.
     *
     * @param  list  An array of Price type containing list of prices
     * @param value An integer to check whether the given price is valid
     * @param less A boolean variable to check whether given price in a list is less than the value
     * @return    An array list containing validated prices
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
