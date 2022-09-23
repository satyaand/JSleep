package satyaAnandaSulistioJSleepJS;

/**
 * @author Satya Ananda Sulistio
 * @version 22 Sep 2022
 */

public class Voucher
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
    public Voucher(String name, int code, Type type, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
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
    
    /* TEST RUNNING CASES
    public static Voucher createVoucher(){
       Type type = Type.DISCOUNT;
       Voucher voucher = new Voucher("Hotel", 101, type, 800, 0.0);
       return voucher;
    }
    
    public static void main(String[] args){
        // Initialize objek tipe Price dan Voucher
        Price price = new Price(850, 10);
        Voucher test = createVoucher();
        
        System.out.println(test.type);
        System.out.println(test.name);
        System.out.println(test.code);
        System.out.println(test.minimum);
        // Cut awal
        System.out.println(test.cut);
        // Apakah sudah terpakai?
        System.out.println(test.isUsed());
        // Apakah bisa apply?
        System.out.println(test.canApply(price));
        System.out.println(test.apply(price));
        // Test status terpakai setelah apply
        System.out.println(test.isUsed());
        // Cek cut setelah terpotong
        System.out.println(test.cut);
        // Test eligible untuk apply lagi atau tidak
        System.out.println(test.canApply(price));
    }
    */
}
