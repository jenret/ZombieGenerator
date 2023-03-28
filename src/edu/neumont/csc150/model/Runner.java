package edu.neumont.csc150.model;

import java.util.concurrent.ThreadLocalRandom;

public class Runner extends Zombie {
    public static final int MIN_BASE_HP = 10;
    public static final int MAX_BASE_HP = 20;
    public static final int MIN_SPEED = 15;
    public static final int MAX_SPEED = 25;
    private int damage;
    private String attack;

    public Runner() {}

    public Runner(int arms, int legs, int baseHP, int speed) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    @Override
    public void setBaseHP(int baseHP) {
        this.baseHP = ThreadLocalRandom.current().nextInt(MIN_BASE_HP, MAX_BASE_HP) + 1;
    }

    public int getClimbSpeed(int speed) {
        return speed / 3;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = ThreadLocalRandom.current().nextInt(MIN_SPEED, MAX_SPEED) + 1;
    }

    @Override
    public int attack(int rollValue) {
        if (rollValue == 20 || rollValue == 19) {
            damage = roll(2, 8) * 2;
        } else if (rollValue >= 5 && rollValue <= 18) {
            damage = roll(2, 8);
        } else {
            damage = 0;
        }
        return damage;
    }

    @Override
    public String getAttackType(int rollValue) {
        if (rollValue == 20 || rollValue == 19) {
            attack = "Critical Hit!";
        } else if (rollValue >= 5 && rollValue <= 18) {
            attack = "Hit!";
        } else {
            attack = "Miss";
        }
        return attack;
    }

    @Override
    public String toString() {
        return "{ Runner - " +
                super.toString() +
                "Climb speed: " + getClimbSpeed(speed) +
                " | " + attack +
                " Damage done: " + damage +
                " }";
    }
}