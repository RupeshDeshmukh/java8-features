package com.rupeshdeshmukh.java8.features;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Example to demonstrate feature Method Reference added in java 8.
 * <p>
 * Method reference is a shorthand notation of a lambda expression to call a method.
 * <p>
 * There are 4 types of method references possible:
 * <ol>
 *     <li>Method reference to an instance method of an object – object::instanceMethod</li>
 *     <li>Method reference to a static method of a class – Class::staticMethod</li>
 *     <li>Method reference to an instance method of an arbitrary object of a particular type – Class::instanceMethod</li>
 *     <li>Method reference to a constructor – Class::new</li>
 * </ol>
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureMethodReferenceExample {

    public static final String[] NAMES = {"Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Method reference to an instance method of an object.
        final Java8FeatureMethodReferenceExample obj1 = new Java8FeatureMethodReferenceExample();
        final MyInterface ref = obj1::myMethod; // Method reference using the object of the class
        ref.display(); // Calling the method of functional interface

        // Method reference to a static method of a class
        final BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;
        final int pr = product.apply(11, 5);
        System.out.println("Product of given number is: " + pr);

        // Method reference to an instance method of an arbitrary object of a particular type.
        Arrays.sort(NAMES, String::compareToIgnoreCase);
        for (String str : NAMES) {
            System.out.println(str);
        }
    }

    public void myMethod() {
        System.out.println("Instance Method");
    }
}

@FunctionalInterface
interface MyInterface {
    void display();
}

class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}
