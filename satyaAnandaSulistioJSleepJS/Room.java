package satyaAnandaSulistioJSleepJS;

public class Room
{
    // instance variables - replace the example below with your own
    public int size;
    public String name;
    public Facility facility;
    public Price price;

    /**
     * Constructor for objects of class Room
     */
    public Room(String name, int size, Price price, Facility facility)
    {
        // initialise instance variables
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
}
