package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.Algorithm;
import com.satyaAnandaSulistioJSleepJS.Predicate;
import com.satyaAnandaSulistioJSleepJS.Price;
import com.satyaAnandaSulistioJSleepJS.Voucher;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Predicate<Voucher> pred = obj -> obj.id == id;
        Voucher searchVoucher = Algorithm.find(getJsonTable(), pred);
        return searchVoucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Predicate<Voucher> pred = obj -> obj.id == id;
        Voucher searchVoucher = Algorithm.find(getJsonTable(), pred);
        return searchVoucher.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        Predicate<Voucher> usable = obj -> !obj.isUsed();
        int defPage = 0;
        int defPageSize = 5;
        if(defPage > page){
            page = defPage;
        }
        if(defPageSize > pageSize){
            pageSize = defPageSize;
        }
        return Algorithm.paginate(getJsonTable(), page, pageSize, usable);
    }

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }
}
