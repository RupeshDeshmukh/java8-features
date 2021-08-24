package com.rupeshdeshmukh.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Example to demonstrate the Stream API added in Java 8
 * <p>
 * A new java.util.stream package has been added in Java 8 to perform filter/map/reduce like
 * operations with the collection. Stream API will allow sequential as well as parallel execution.
 * <p>
 * Collection interface has been extended with stream() and parallelStream() default methods to
 * get the Stream for sequential and parallel execution.
 *
 * Stream API provides 2 kinds of operations:
 * => Intermediate Operation:
 *   - Operations which transforms a stream into another stream.
 *   - filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip()
 * => Terminal Operation
 *   - Operations which ends stream processing to return an output.
 *   - forEach(), reduce(), collect(), min(), max(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
 */
public class Java8FeatureStreamAPIExample {

    // Static list of numbers.
    public static final List<Integer> NUMBERS = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

    // Static list of names.
    public static final List<String> NAMES = Arrays.asList("rupesh", "sayali", "riyan", "rupesh");

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Example to demonstrate intermediate operation filter() and terminal operation collect() from Stream API.
        final List<Integer> lessThan50 = NUMBERS.stream() // Create a stream from collection.
                .filter(n -> n <= 50) // Apply intermediate operation to get new transformed stream.
                .collect(Collectors.toList()); // Print the elements from new stream.
        lessThan50.forEach(System.out::println);

        // Example to demonstrate intermediate operations distinct(), map() and sorted() from Stream API.
        NAMES.stream() // Create a stream from collection
                .distinct() // Intermediate operation to get distinct elements.
                .map(Java8FeatureStreamAPIExample::capitalize)  // Apply intermediate operation to get new transformed stream.
                .sorted() // Another intermediate operation to sort the capitalized elements.
                .forEach(System.out::println); // Print the elements from new stream.

        // Example to demonstrate terminal operation reduce() from Stream API.
        final Optional<String> combinedString = NAMES.stream()
                .distinct()
                .map(Java8FeatureStreamAPIExample::capitalize)
                .sorted()
                .reduce((s1, s2) -> s1 + " " + s2);
        combinedString.ifPresent(System.out::println);

        int sum = NUMBERS.stream()
                .limit(5) // Consider only first 5 elements from the stream.
                .reduce(0, Integer::sum);
        System.out.println("Sum is: " + sum);
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
