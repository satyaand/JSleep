package com.satyaAnandaSulistioJSleepJS;

import com.satyaAnandaSulistioJSleepJS.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the driver class that runs the entire JSleep program.
 * It utilizes SpringBoot / Spring framework to manage its' cycle.
 *
 * @author NetLab FTUI
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
@SpringBootApplication
public class JSleep
{
    /**
     * The main method where the program runs.
     *
     * @param args the main thread
     */
    public static void main (String[] args){
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}