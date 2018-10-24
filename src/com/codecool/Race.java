package com.codecool;

import com.codecool.Vehicle;
import java.util.ArrayList;

public class Race {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Motorcycle> motors = new ArrayList<>();
    private ArrayList<Truck> trucks = new ArrayList<>();

    static int speedLimitWhenTruckBroken = 75;
    static boolean truckIsOkay = true;

    public void createVehicles() {
        // creates 10 cars, 10 trucks and 10 motorcycles.
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
            motors.add(new Motorcycle());
            trucks.add(new Truck());
        }
    }

    public boolean isItRaining() {
        int chanceOfRain = Weather.setRaining();
        boolean raining = Weather.isRaining(chanceOfRain);
        return raining;
    }

    public static void simulateRace() {
        // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        int i = 1;
        do {
            System.out.println("Hour: " + i);
            moveForAnHour();
            i++;
        } while (i <= 50);
    }

    public void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        for (Car car: cars) {
            System.out.println("Car name: " + car.getName() +
                    "Total distance traveled: " + car.getDistanceTraveled() + "km");
        }
        for (Motorcycle motor: motors) {
            System.out.println("Motorcycle name: " + motor.getName() +
                    "Total distance traveled: " + motor.getDistanceTraveled() + "km");
        }
        for (Truck truck: trucks) {
            System.out.println("Truck name: " + truck.getName() +
                    "Total distance traveled: " + truck.getDistanceTraveled() + "km");
        }
    }

    public boolean isThereABrokenTruck() {
        return false;
    }

    public static void main(String[] args) {
	// write your code here
        simulateRace();
        printRaceResults();
    }
}
