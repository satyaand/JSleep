package satyaAnandaSulistioJSleepJS;
import java.util.*;

public class Room extends Serializable
{
    // instance variables - replace the example below with your own
    public int size;
    public int accountId;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;

    /**
     * Constructor for objects of Room class
     */
    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address)
    {
        // initialise instance variables
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
        booked = new ArrayList<Date>();
    }
    
    public String toString(){
        return ("Size: " + size + " Name: " + name + " Facility: " + facility + " Price: " + price + " Address: " + address + " Bed Type: " + bedType + " City: " + city + " id: " + id);
    }
    

    public boolean read(String s){
        return false;
    }
    

    public Object write(){
        return null;
    }
}