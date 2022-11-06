package com.satyaAnandaSulistioJSleepJS;

public interface Predicate<T> {
    /**
     * Evaluates a predicate from the given argument
     *
     * @param t argument input
     * @return {@code true} if the input argument is equal to the predicate
     * otherwise {@code false}
     */
    boolean predicate(T t);
}
