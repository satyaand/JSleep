package satyaAnandaSulistioJSleepJS;

public class Room extends Serializable
{
    // instance variables - replace the example below with your own
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;

    /**
     * Constructor for objects of class Room
     */
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
    {
        // initialise instance variables
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }
    
    public String toString(){
        return ("Size: " + size + " Name: " + name + " Facility: " + facility + " Price: " + price + " Address: " + address + " Bed Type: " + bedType + " City: " + city);
    }
}