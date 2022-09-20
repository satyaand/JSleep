package satyaAnandaSulistioJSleepJS;

public class Rating
{
    // instance variables - replace the example below with your own
    private long total;
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
    
    public void insert(int rating){
        total += rating;
        ++count;
    }
    
    public double getAverage(){
        if(count != 0){
            return total / count;
        } else {
            return 0;
        }
    }
    
    public long getTotal(){
        return total;
    }
    
    public long getCount(){
        return count;
    }
}
