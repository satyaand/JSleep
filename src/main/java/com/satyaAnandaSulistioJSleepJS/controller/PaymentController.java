package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.Payment;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

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
    ){
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id){
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id){
        return false;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(@PathVariable int id){
        return false;
    }
}
