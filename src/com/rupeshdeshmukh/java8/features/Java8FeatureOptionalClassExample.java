package com.rupeshdeshmukh.java8.features;

import java.util.Optional;

/**
 * Example to demonstrate the Optional class added in Java 8.
 * <p>
 * Java 8 introduced an optional class in the “java.util” package.
 * “Optional” is a public final class and is used to deal with NullPointerException
 * in the Java application. Using Optional, you can specify alternate code or values to run.
 * By using Optional you don’t have to use too many null checks to avoid nullPointerException.
 * <p>
 * The Optional class provides various utility methods for checking and managing its present value:
 * <ul>
 *     <li>of() - Method to create Optional wrapper for non-null values</li>
 *     <li>ofNullable() - Method to create Optional wrapper for values that can be null</li>
 *     <li>isPresent() - Method to check is value is present for the given Optional instance</li>
 *     <li>ifPresent() - Method which takes functional interface as input and is executed only when option value is not null</li>
 *     <li>orElse() - Method to get value if present else return default value</li>
 *     <li>orElseGet() - Method to get value if present else return default value</li>
 *     <li>map() - Method to apply mapping function if value is not null else return empty option</li>
 *     <li>flatMap() - Method to apply mapping function to non-null value</li>
 * </ul>
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureOptionalClassExample {

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Example demonstrating ofNullable() and isPresent() methods.
        final String[] str = new String[10];
        final Optional<String> optionalString = Optional.ofNullable(str[5]);
        if (optionalString.isPresent()) {
            final String word = str[5].toLowerCase();
            System.out.println(word);
        } else {
            System.out.println("Null string at position 5");
        }

        // Example demonstrating of() and ifPresent() methods.
        final Optional<String> optionalMovie = Optional.of("Classic");
        optionalMovie.ifPresent(movie -> System.out.println(movie + " movie available"));

        // Example demonstrating orElse() and orElseGet() methods.
        final Optional<String> optionalSport = Optional.of("Air Badminton");
        final Optional<String> nothing = Optional.empty();
        System.out.println(optionalSport.orElse("Badminton"));
        System.out.println(nothing.orElse("Badminton"));
        System.out.println(optionalSport.orElseGet(() -> "Badminton"));
        System.out.println(nothing.orElseGet(() -> "Badminton"));
    }
}
