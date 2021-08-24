package com.rupeshdeshmukh.java8.features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

/**
 * Example to demonstrate new Date Time APIs added in Java 8.
 * <p>
 * Before java 8 date time have some problems like not thread-safe and immutable and does
 * not have setter methods and also have less operations.
 * <p>
 * In a Java 8 Date/time API fix these issues and introduce the new API under the package java.time.
 * <p>
 * Following are the new classes introduced:
 * The LocalDate class defines a date. It has no representation for time or time-zone.
 * The LocalTime class defines a time. It has no representation for date or time-zone.
 * The LocalDateTime class defines a date-time. It has no representation of a time-zone.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureDateTimeAPIExample {

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        // Get the current date
        final LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date is: " + currentDate);

        // Get the current time
        final LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time is: " + currentTime);

        // Get the current date and time
        final LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date & Time is: " + currentDateTime);

        // Get the current timestamp
        final Instant timestamp = Instant.now();
        System.out.println("Current Timestamp is: " + timestamp);

        // Get the current Zone
        final ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("Current Zone is: " + currentZone);

        // Get ZonedDateTime from specific Calendar
        final ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        System.out.println("Current Zoned Date Time is: " + gregorianCalendarDateTime);

        // Date formatting.
        final LocalDate date = LocalDate.now();
        System.out.println("Default format: " + date);
        System.out.println("Specific format: " + date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println("ISO format: " + date.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
