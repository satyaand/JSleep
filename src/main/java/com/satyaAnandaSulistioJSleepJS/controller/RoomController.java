package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.*;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
    @JsonAutowired(value = Room.class, filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    )
    {
        Predicate<Room> pred = obj -> obj.accountId == id;
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
    ){
        Predicate<Account> predSearchId = obj -> obj.id == accountId;
        Account findAcc = Algorithm.find((new AccountController()).getJsonTable(), predSearchId);
        if(findAcc.renter != null){
            Room aRoom = new Room(accountId, name, size, new Price(price), facility, city, address);
            roomTable.add(aRoom);
        }
        return null;
    }

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }
}
