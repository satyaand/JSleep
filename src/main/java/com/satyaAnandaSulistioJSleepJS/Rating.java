package com.satyaAnandaSulistioJSleepJS;

/**
 * This class is used for room rating system.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Rating
{
    /**
     * This field is used to store the total of ratings given by users.
     *
     * @since 1.0
     */
    private long total;

    /**
     * This field is used to count the amount of users' ratings.
     *
     * @since 1.0
     */
    private long count;

    /**
     * Constructor for objects of class Rating
     */
    public Rating()
    {
        // initialise instance variables
        total = 0;
        count = 0;
    }

    /**
     * This method is used to add a new rating to the previous amount.
     * While the rating total is added by parameter rating, the count increases.
     *
     * @param rating an inserted rating value
     */
    public void insert(int rating){
        total += rating;
        ++count;
    }

    /**
     * This method calculates the average rating given by users.
     *
     * @return the average rating if there are ratings, otherwise 0
     */
    public double getAverage(){
        if(count != 0){
            return total / count;
        } else {
            return 0;
        }
    }

    /**
     * This is a getter method since total is private.
     *
     * @return total value
     */
    public long getTotal(){
        return total;
    }

    /**
     * This is a getter method since count is private.
     *
     * @return count value
     */
    public long getCount(){
        return count;
    }

    /**
     * This method returns total and count in String.
     *
     * @return total and count in String
     */
    public String toString(){
        return("Total: " + total + " Count: " + count);
    }
}
