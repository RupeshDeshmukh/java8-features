package com.rupeshdeshmukh.java8.features;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Example to demonstrate the default methods added in Java 8.
 * <p>
 * In Java 8, you can add methods in the interface that are not abstract i.e. you can have interfaces
 * with method implementation. You can use the Default and Static keyword to create interfaces with
 * method implementation. Default methods mainly enable Lambda Expression functionality.
 * <p>
 * Using default methods you can add new functionality to your interfaces in your libraries.
 * This will ensure that the code written for the older versions is compatible with those
 * interfaces (binary compatibility).
 *
 * Default methods are accessible through the instance of the implementing class and can be overridden.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureDefaultMethodsExample {

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(final String[] args) {
        final InternalUser iu = new InternalUser("Rupesh", "Deshmukh", LocalDate.of(1984, Month.APRIL, 29));
        final ExternalUser eu = new ExternalUser("Sayali", "Deshmukh", LocalDate.of(1985, Month.SEPTEMBER, 24));
        System.out.println(iu.getUserDetailsForDisplay());
        System.out.println(eu.getUserDetailsForDisplay());
    }
}

/**
 * Interface with default (non-abstract) method and abstract method.
 * <p>
 * NOTE:
 * calculateAge() is a default method with implementation.
 * getUserType() is abstract method which needs to be implemented by class implementing the interface.
 */
interface User {

    /**
     * Default method to calculate the age of the user based on the given date of birth.
     *
     * @param dateOfBirth java.time.LocalDate.
     * @return int.
     */
    default String calculateAge(final LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            final LocalDate currentDate = LocalDate.now();
            final Period age = Period.between(dateOfBirth, currentDate);
            return age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days";
        } else {
            return "";
        }
    }

    /**
     * Abstract method to be implemented by the implementing class.
     * <p>
     * Method should return the user type.
     *
     * @return String.
     */
    String getUserType();
}

/**
 * Abstract class implementing User interface.
 * <p>
 * NOTE:
 * Abstract class provides implementation for displayUserDetails() method which is inherited by its sub-classes.
 */
abstract class AbstractUser implements User {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public AbstractUser(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Method to create displayable user details string with calculated age.
     *
     * @return String
     */
    public String getUserDetailsForDisplay() {
        return String.format("%s %s is an %s user and user's age is %s", this.getFirstName(), this.getLastName(),
                this.getUserType(), this.calculateAge(this.getDateOfBirth()));
    }
}

/**
 * Class to denote internal users providing implementation for getUserType() method.
 */
class InternalUser extends AbstractUser {
    public InternalUser(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserType() {
        return "Internal";
    }
}

/**
 * Class to denote external users providing implementation for getUserType() method.
 */
class ExternalUser extends AbstractUser {
    public ExternalUser(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserType() {
        return "External";
    }
}
