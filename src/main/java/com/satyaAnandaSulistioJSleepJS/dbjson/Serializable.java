package com.satyaAnandaSulistioJSleepJS.dbjson;


import java.util.HashMap;

/**
 * The class generates a serial number that increments automatically for new objects.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Serializable implements Comparable<Serializable>
{
    /**
     * This field is the serial number that is given to an object when created. The process is automatic.
     *
     * @since 1.0
     */
    public final int id;

    /**
     * A hash map to save the serial numbers.
     *
     * @since 1.0
     */
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**
     * Constructor for objects of class Serializable.
     * The automated increment for new objects is done within this constructor.
     */
    protected Serializable()
    {
        Integer serialTemp = mapCounter.get(getClass());
        if(serialTemp == null){
            serialTemp = 0;
        } else {
            serialTemp++;
        }
        mapCounter.put(getClass(), serialTemp);
        id = serialTemp;
    }

    /**
     * This method sets the closing ID.
     * @param tClass the object class
     * @param id the serial id
     * @return hash map value at certain ID with a given class
     */
    public static <T extends Serializable> Integer setClosingId(Class <T> tClass, int id){
        return mapCounter.put(tClass, id);
    }

    /**
     * This is the getter method.
     * @param tClass the class object requested
     * @return the class object requested
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> tClass){
        return mapCounter.get(tClass);
    }

    /**
     * This method compares two serials ID.
     * @param serial the Serializable object to be compared.
     * @return {@code 1} if both equal, {@code 0} otherwise.
     */
    public int compareTo(Serializable serial){
        return Integer.compare(this.id, serial.id);
    }

    /**
     * This method compares two objects and their Serializable attributes.
     *
     * @param obj the object to be compared
     * @return {@code true} if both equal, {@code false} otherwise
     */
    public boolean equals(Object obj){
        Serializable temp = (Serializable) obj;
        return (obj instanceof Serializable) && (this.id == temp.id);
    }

    /**
     * This method compares two Serializable objects.
     *
     * @param serial the Serializable object
     * @return {@code true} if they're the same, {@code false} otherwise
     */
    public boolean equals(Serializable serial){
        return (this.id == serial.id);
    }
}
