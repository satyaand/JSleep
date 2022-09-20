package satyaAnandaSulistioJSleepJS;

// Satya Ananda Sulistio 2106705524

public class JSleep
{   
    /*
    public static int getHotelId()
    {
        return 0;
    }
    
    public static String getHotelName()
    {
        return "hotel";
    }
    
    public static boolean isDiscount()
    {
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount)
    {
        float percentage = 0.0f;
        if(beforeDiscount > afterDiscount)
        {
            float delta = beforeDiscount - afterDiscount;
            percentage = (delta / beforeDiscount) * 100.0f;
        }
        return percentage;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        int discPrice = 0;  // Harga setelah didiskon
        if(discountPercentage > 100.0f)
        {
            discPrice = 0;
        }
        else 
        {
            discPrice = price - (int)((discountPercentage / 100.0f) * price);
        }
        return discPrice;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float originPrice = discountedPrice / ((100.0f-discountPercentage) / 100.0f);
        return (int) originPrice;
    }
    
    public static float getAdminFeePercentage()
    {
        return 0.05f;
    }
    
    public static int getAdminFee(int price)
    {
        float adminFee = price * getAdminFeePercentage();
        return (int) adminFee;
    }
    
    public static int getTotalPrice(int price, int numberOfNight)
    {
        return (price * numberOfNight) + (getAdminFee(price * numberOfNight));
    }
    
    */
   
   public static Room createRoom(){
       Price price = new Price(1000, 100);
       Room room = new Room("hotel", 30, price, Facility.AC);
       return room;
   }
   
    public static void main (String[] args)
    {
        /*
        System.out.printf("Hotel ID: %d\n", getHotelId());
        System.out.printf("Hotel Name: %s\n", getHotelName());
        System.out.println("Discount? " + isDiscount());
        System.out.printf("Discount Percentage: %.1f\n", getDiscountPercentage(1000,900));
        System.out.printf("Discount Price: %d\n", getDiscountedPrice(1000, 10.0f));
        System.out.printf("Original Price: %d\n", getOriginalPrice(900,10.0f));
        System.out.printf("Admin Fee: %d\n", getAdminFee(1000));
        System.out.printf("Total Price: %d\n", getTotalPrice(10000,2));
        */
       // Membuat objek test untuk class Room
       Room test = createRoom();
       System.out.println(test.name);
       System.out.println(test.size);
       System.out.println(test.price.price);
       System.out.println(test.facility);
    }
}