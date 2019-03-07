package edu.neumont.csc150.model.scores;

import java.io.Serializable;

public class Score implements Serializable {

    private int score;
    private String name;

    public Score(String name, int score){
        this.setName(name);
        this.setScore(score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
