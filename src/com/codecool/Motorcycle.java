package com.codecool;

import java.util.Random;

public class Motorcycle extends Vehicle {

    static int nameNumber = 1;
        // The number of the instance created. Used for its name.
    int speedLimitWhenTruckBroken = 75;

    public Motorcycle() {
        name = "Motorcycle " + nameNumber;
            // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
        speed = 100;
        nameNumber++;
    }

    public static int getSpeedRain(int normalSpeed) {
        Random speedRandom = new Random();
        int speedInRain = normalSpeed - (speedRandom.nextInt(46) + 5);
        return speedInRain;
    }

    public void moveForAnHour(Race race, boolean raining, boolean isThereABrokenTruck) {
        // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
        if (isThereABrokenTruck) {
            if (raining) {
                int speedRain = getSpeedRain(speed);
                if (speedRain > speedLimitWhenTruckBroken) {
                    distanceTraveled += speedLimitWhenTruckBroken;
                    System.out.println(name + " travelled: 75 km in this hour because of a broken truck in the rain");
                } else {
                    distanceTraveled += speedRain;
                    System.out.println(name + " travelled: " + speedRain + " km in this hour because of the rain (also there was a broken truck)");
                }
            } else {
                distanceTraveled += speedLimitWhenTruckBroken;
                System.out.println(name + " travelled: 75 km in this hour because of a broken truck");
            }
        } else {
            if (raining) {
                int speedInRain = getSpeedRain(speed);
                distanceTraveled += speedLimitWhenTruckBroken;
                System.out.println(name + " travelled: " + speedInRain + " km in this hour because of the rain");
            } else {
                distanceTraveled += speed;
                System.out.println(name + " travelled: " + speed + " km");
            }
        }
        System.out.println(name + "'s total distance travelled: " + distanceTraveled + " km");
        System.out.println(" ");
    }
}
