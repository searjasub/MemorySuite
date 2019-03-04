package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Difficulty;
import edu.neumont.csc150.model.NumberBoard;

public class NumberGameController {
    private NumberBoard board = new NumberBoard();

    private int numAmount = 5;


    public int getNumAmount() {
        return numAmount;
    }

    public void setNumAmount(int numAmount) {
        this.numAmount = numAmount;
    }

    public void init(Difficulty difficulty) {
        generateNumbers(difficulty);
    }

    private void generateNumbers(Difficulty difficulty) {
        this.board.getNumbers().clear();
        for (int i = 0; i < numAmount; i++) {
            this.board.getNumbers().add((int) (Math.random() * difficulty.getNumGame() + 1));
        }
        this.numAmount++;
    }
}
