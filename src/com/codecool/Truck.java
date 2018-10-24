package com.codecool;

import java.util.Random;

public class Truck extends Race {

    static int truckSpeed = 100;
        // speed: 100km/h. 5% chance of breaking down for 2 hours.
    Random rand = new Random();
    int nameNumber = rand.nextInt(1001);
        // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    int breakdownTurnsLeft;
        // holds how long its still broken down.
    int distanceTraveled = 0;

    public static int getTruckSpeed() {
        return truckSpeed;
    }

    public static boolean isItBrokenDown() {
        Random randomBreakDown = new Random();
        int isItBrokenDown = randomBreakDown.nextInt(21); // int 1 / 5% from 0 to 20
        if (isItBrokenDown <= 1) {
            return true;
        }
        return false;
    }

    public void moveForAnHour(Race race) {

    }
}
