package com.codecool;

import java.util.Random;

public class Motorcycle extends Vehicle {


    static int nameNumber = 1;
        // The number of the instance created. Used for its name.

    public Motorcycle() {
        name = "Motorcycle" + nameNumber;
            // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
        speed = 100;
        nameNumber++;
    }

    public static int getSpeedRain(int normalSpeed) {
        Random speedRandom = new Random();
        int speedInRain = normalSpeed - (speedRandom.nextInt(46) + 5);
        return speedInRain;
    }

    public void moveForAnHour(Race race) {
        if (race.isItRaining() && race.isThereABrokenTruck()) {
            int tempSpeed = getSpeedRain(speed);
            if (tempSpeed > 75) {
                distanceTraveled += 75;
                System.out.println(name + "traveled: 75 km in this hour because of a broken truck");
            } else {
                distanceTraveled += tempSpeed;
                System.out.println(name + "traveled: " + tempSpeed + "km in this hour because of the rain");
            }
        }
        else if (race.isItRaining()) {
            // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
            distanceTraveled += getSpeedRain(speed);
            System.out.println(name + "traveled: " + speed + "km in this hour because of the rain");
        }
        else if (race.isThereABrokenTruck()) {
            if (speed > 75) {
                distanceTraveled += 75;
                System.out.println(name + "traveled: 75 km in this hour because of a broken down truck");
            }
        } else {
            distanceTraveled += speed;
            System.out.println(name + "traveled: " + speed + "km in this hour");
        }
        System.out.println(name + "'s total distance traveled: " + distanceTraveled);
        System.out.println(" ");
    }
}
