package com.rupeshdeshmukh.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Example to demonstrate java.util.stream.Collectors class added in Java 8.
 * <p>
 * Collectors is a final class that extends the Object class.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureCollectorsClassExample {

    // Static list of names.
    public static final List<String> NAMES = Arrays.asList("rupesh", "sayali", "riyan", "rupesh", "riyan", "rupesh");

    // Static list of employees.
    public static final List<Employee> EMPLOYEES = Arrays.asList(new Employee(1, "Rupesh", "Deshmukh", 37),
            new Employee(2, "Sayali", "Deshmukh", 36),
            new Employee(3, "Santosh", "Deshmukh", 42),
            new Employee(4, "Kiran", "Deshmukh", 41));

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Example to demonstrate Collectors.groupingBy() method.
        final Map<String, Long> nameCountMap = NAMES.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Names count map: " + nameCountMap);

        // Example to demonstrate Collectors.averagingInt() method.
        final Double averageAge = EMPLOYEES.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("Average age of employee is: " + averageAge);
    }
}

class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    public Employee(Integer id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}