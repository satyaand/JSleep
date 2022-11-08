package com.satyaAnandaSulistioJSleepJS.controller;

import com.satyaAnandaSulistioJSleepJS.Algorithm;
import com.satyaAnandaSulistioJSleepJS.Predicate;
import com.satyaAnandaSulistioJSleepJS.dbjson.JsonTable;
import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface BasicGetController<T extends Serializable>{
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        Predicate<T> pred = obj -> true;
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred);
    }

    @GetMapping("page/{id}")
    public default T getById(@PathVariable int id) {
        Predicate<T> pred = obj -> obj.id == id;
        return Algorithm.find(getJsonTable(), pred);
    }
}
