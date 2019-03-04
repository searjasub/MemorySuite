package edu.neumont.csc150.model;

public enum Difficulty {
    
    EASY(99), MEDIUM(999), HARD(9999);

    int numGame;

    Difficulty(int numGame) {
        this.numGame = numGame;
    }

    public int getNumGame() {
        return numGame;
    }

    public void setNumGame(int numGame) {
        this.numGame = numGame;
    }
}
