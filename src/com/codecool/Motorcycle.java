package com.codecool;

import java.util.Random;

public class Motorcycle extends Race {

    static int Motorspeed = 100;
        // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
    static int nameNumber;
        // The number of the instance created. Used for its name.


    String name;
        // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    static int motorDistanceTraveled = 0;

    public static int getMotorspeed() {
        return Motorspeed;
    }

    public static int getSpeedRain() {
        Random speedRandom = new Random();
        int speedRain = Motorspeed - (speedRandom.nextInt(46) + 5);
        return speedRain;
    }

    public void moveForAnHour(Race race) {

    }
}
