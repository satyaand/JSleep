package com.satyaAnandaSulistioJSleepJS;

/**
 * An interface used to accommodate the method predicate.
 *
 * @author NetLab FTUI
 * @version 1.0
 */
public interface Predicate<T> {
    /**
     * Evaluates a predicate from the given argument
     *
     * @param t argument input
     * @return {@code true} if the input argument is equal to the predicate,
     * otherwise {@code false}
     */
    boolean predicate(T t);
}
