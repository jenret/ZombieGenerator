package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Runner;
import edu.neumont.csc150.model.Tank;
import edu.neumont.csc150.model.Walker;
import edu.neumont.csc150.model.Zombie;
import edu.neumont.csc150.view.ZombieUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class ZedGenerator {
    Random random = new Random();
    private ZombieUI ui = new ZombieUI();
    private ArrayList<Zombie> horde = new ArrayList<>();

    public void run() throws IOException {
        boolean keepLooping = true;
        while(keepLooping) {
            ui.displayMenu();
            int selection = ui.getIntegerFromUser(1, 4);
            switch (selection) {
                case 1:
                    doAddOneZombie();
                    break;
                case 2:
                    doAddSomeZombies();
                    break;
                case 3:
                    doAddNZombies();
                    break;
                case 4:
                    doFarewell();
                    keepLooping = false;
                    break;
            }
        }
    }

    private void doAddSomeZombies() {
        this.horde.clear();
        int howManyZombies = random.nextInt(1, 10);
        generateZombies(howManyZombies);
        setStatsOnZombie(horde);
        setAttackOnZombie(horde);
        ui.displayZombies(horde);
    }

    private void doFarewell() {
        ui.displayFarewellMessage();
    }

    private void doAddOneZombie() {
        this.horde.clear();
        generateZombies(1);
        setStatsOnZombie(horde);
        setAttackOnZombie(horde);
        ui.displayZombies(horde);
    }

    public void doAddNZombies() throws IOException {
        this.horde.clear();
        ui.displayHowManyZombies();
        int howManyZombies = ui.getIntegerFromUser(1, Integer.MAX_VALUE);
        generateZombies(howManyZombies);
        setStatsOnZombie(horde);
        setAttackOnZombie(horde);
        ui.displayZombies(horde);
    }

    public void generateZombies(int howManyZombies) {
        for (int i = 0; i < howManyZombies; i++) {
            int z = random.nextInt(1,4);
            switch (z) {
                case 1:
                    Walker walker = new Walker();
                    horde.add(walker);
                    break;
                case 2:
                    Runner runner = new Runner();
                    horde.add(runner);
                    break;
                case 3:
                    Tank tank = new Tank();
                    tank.setDamageModifier(0);
                    horde.add(tank);
                    break;
            }
        }
    }

    public void setStatsOnZombie(ArrayList<Zombie> horde) {
        for (int i = 0; i < horde.size(); i++) {
            Zombie z = horde.get(i);
            z.setArms(RandomNum(0,2));
            z.setLegs(0);
            z.setBaseHP(0);
            z.setSpeed(0);
        }
    }

    public int RandomNum(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max) + 1;
    }

    public void setAttackOnZombie(ArrayList<Zombie> horde) {
        for (int i = 0; i < horde.size(); i++) {
            Zombie z = horde.get(i);
            int rollValue = z.roll(1, 20);
            z.attack(rollValue);
            z.getAttackType(rollValue);
        }
    }
}
