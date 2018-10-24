package com.codecool;

import java.util.Random;

public class Truck extends Vehicle {

    int breakdownTurnsLeft;
        // holds how long its still broken down.
    boolean isItOkay;

    public Truck() {
        Random rand = new Random();
        int nameNumber = rand.nextInt(1001);
        name = String.valueOf(nameNumber);
            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
        speed = 100;
            // speed: 100km/h. 5% chance of breaking down for 2 hours.
        isItOkay = true;
    }

    public static boolean isItBrokenDown() {
        Random randomBreakDown = new Random();
        int isItBrokenDown = randomBreakDown.nextInt(101);
        if (isItBrokenDown <= 5) {
            return true;
        }
        return false;
    }

    public void moveForAnHour(Race race) {
        boolean isItBrokenDown = isItBrokenDown();
        if (isItBrokenDown) {
            distanceTraveled += 0;
            isItOkay = false;
            System.out.println(name + "stopped in this hour because of a breaking down");
        }
        else if (!isItOkay) {
            distanceTraveled += 0;
            isItOkay = true;
            System.out.println(name + "stopped in this hour because of a breaking down");
        } else {
            distanceTraveled += speed;
            System.out.println(name + "traveled: " + speed + "km in this hour");
        }
        System.out.println(name + "'s total distance traveled: " + distanceTraveled);
        System.out.println(" ");
    }
}
