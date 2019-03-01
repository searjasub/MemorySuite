package edu.neumont.csc150.controller;

import edu.neumont.csc150.view.MemoryGameView;

public class MemoryGameController {

    MemoryGameView view;
    private int lives;
    private double timer;
    private int gridSize;

    public MemoryGameController(MemoryGameView ui) {
        view = ui;
        view.registerController(this);
        lives = view.getLives();
        timer = view.getTimer();
        gridSize = view.getGridSize();

    }


}
