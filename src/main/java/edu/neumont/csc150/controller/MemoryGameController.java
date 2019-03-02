package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameView;

public class MemoryGameController {

    private MemoryGameView view;
    private Player player = new Player();
    private int lives;
    private double timer;
    private int gridSize;

    public MemoryGameController(MemoryGameView ui) {
        view = ui;
        view.registerController(this);
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

}
