package com.codecool;

public class Race {

    static int carSpeed;
    static int motorSpeed;
    static int truckSpeed;
    static int speedLimitWhenTruckBroken = 75;
    static int carDistance;
    static int motorDistance;
    static int truckDistance;
    static boolean truckIsOkay = true;

    public static void moveForAnHour() {
        // Race race
        // get the 3 vehicles' speed

        motorSpeed = motorSpeedWhetherItsRaining();
        carSpeed = Car.getCarSpeed();
        if (truckIsOkay) {
            truckSpeed = Truck.getTruckSpeed();
        } else {
            truckSpeed = 0;
            truckIsOkay = true;
        }

        boolean isThereABrokenDownTruck = Truck.isItBrokenDown();
        if (isThereABrokenDownTruck) {
            truckSpeed = 0;
            truckIsOkay = false;
            carSpeed = speedLimitWhenTruckBroken;
            if (motorSpeed > speedLimitWhenTruckBroken) {
                motorSpeed = speedLimitWhenTruckBroken;
            }
        }

        // calc the 3 vehicles' distance / 1 hour
        carDistance = carDistance + carSpeed;
        motorDistance = motorDistance + motorSpeed;
        truckDistance = truckDistance + truckSpeed;
    }

    public static int motorSpeedWhetherItsRaining() {
        int motorSpeedValue;
        int chaneOfRain = Weather.setRaining();
        boolean isItRaining = Weather.isRaining(chaneOfRain);
        if (isItRaining) {
            motorSpeedValue = Motorcycle.getSpeedRain();
        } else {
            motorSpeedValue = Motorcycle.getMotorspeed();
        }
        return motorSpeedValue;
    }

    public void createVehicles() {
        // creates 10 cars, 10 trucks and 10 motorcycles.
    }

    public static void simulateRace() {
        // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        int i = 1;
        do {
            moveForAnHour();
            i++;
        } while (i <= 50);
    }

    public static void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        System.out.println("The car's distance:" + carDistance);
        System.out.println("The motorcycle's distance:" + motorDistance);
        System.out.println("The truck's distance:" + truckDistance);
    }

/*    public boolean isThereABrokenTruck() {

    }*/

    public static void main(String[] args) {
	// write your code here
        simulateRace();
        printRaceResults();
    }
}
