package com.codecool;

public class Vehicle {

    String name;
    int speed;
    int distanceTraveled = 0;

    public void moveForAnHour(Race race){
        this.distanceTraveled += speed;
    }

    public String getName(){
        return name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getDistanceTraveled() {
        return distanceTraveled;
    }
}