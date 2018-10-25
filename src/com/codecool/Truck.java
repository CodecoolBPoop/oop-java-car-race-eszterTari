package com.codecool;

import java.util.Random;

public class Truck extends Vehicle {

    boolean isItOkay;
    int hoursStopped;
        // holds how long its still broken down.

    public Truck() {
        Random rand = new Random();
        int nameNumber = rand.nextInt(1001);
        name = String.valueOf(nameNumber);
            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
        speed = 100;
            // speed: 100km/h. 5% chance of breaking down for 2 hours.
        isItOkay = true;
        hoursStopped = 0;
    }

    public boolean isItBrokenDown() {
        Random randomBreakDown = new Random();
        int isItBrokenDown = randomBreakDown.nextInt(101);
        if (isItBrokenDown <= 5) {
            return true;
        }
        return false;
    }

    public void moveForAnHour(Race race, boolean isATruckBrokenForThisHour) {
        if (!isItOkay) {
            distanceTraveled += 0;
            System.out.println(name + " stopped in this hour because of a breakdown");
        } else if (isATruckBrokenForThisHour) {
            distanceTraveled += 75;
            System.out.println(name + " travelled: 75 km in this hour because of a broken truck");
        }
        else {
            distanceTraveled += speed;
            System.out.println(name + " travelled: " + speed + "km in this hour");
        }
        System.out.println(name + "'s total distance travelled: " + distanceTraveled + " km");
        System.out.println(" ");
    }
}
