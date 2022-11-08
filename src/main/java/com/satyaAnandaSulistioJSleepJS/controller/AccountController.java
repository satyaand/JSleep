package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.Account;
import com.satyaAnandaSulistioJSleepJS.Algorithm;
import com.satyaAnandaSulistioJSleepJS.Predicate;
import com.satyaAnandaSulistioJSleepJS.Renter;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonAutowired;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Pattern;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;

    final public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z]*[.]{1}[a-zA-Z]*$");
    final public static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile("^(?!.*\\s)(?!.*[@#$%^&-+=!_])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");

    @GetMapping("/account")
    String index() { return "account page"; }

    @PostMapping("/login")
    Account login (
        @RequestParam String email,
        @RequestParam String password
    )
    {
        for(Account run : getJsonTable()){
            if(run.email.equals(email) && run.password.equals(password)){
                return run;
            }
        }
        return null;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    )
    {
        Account newUser = new Account(name, email, password);
        accountTable.add(newUser);
        if(!name.isBlank() && REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()){
            return newUser;
        } else {
            return null;
        }
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    )
    {
        Predicate<Account> pred = obj -> obj.id == id;
        Account findAcc = Algorithm.find(getJsonTable(), pred);
        if(findAcc.renter == null){
            Renter newRenter = new Renter(username, phoneNumber, address);
            findAcc.renter = newRenter;
            return newRenter;
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        Predicate<Account> pred = obj -> obj.id == id;
        Account searchAccount = Algorithm.find(getJsonTable(), pred);
        if(searchAccount != null){
            searchAccount.balance += balance;
            return true;
        }
        return false;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}
