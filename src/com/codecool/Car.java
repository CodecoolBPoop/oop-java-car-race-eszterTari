package com.codecool;

import java.util.Random;

public class Car extends Vehicle {

    int speedLimitWhenTruckBroken = 75;
    static private String[] names = {"Scorpion", "Expedition", "Desire", "Barrage", "Scout",
            "Orbit", "Instinct", "Dragon", "Might", "Capital", "Bullet", "Twister", "Basilisk", "Eminance", "Expedition",
            "Dynamics", "Revelation", "Blast", "Paradox", "Tarragon"};
        // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php
        // and pick 2 randomly for each instance.

    public Car() {
        Random rand = new Random();
        name = names[rand.nextInt(20)] + " " + names[rand.nextInt(20)];
        speed = rand.nextInt(31) + 80;
            // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    }

    public void moveForAnHour(Race race, boolean isThereABrokenTruck) {
        // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!

        if (isThereABrokenTruck) {
            distanceTraveled += speedLimitWhenTruckBroken;
            System.out.println(name + " travelled: 75 km in this hour because of a broken truck");
                // If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
        } else {
            distanceTraveled += speed;
            System.out.println(name + " travelled: "+ speed + " km");
        }
        System.out.println(name + "'s total distance travelled: " + distanceTraveled + " km");
        System.out.println(" ");
    }

}
