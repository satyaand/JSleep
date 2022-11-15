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
        if(searchVoucher != null) return searchVoucher.isUsed();
        return false;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Predicate<Voucher> pred = obj -> obj.id == id;
        Voucher searchVoucher = Algorithm.find(getJsonTable(), pred);
        if(searchVoucher != null) return searchVoucher.canApply(new Price(price));
        return false;
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int pageSize
    ){
        return Algorithm.<Voucher>paginate(Algorithm.<Voucher>collect(voucherTable, obj -> !obj.isUsed()), page, pageSize, pred -> true);
    }

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }
}
