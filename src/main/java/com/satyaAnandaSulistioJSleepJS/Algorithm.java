package com.satyaAnandaSulistioJSleepJS;

import java.util.*;

/**
 * This class is used mainly for specific Algorithms, mostly to finding whether an object exist
 * based on criteria from the parameter. This class takes advantage of Iterable, generic, Predicate.
 *
 * @author NetLab FTUI
 * @author Satya Ananda Sulistio
 * @version 1.0
 */
public class Algorithm {
    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Check whether a certain condition from the predicate is matched.
     *
     * It will return true if it does, otherwise false.
     * @param iterator iterates arrays containing generic
     * @param pred the given condition to be iterated
     * @return true if the object exists, otherwise false
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)){
                return true;
            }
        }
        return false;
    }

    public static <T> int count(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> int count(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Check whether a certain condition from the predicate is matched.
     * It uses a local variable counter to count the items iterated.
     *
     * @param iterator iterates arrays containing generic
     * @param pred the given condition to be iterated
     * @return final counter value
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int counter = 0;
        while(iterator.hasNext()){
            T tester = iterator.next();
            if(pred.predicate(tester)){
                ++counter;
            }
        }
        return counter;
    }

    public static <T> T find(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    /**
     * Check whether a certain object is found in an array stream.
     * The criteria are based on the predicate.
     * It will return the searched object.
     *
     * @param iterator iterates arrays containing generic
     * @param pred the given condition to be iterated
     * @return the object with predicate met
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)){
                return current;
            }
        }
        return null;
    }

    public static <T> List<T> collect(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    /**
     * Check whether a certain object meet the predicate and add it to a List.
     *
     * @param iterator iterates arrays containing generic
     * @param pred the given condition to be iterated
     * @return the list containing collected objects.
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        List<T> returningCol = new ArrayList<T>();
        while(iterator.hasNext()){
            T toBeAdded = iterator.next();
            if(pred.predicate(toBeAdded)){
                returningCol.add(toBeAdded);
            }
        }
        return returningCol;
    }

    // New
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * This method is used to do pagination based on the page number and the size of the page.
     * The page number declares the number currently page is in.
     * The page size declares how many objects are to be returned inclusive to the page number.
     *
     * @param iterator iterates arrays containing generic
     * @param page initializes the page number
     * @param pageSize initializes the page size (how many objects in a page number)
     * @param pred the given condition to be iterated
     * @return list containing the objects to be shown in a page
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        List<T> showList = new ArrayList<T>();
        int numberBuffer = pageSize * (page+1);
        int pageCounter = pageSize * page;
        int index = 0;

        while(iterator.hasNext() && numberBuffer > 0){
            T current = iterator.next();
            if(index++ < pageCounter) continue;
            if(pred.predicate(current)){
                showList.add(current);
                numberBuffer--;
            }
        }
        return showList;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

}