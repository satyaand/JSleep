package satyaAnandaSulistioJSleepJS;
import java.sql.Date;
import java.util.ArrayList;

// Satya Ananda Sulistio 2106705524

public class JSleep
{   
    
    public static Room createRoom(){
       Price price = new Price(100000, 0.5);
       Room room = new Room("hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
       return room;
    }
   
    public static void main (String[] args)
    {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();

        for(int i = 0; i < 5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }
}