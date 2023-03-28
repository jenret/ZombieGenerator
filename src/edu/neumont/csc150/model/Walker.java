package edu.neumont.csc150.model;

import java.util.concurrent.ThreadLocalRandom;

public class Walker extends Zombie {
    public static final int MIN_BASE_HP = 15;
    public static final int MAX_BASE_HP = 30;
    public static final int MIN_SPEED = 6;
    public static final int MAX_SPEED = 10;
    private int damage;
    private String attack;


    public Walker() {}

    public Walker(int arms, int legs, int baseHP, int speed) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    @Override
    public void setBaseHP(int baseHP) {
        this.baseHP = ThreadLocalRandom.current().nextInt(MIN_BASE_HP,MAX_BASE_HP) + 1;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = ThreadLocalRandom.current().nextInt(MIN_SPEED, MAX_SPEED) + 1;
    }

    @Override
    public int attack(int rollValue) {
        if (rollValue == 20) {
            damage = roll(3, 6) * 2;
        } else if (rollValue >= 8 && rollValue <= 19) {
            damage = roll(3, 6);
        } else {
            damage = 0;
        }
        return damage;
    }

    @Override
    public String getAttackType(int rollValue) {
        if (rollValue == 20) {
            attack = "Critical Hit!";
        } else if (rollValue >= 8 && rollValue <= 19) {
            attack = "Hit!";
        } else {
            attack = "Miss";
        }
        return attack;
    }

    @Override
    public String toString() {
        return "{ Walker - " +
                super.toString() +
                attack +
                " Damage done: " + damage +
                " }";
    }
}