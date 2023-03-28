package edu.neumont.csc150.model;

import java.util.concurrent.ThreadLocalRandom;

public class Tank extends Zombie {
    public static final int MIN_BASE_HP = 45;
    public static final int MAX_BASE_HP = 70;
    public static final int MIN_SPEED = 4;
    public static final int MAX_SPEED = 8;
    public static final int MIN_DAMAGE_MODIFIER = 10;
    public static final int MAX_DAMAGE_MODIFIER = 20;
    private int damageModifier;
    private int damage;
    private String attack;

    public Tank() {}

    public Tank(int arms, int legs, int baseHP, int speed, int damageModifier) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
        setDamageModifier(damageModifier);
    }

    @Override
    public void setBaseHP(int baseHP) {
        this.baseHP = ThreadLocalRandom.current().nextInt(MIN_BASE_HP, MAX_BASE_HP) + 1;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = ThreadLocalRandom.current().nextInt(MIN_SPEED, MAX_SPEED) + 1;
    }

    public void setDamageModifier(int damageModifier) {
        this.damageModifier = ThreadLocalRandom.current().nextInt(MIN_DAMAGE_MODIFIER, MAX_DAMAGE_MODIFIER) + 1;
    }

    @Override
    public int attack(int rollValue) {
        if (rollValue == 20) {
            damage = (roll(3, 6) + damageModifier) * 3;
        } else if (rollValue >= 10 && rollValue <= 19) {
            damage = roll(3, 6) + damageModifier;
        } else {
            damage = 0;
        }
        return damage;
    }

    @Override
    public String getAttackType(int rollValue) {
        if (rollValue == 20) {
            attack = "Critical Hit! Damage modifier: " + damageModifier;
        } else if (rollValue >= 10 && rollValue <= 19) {
            attack = "Hit! Damage modifier: " + damageModifier;
        } else {
            attack = "Miss";
        }
        return attack;
    }

    @Override
    public String toString() {
        return "{ Tank - " +
                super.toString() +
                attack +
                " Damage: " + damage +
                " }";
    }
}
