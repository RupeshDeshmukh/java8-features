package com.rupeshdeshmukh.java8.features;

import java.util.Arrays;
import java.util.List;

/**
 * Example to demonstrate the forEach() method added in Java 8.
 * <p>
 * Java 8 has introduced a “forEach” method in the interface java.lang.Iterable
 * that can iterate over the elements in the collection. “forEach” is a default
 * method defined in the Iterable interface. It is used by the Collection classes
 * that extend the Iterable interface to iterate elements.
 * <p>
 * The “forEach” method takes the Functional Interface as a single parameter i.e.
 * you can pass Lambda Expression as an argument.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureForEachExample {

    // Static list of names.
    public static final List<String> NAMES = Arrays.asList("rupesh", "sayali", "riyan");

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(final String[] args) {
        // Here forEach method will iterate over the names list and capitalize the first
        // letter of each name and print it on the console.
        NAMES.forEach(name -> System.out.println(capitalize(name)));
    }

    /**
     * Method to capitalize the first letter of the given string.
     * E.g. input string rupesh will be converted to Rupesh
     *
     * @param str String.
     * @return String.
     */
    public static String capitalize(final String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
