package satyaAnandaSulistioJSleepJS;


import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author Satya Ananda Sulistio
 * @version (a version number or a date)
 */
public class Serializable
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**
     * Constructor for objects of class Serializable
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

    public static <T> Integer setClosingId(Class <T> tClass, int id){
        return mapCounter.put(tClass, id);
    }

    public static <T> Integer getClosingId(Class<T> tClass){
        return mapCounter.get(tClass);
    }

    public int compareTo(Serializable serial){
        return Integer.compare(this.id, serial.id);
    }

    public boolean equals(Object obj){
        Serializable temp = (Serializable) obj;
        return (obj instanceof Serializable) && (this.id == temp.id);
    }

    public boolean equals(Serializable serial){
        return (this.id == serial.id);
    }
}
