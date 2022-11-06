package com.satyaAnandaSulistioJSleepJS;

/**
 * @author Satya Ananda Sulistio
 * @version 22 Sep 2022
 */

public class Voucher extends Serializable
{
    // instance variables - replace the example below with your own
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /**
     * Constructor for objects of class Voucher
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

    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(Price price){
        if((price.price > minimum) & !used){
            return true;
        }
        return false;
    }
    
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
