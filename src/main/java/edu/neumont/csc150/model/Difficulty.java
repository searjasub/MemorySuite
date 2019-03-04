package edu.neumont.csc150.model;

public enum Difficulty {
    EASY, MEDIUM, HARD;


    public int getNumgame(Difficulty difficulty) {
        int numGame;
        if (difficulty == Difficulty.EASY){
            numGame = 99;
        }else if(difficulty == Difficulty.MEDIUM){
            numGame = 999;
        }else{
            numGame = 9999;
        }
        return numGame;
    }
}
