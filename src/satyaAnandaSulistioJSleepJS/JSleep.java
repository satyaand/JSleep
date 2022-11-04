package satyaAnandaSulistioJSleepJS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

// Satya Ananda Sulistio 2106705524

public class JSleep
{
    /*
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    */
    public static Room createRoom(){
        Price price = new Price(100000, 0.5);
        Room room = new Room(1, "hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        Predicate<Room> pred = oneRoom -> oneRoom.city == City.valueOf(search.toUpperCase());
        return Algorithm.paginate(list, page, pageSize, pred);
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        Predicate<Room> pred = oneRoom -> (oneRoom.price.price >= minPrice) && (oneRoom.price.price <= maxPrice);
        return Algorithm.collect(list, pred);
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        Predicate<Room> pred = oneRoom -> oneRoom.accountId == accountId;
        return Algorithm.paginate(list, page, pageSize, pred);
    }
    public static void main (String[] args){
        try {
            String filepath = "src\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            JsonTable.writeJson(tableAccount, filepath);

            Reader reader = Files.newBufferedReader(Paths.get(filepath));
            List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {}.getType());
            accounts.forEach(System.out::println);
            reader.close();
            /*
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoomByCity = filterByCity(tableRoom, "jakarta", 0, 5);
            filterTableRoomByCity.forEach(room -> System.out.println(room.toString()));
            System.out.println("NEXT");
            List<Room> filterTableRoomByAccountId = filterByAccountId(tableRoom, 11, 0, 5);
            filterTableRoomByAccountId.forEach(room -> System.out.println(room.toString()));
            System.out.println("NEXT");
            List<Room> filterTableRoomByPrice = filterByPrice(tableRoom, 100000, 250000);
            filterTableRoomByPrice.forEach(room -> System.out.println(room.toString()));
             */
        } catch (Throwable t){
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }

        /*
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl. Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
        /*
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
        */
    }
}