package edu.neumont.csc150.model;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int lives;
    private int score;
    private int multiplier = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier += multiplier;
    }
}
