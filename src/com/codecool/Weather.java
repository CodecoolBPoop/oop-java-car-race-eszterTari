package com.codecool;

import java.util.Random;

public class Weather extends Race {

    public Weather(){}

    public static int setRaining() {
        // 30% chance of rain.
        Random calcChance = new Random();
        int chance = calcChance.nextInt(101);
        return chance;
    }

    public static boolean isRaining(int chance) {
        // is it raining currently.
        if (chance <= 30) {
            return true;
        }
        return false;
    }
}