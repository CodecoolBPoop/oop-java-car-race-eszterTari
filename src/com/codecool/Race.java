package com.codecool;

import java.util.ArrayList;

public class Race {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Motorcycle> motors = new ArrayList<>();
    private ArrayList<Truck> trucks = new ArrayList<>();

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

    public void simulateRace() {
        // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        for (int i = 1; i <= 50; i++) {
            System.out.println("HOUR: " + i);
            boolean raining = isItRaining();
            if (raining) {
                System.out.println("*** It's raining! ***");
            }
            System.out.println("---------------------------------");
            boolean isATruckBrokenForThisHour = isATruckBrokenForThisHour();
            for (Truck truck: trucks) {
                truck.moveForAnHour(this, isATruckBrokenForThisHour);
            }
            for (Car car: cars) {
                car.moveForAnHour(this, isATruckBrokenForThisHour);
            }
            for (Motorcycle motor: motors) {
                motor.moveForAnHour(this, raining, isATruckBrokenForThisHour);
            }
            isATruckAtSecondStoppedHour();
        }
        System.out.println("End of the race! ");
    }

    public boolean isATruckBrokenForThisHour() {
        int truckBrokenDown = 0;
        for (Truck truck: trucks) {
            if (!truck.isItOkay) {
                truck.hoursStopped++;
                truckBrokenDown++;
            } else {
                boolean isItBrokenDown = truck.isItBrokenDown();
                if (isItBrokenDown) {
                    truck.isItOkay = false;
                    truck.hoursStopped++;
                }
            }
        }
        if (truckBrokenDown > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void isATruckAtSecondStoppedHour() {
        for (Truck truck: trucks) {
            if (truck.hoursStopped == 2) {
                truck.hoursStopped = 0;
                truck.isItOkay = true;
            }
        }
    }

    public void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        for (Car car: cars) {
            System.out.format("Name: %-22s Total distance traveled: %-2s km \tType: %-10s \n", car.getName(),
                    car.getDistanceTraveled(), car.getClass().getSimpleName());
//            System.out.println("Name: " + car.getName() +
//                    "\t\t\t\tTotal distance traveled: " + car.getDistanceTraveled() + " km" +
//                    "\t\t\t\tType: " + car.getClass().getSimpleName());
        }
        for (Motorcycle motor: motors) {
            System.out.format("Name: %-22s Total distance traveled: %-2s km \tType: %-10s \n", motor.getName(),
                    motor.getDistanceTraveled(), motor.getClass().getSimpleName());
//            System.out.println("Name: " + motor.getName() +
//                    "\t\t\tTotal distance traveled: " + motor.getDistanceTraveled() + " km" +
//                    "\t\t\tType: " + motor.getClass().getSimpleName());
        }
        for (Truck truck: trucks) {
            System.out.format("Name: %-22s Total distance traveled: %-2s km \tType: %-10s \n", truck.getName(),
                    truck.getDistanceTraveled(), truck.getClass().getSimpleName());
//            System.out.println("Name: " + truck.getName() +
//                    "\t\t\tTotal distance traveled: " + truck.getDistanceTraveled() + " km" +
//                    "\t\t\tType: " + truck.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.createVehicles();
        race.simulateRace();
        race.printRaceResults();
    }
}
