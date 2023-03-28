package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Runner;
import edu.neumont.csc150.model.Tank;
import edu.neumont.csc150.model.Walker;
import edu.neumont.csc150.model.Zombie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ZombieUI {
    //anything interacting with the user
    //System.out.println();

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getIntegerFromUser(int min, int max) throws IOException {
        int number;
        do {
            try {
                number = Integer.parseInt(in.readLine());
                //check if in range, otherwise repeat
                return number;
            } catch(NumberFormatException ex) {
                System.out.println("Invalid number");
            }
        } while(true);
    }

    public void displayMenu() {
        System.out.println("What would you like to do?\r\n" +
                "\t1 - Generate 1 zombie\r\n" +
                "\t2 - Generate some zombies\r\n" +
                "\t3 - Generate n zombies\r\n" +
                "\t4 - Exit");
    }

    public void displayZombies(ArrayList<Zombie> horde) {
        for (int i = 0; i < horde.size(); i++) {
            Zombie z = horde.get(i);
            System.out.println((i + 1) + " - " + z);
        }
    }

    public void displayHowManyZombies() {
        System.out.println("How many zombies would you like to make?");
    }

    public void displayFarewellMessage() {
        System.out.println("See you next time!");
    }
}
