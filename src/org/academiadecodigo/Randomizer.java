package org.academiadecodigo;

public class Randomizer {

    /**
     * RANDOMIZER CLASS
     * enerates a random integer between min and max
     */

    public static int getRandomInt(int min, int max){

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
