package com.pluralsight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        // Add 2 Houses
        assets.add(new House("My Home", "2015-06-12", 250000,
                "123 Maple Street", 1, 2000, 5000));
        assets.add(new House("Vacation Home", "2020-08-25", 300000,
                "45 Beach Drive", 3, 1500, 3000));

        // Add 2 Vehicles
        assets.add(new Vehicle("Tom's Truck", "2019-04-10", 45000,
                "Ford ", 2018, 9000));
        assets.add(new Vehicle("Jenny's Car", "2021-03-20", 30000,
                "Honda", 2020, 12000));


        for (Asset a : assets) {
            System.out.println("------------------------------------------------");
            System.out.println("Description: " + a.getDescription());
            System.out.println("Date Acquired: " + a.getDateAcquired());
            System.out.printf("Original Cost: $%.5f%n", a.getOriginalCost());
            System.out.printf("Current Value: $%.5f%n", a.getValue());

            if (a instanceof House) {
                House house = (House) a;
                System.out.println("Type: House");
                System.out.println("Address: " + house.getAddress());
                System.out.println("Condition: " + house.getConditionText());
            } else if (a instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) a;
                System.out.println("Type: Vehicle");
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Odometer: " + vehicle.getOdometer() + " miles");
            }
        }

    }
}
