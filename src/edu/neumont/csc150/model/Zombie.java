package edu.neumont.csc150.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Zombie {
    protected int arms;
    protected int legs;
    protected int baseHP;
    protected int speed;
    private Random random = new Random();

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = ThreadLocalRandom.current().nextInt(0, 2) + 1;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public abstract void setBaseHP(int baseHP);

    public int getSpeed() {
        return speed;
    }

    public abstract void setSpeed(int speed);

    public int roll(int numberOfDice, int numberOfSides) {
        int damage = 0;
        for (int i = 0; i < numberOfDice; i++) {
            damage = damage + random.nextInt(1, numberOfSides);
        }
        return damage;
    }

    public abstract int attack(int rollValue);

    /**
     * This method returns the damage type based on the attack roll value
     * @param rollValue Attack roll value
     * @return The string representation of the attack
     */
    public abstract String getAttackType(int rollValue);


    @Override
    public String toString() {
        return "Arms: " + arms +
                " | Legs: " + legs +
                " | HP: " + baseHP +
                " | Speed: " + speed +
                " | ";
    }
}
