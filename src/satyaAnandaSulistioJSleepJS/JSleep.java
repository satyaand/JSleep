package satyaAnandaSulistioJSleepJS;
import java.sql.Date;

// Satya Ananda Sulistio 2106705524

public class JSleep
{   
    
    public static Room createRoom(){
       Price price = new Price(1000, 100);
       Room room = new Room(12, "hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda");
       return room;
    }
   
    public static void main (String[] args)
    {
        //System.out.println("Hello from Intellij");
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println(RoomA.booked);
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println(RoomA.booked);
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        System.out.println(RoomB.booked);
        /*
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        Date start = Date.valueOf("2022-8-20");
        Date end = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start, end, RoomA));
        */
    }
}