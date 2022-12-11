package com.satyaAnandaSulistioJSleepJS;

/**
 * This is an unused class for the program overall. It's an object used to manage threads.
 * Usually used for multi-threading.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class ThreadingObject extends Thread {
    /**
     * Constructor for the thread object. This constructor also executes the thread.
     *
     * @param name initializes the thread's name
     */
    public ThreadingObject(String name){
        super(name);
        start();
    }

    /**
     * This method override the run method for the thread which is used to order the thread to do an event.
     */
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}
