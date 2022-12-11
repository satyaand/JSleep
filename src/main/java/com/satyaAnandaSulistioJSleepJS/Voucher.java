package com.satyaAnandaSulistioJSleepJS;

import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

/**
 * This class is used to store voucher attributes.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Voucher extends Serializable
{
    /**
     * This field is a Type type object. It stores the type of price cut.
     *
     * @since 1.0
     */
    public Type type;

    /**
     * This field is used to store the cut amount.
     *
     * @since 1.0
     */
    public double cut;

    /**
     * This field is used to store Voucher's name.
     *
     * @since 1.0
     */
    public String name;

    /**
     * This field is used to store the Voucher's code.
     *
     * @since 1.0
     */
    public int code;

    /**
     * This field is used to store a minimum amount to validate whether the account is eligible.
     *
     * @since 1.0
     */
    public double minimum;

    /**
     * This field is used to validate whether the Voucher has been used or not.
     *
     * @since 1.0
     */
    private boolean used;

    /**
     * Constructor for objects of class Voucher
     *
     * @param name initializes voucher name
     * @param code initializes voucher code
     * @param type initializes the cut type
     * @param used initializes the voucher status
     * @param minimum initializes the minimum balance to use voucher
     * @param cut initializes the cut amount
     */
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = used;
    }

    /**
     * This method checks whether the voucher has been used or not.
     * @return {@code true} if the voucher has been used, {@code false} otherwise
     */
    public boolean isUsed(){
        return used;
    }

    /**
     * This method checks whether the given price amount is sufficient to apply for the voucher.
     * Voucher can be used simultaneously if the voucher hasn't been used also.
     *
     * @param price the price amount to be checked
     * @return {@code true} if the owner of the balance can apply, {@code false} otherwise
     */
    public boolean canApply(Price price){
        if((price.price > minimum) & !used){
            return true;
        }
        return false;
    }

    /**
     * This method is used to apply the voucher.
     *
     * @param price the price checked
     * @return the price after voucher usage
     */
    public double apply(Price price){
        used = true;
        if(type == Type.REBATE){
            if(cut > price.price){
                cut = price.price;
            }
        } else if(type == Type.DISCOUNT){
            if(cut >= 100.0f){
                cut = 100.0f;
            }
            cut = (cut / 100.0) * price.price;
        }
        return price.price - cut;
    }

    public boolean read(String s){
        return false;
    }

    public Object write(){
        return null;
    }
}
