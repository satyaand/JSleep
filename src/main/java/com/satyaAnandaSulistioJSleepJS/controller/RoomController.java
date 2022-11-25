package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.*;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Predicate<Account> predSearchId = obj -> obj.id == accountId;
        Account findAcc = Algorithm.find((new AccountController()).getJsonTable(), predSearchId);
        if(findAcc.renter != null){
            Room aRoom = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(aRoom);
        }
        return null;
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, Objects::nonNull);
    }

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }
}
