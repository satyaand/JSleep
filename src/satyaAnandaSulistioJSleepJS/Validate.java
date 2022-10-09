package satyaAnandaSulistioJSleepJS;
import java.util.*;
import java.io.*;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
