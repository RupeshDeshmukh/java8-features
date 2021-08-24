package com.rupeshdeshmukh.java8.features;

import java.util.function.IntBinaryOperator;

/**
 * Example to demonstrate the Functional Interfaces that was added in Java 8.
 * <p>
 * Java 8 introduces an annotation known as @FunctionalInterface that is usually for
 * compiler level errors. It is typically used when the interface you are using violates
 * the contracts of functional interface.
 * <p>
 * Alternatively, you can call a functional interface as SAM interface or
 * Single Abstract Method interface. A functional interface allows exactly
 * one “abstract method” as its member.
 * <p>
 * You can omit the annotation, @FunctionalInterface and your functional interface will still
 * be a valid one. We use this annotation only to inform the compiler that the interface will
 * have a single abstract method.
 * <p>
 * Note: By definition, default methods are Non-abstract and you can add as many default methods
 * in the functional interface as you like.
 * <p>
 * Secondly, if an interface has an abstract method that overrides one of the public methods of
 * “java.lang.object” then it is not considered as the interface’s abstract method.
 * <p>
 * FunctionalInterface annotation is a facility to avoid the accidental addition of abstract methods
 * in the functional interfaces. You can think of it like @Override annotation and it’s best practice
 * to use it. java.lang.Runnable with a single abstract method run() is a great example of a functional
 * interface.
 * <p>
 * One of the major benefits of the functional interface is the possibility to use lambda expressions
 * to instantiate them. We can instantiate an interface with an anonymous class but the code looks bulky.
 * Lambda Expressions implement the only abstract function present in the functional interface and thus
 * implement functional interfaces.
 * E.g.
 * (parameters) -> expression
 * or
 * (parameters) -> { statements; }
 * or
 * () -> expression
 */
public class Java8FeatureFunctionalInterfacesExample {
    public static void main(String[] args) {
        // Example of user defined functional interface,
        final Calculator multiplication = (a, b) -> a * b; // Lambada expression for multiplying 2 numbers
        final Calculator subtraction = (a, b) -> a - b; // Lambada expression for subtracting 2 numbers
        System.out.println("Multiplication result: " + multiplication.execute(10, 5));
        System.out.println("Subtraction results: " + subtraction.execute(10, 5));

        // Example of predefined functional interfaces provided by java.
        final IntBinaryOperator multiply = (a, b) -> a * b;
        final IntBinaryOperator subtract = (a, b) -> a - b;
        System.out.println("Multiplication result: " + multiply.applyAsInt(10, 5));
        System.out.println("Subtraction result: " + subtract.applyAsInt(10, 5));
    }
}

/**
 * Functional interface with single abstract method.
 */
@FunctionalInterface
interface Calculator {
    int execute(final int a, final int b);
}

