package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.*;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(
        @RequestParam int buyerId,
        @RequestParam int renterId,
        @RequestParam int roomId,
        @RequestParam String from,
        @RequestParam String to
    ) throws ParseException {
        Predicate<Account> accPred = obj -> obj.id == buyerId;
        Account searchAccCriteria = Algorithm.<Account>find(AccountController.accountTable, accPred);
        Predicate<Room> roomPred = obj1 -> obj1.id == roomId;
        Room searchRoomCriteria = Algorithm.<Room>find(RoomController.roomTable, roomPred);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        boolean balanceMet = (searchAccCriteria.balance >= searchRoomCriteria.price.price);
        if(balanceMet && Payment.availability(fromDate, toDate, searchRoomCriteria)){
            Payment aPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            searchAccCriteria.balance -= searchRoomCriteria.price.price;
            aPayment.status = Invoice.PaymentStatus.WAITING;
            if(Payment.makeBooking(fromDate, toDate, searchRoomCriteria)){
                getJsonTable().add(aPayment);
                return aPayment;
            }
        }
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id){
        Predicate<Payment> pred = obj -> obj.id == id;
        Payment searchPayment = Algorithm.find(getJsonTable(), pred);
        if(searchPayment != null && searchPayment.status == Invoice.PaymentStatus.WAITING){
            searchPayment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id){
        Predicate<Payment> pred = obj -> obj.id == id;
        Payment searchPayment = Algorithm.find(getJsonTable(), pred);
        if(searchPayment.status == Invoice.PaymentStatus.WAITING){
            Predicate<Account> predAcc = objAcc -> objAcc.id == searchPayment.buyerId;
            Account foundAccount = Algorithm.find((new AccountController()).getJsonTable(), predAcc);
            Predicate<Room> predRoom = objRoom -> objRoom.id == searchPayment.getRoomId();
            Room foundRoom = Algorithm.find((new RoomController()).getJsonTable(), predRoom);
            searchPayment.status = Invoice.PaymentStatus.FAILED;
            foundAccount.balance += foundRoom.price.price;
            return true;
        }
        return false;
    }

    /*
    @PostMapping("/{id}/submit")
    public boolean submit(@PathVariable int id){
        return false;
    }
    */
}
