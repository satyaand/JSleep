package satyaAnandaSulistioJSleepJS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

// Satya Ananda Sulistio 2106705524

public class JSleep
{
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main (String[] args){
        String filepath = "C:\\Users\\Asus\\Documents\\Universitas Indonesia\\Teknik Komputer\\Semester 3\\Praktikum OOP 02 (JS)\\Modul 6 Files and Processing, Regex, Exception and Threading\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states :");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    /*
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
    */
}