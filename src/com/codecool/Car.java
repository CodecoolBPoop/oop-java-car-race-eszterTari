package com.codecool;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Car extends Race {

    static Random randspeed = new Random();
    static int carSpeed = randspeed.nextInt(31) + 80;
            // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    // List<String> nameList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<String>(Arrays.asList("Scorpion", "Expedition", "Desire", "Barrage", "Scout",
            "Orbit", "Instinct", "Dragon", "Might", "Capital", "Bullet", "Twister", "Basilisk", "Eminance", "Expedition",
            "Dynamics", "Revelation", "Blast", "Paradox", "Tarragon"));

    Random name1 = new Random();
    Random name2 = new Random();
    int firstNameIndex = name1.nextInt(20);
    int secondNameIndex = name2.nextInt(20);


    String name = nameList.get(firstNameIndex) + " " + nameList.get(secondNameIndex);
        // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php
        // and pick 2 randomly for each instance.
    static int carDistanceTraveled = 0;
        // holds the current distance traveled.

    public static int getCarSpeed() {
        return carSpeed;
    }

    public void moveForAnHour(Race race) {
        // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
        // If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
    }

}
