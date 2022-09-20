package satyaAnandaSulistioJSleepJS;

// Satya Ananda Sulistio 2106705524

public class Price
{
    // instance variables
    public double price;
    public int discount;
    public double rebate;
    
    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

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
            return price - (int)(((double)discount / 100.0f) * price);
        }
    }

    private double getRebatedPrice(){
        if(rebate > price){
            return price;
        } else {
            return price - rebate;
        }
    }
}