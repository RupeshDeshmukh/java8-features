package com.rupeshdeshmukh.java8.features;

/**
 * Example to demonstrate the static methods added in Java 8.
 * <p>
 * In Java 8, you can add methods in the interface that are not abstract i.e. you can have interfaces
 * with method implementation. You can use the Default and Static keyword to create interfaces with
 * method implementation.
 * The static method in an interface can be defined in the interface, but cannot be overridden in
 * Implementation Classes. To use a static method, Interface name should be instantiated with it,
 * as it is a part of the Interface only.
 *
 * @author Rupesh Deshmukh
 */
public class Java8FeatureStaticMethodsExample {

    /**
     * Entry point for the program.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        final CarService carService = new CarService();
        final BikeService bikeService = new BikeService();
        System.out.println(carService.getServicingCentreInfo());
        System.out.println(bikeService.getServicingCentreInfo());
    }
}

/**
 * Interface with example with all 3 types of method static, default and abstract method.
 */
interface VehicleService {
    /**
     * Non-abstract method but cannot be inherited.
     * <p>
     * Generic method applicable for all vehicle types.
     *
     * @return String
     */
    static String getGenericServicingInfo() {
        return "Facility is available between 9 AM to 6 PM for Mon to Fri and 9 AM to 4 PM for Sat & Sun";
    }

    /**
     * Non-abstract method.
     * <p>
     * Default method to get information for the service centre.
     *
     * @return String.
     */
    default String getServicingCentreInfo() {
        switch (getVehicleType()) {
            case "CAR": return "Address: ABC Car Service Centre, XYX Road, Pincode - 123456, Timings: " + getGenericServicingInfo();
            case "BIKE": return "Address: DEC Bike Service Centre, RST Road, Pincode - 987654, Timings: " + getGenericServicingInfo();
            default: return "Invalid vehicle type";
        }
    }

    /**
     * Abstract method.
     * <p>
     * Method to get the vehicle type.
     *
     * @return String.
     */
    String getVehicleType();
}

class CarService implements VehicleService {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

class BikeService implements VehicleService {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}
