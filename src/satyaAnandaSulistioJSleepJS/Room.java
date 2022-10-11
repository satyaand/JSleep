package satyaAnandaSulistioJSleepJS;
import java.util.*;

public class Room extends Serializable implements FileParser
{
    // instance variables - replace the example below with your own
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;

    /**
     * Constructor for objects of class Room
     */
    public Room(String name, int size, Price price, Facility facility, City city, String address)
    {
        // initialise instance variables
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
    
    @Override
    public boolean read(String s){
        return false;
    }
    
    @Override
    public Object write(){
        return null;
    }
}