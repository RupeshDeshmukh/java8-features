package com.rupeshdeshmukh.java8.features;

import java.util.StringJoiner;

/**
 * Example to demonstrate java.util.StringJoiner class added in java 8.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureStringJoinerClassExample {

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Example with passing Hyphen(-) as delimiter
        final StringJoiner sj1 = new StringJoiner("-");
        sj1.add("Rupesh");
        sj1.add("Harishchandra");
        sj1.add("Deshmukh");
        System.out.println(sj1);

        // Example with passing comma(,) as delimiter and opening bracket "(" as prefix and closing bracket ")" as suffix.
        final StringJoiner sj2 = new StringJoiner(", ", "(", ")");
        sj2.add("Rupesh");
        sj2.add("Riyan");
        sj2.add("Sayali");
        System.out.println(sj2);
    }
}
