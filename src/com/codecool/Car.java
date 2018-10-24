package com.codecool;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Car extends Vehicle {

    // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php
    // and pick 2 randomly for each instance.
    static private String[] names = {"Scorpion", "Expedition", "Desire", "Barrage", "Scout",
            "Orbit", "Instinct", "Dragon", "Might", "Capital", "Bullet", "Twister", "Basilisk", "Eminance", "Expedition",
            "Dynamics", "Revelation", "Blast", "Paradox", "Tarragon"};

    public Car() {
        Random rand = new Random();
        name = names[rand.nextInt(20)] + " " + names[rand.nextInt(20)];
        speed = rand.nextInt(31) + 80;
            // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    }

    public void moveForAnHour(Race race) {
        // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!

        if (race.isThereABrokenTruck()) {
            distanceTraveled += 75;
            System.out.println(name + "traveled: 75 km in this hour");
                // If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
        } else {
            distanceTraveled += speed;
            System.out.println(name + "traveled: "+ speed + "km in this hour");
        }
        System.out.println(name + "'s total distance traveled: " + distanceTraveled);
        System.out.println(" ");
    }

}
