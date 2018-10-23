package com.codecool;

import java.util.Random;

public class Motorcycle {

    int speed = 100;
    Random speedRandom = new Random();
    int speedRain = speed - (speedRandom.nextInt(46) + 5);
        // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
    static int nameNumber;
        // The number of the instance created. Used for its name.


    String name;
        // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    int distanceTraveled = 0;
    public void moveForAnHour(Race race) {

    }
}
