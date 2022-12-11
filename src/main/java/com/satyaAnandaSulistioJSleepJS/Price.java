package com.satyaAnandaSulistioJSleepJS;

/**
 * This class is utilized to store a room's price and its discount amount.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Price
{
    /**
     * This field stores a room's price.
     *
     * @since 1.0
     */
    public double price;

    /**
     * This field stores a room's discount amount.
     *
     * @since 1.0
     */
    public double discount;

    /**
     * Constructor for object Price.
     * The default discount value is set to 0.
     *
     * @param price initializes a room's price
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
        //this.rebate = 0;
    }

    /**
     * Alternative constructor for object Price.
     *
     * @param price initializes a room's price
     * @param discount initializes a room's discount
     */
    public Price(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }

    /**
     * This method returns the fields value in String.
     *
     * @return fields value in String
     */
    public String toString(){
        return("Price: " + price + " Discount: " + discount);
    }
    
    /*
    public Price(double price, int discount)
    {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    
    private double getDiscountedPrice(){
        if((double)discount >= 100.0f){
            return 0.0;
        } else {
            return price - (((double)discount / 100.0f) * price);
        }
    }

    private double getRebatedPrice(){
        if(rebate > price){
            return 0;
        } else {
            return price - rebate;
        }
    }
    */
}